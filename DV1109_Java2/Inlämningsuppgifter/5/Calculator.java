// Per Sundberg
import javax.swing.*; // Grafiska komponenter.
import java.awt.*; // Layouts.
import java.awt.event.*; // Händelsehantering för knappar.

public class Calculator extends JFrame implements ActionListener {

    //Instansvariabler.
    //Huvudbehållare för allt innehåll i fönstret.
    private Container cont;
    //I dessa fält läggs Tal1, Tal2 och resultat in.
    private JTextField number1TextField, number2TextField, resultTextField;

    //Konstanter.
    //Längden på kalkylatorfönstret.
    public static final int HORIZONTAL_SIZE = 150;
    //Höjden på kalkylatorfönstret.
    public static final int VERTICAL_SIZE = 300;
    //Antalet grid-x positioner för ActionButtonsPanel.
    public static final int ACTION_BUTTON_GRID_X = 2;
    //Antalet grid-y positioner för ActionButtons.
    public static final int ACTION_BUTTON_GRID_Y = 2;
    //Antalet grid-x positioner för NumberFieldPanel.
    public static final int NUMBER_FIELD_GRID_X = 2;
    //Antalet grid-y positioner för NumberFieldPanel.
    public static final int NUMBER_FIELD_GRID_Y = 2;
    //Antalet grid-x positioner för ResultFieldPanel.
    public static final int RESULT_PANLEL_GRID_X = 1;
    //Antalet grid-y positioner för ResultFieldPanel.
    public static final int RESULT_PANLEL_GRID_Y = 2;
    //Horizontal gap för GridLayout.
    public static final int GRID_HGAP = 5;
    //Vertical gap för GridLayout.
    public static final int GRID_VGAP = 5;
    //X-Dimension för TextField.
    public static final int DIMENSION_X = 100;
    //Y-Dimension för TextField.
    public static final int DIMENSION_Y = 50;
    //Begränsning av antalet siffror i resultatet.
    public static final int RESULT_DISPLAY_LIMIT = 9;

    //Konstruktor.
    public Calculator() {
        super(); //Anropar JFrames konstruktor.
        setSize(HORIZONTAL_SIZE, VERTICAL_SIZE); //Sätter storleken.
        setTitle("Kalkylator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Skapa innehåll.
        cont = getContentPane();
        cont.setLayout(new BorderLayout()); //Sätter layout för huvudbehållaren.

        buildNumberFieldPanel();
        buildActionButtonPanel();
        buildResultPanel();
    }

    //I den här metoden räknas resultatet ut och skickas till resultatTextFältet.
    private void calculateResult(ActionEvent e) {
        double sum = 0;
        String strSum = "";
        String strNumber1 = number1TextField.getText(); //Här hämtar vi tal1.
        String strNumber2 = number2TextField.getText(); //Här hämtar vi tal2.

        double value1 = Double.parseDouble(strNumber1);
        double value2 = Double.parseDouble(strNumber2);

        //Kolla om det är +,-,x eller /.
        if (e.getActionCommand().equals("+"))
            sum = value1 + value2; //Addition.
        if (e.getActionCommand().equals("-"))
            sum = value1 - value2; //Subtraktion.
        if (e.getActionCommand().equals("/"))
            sum = value1 / value2; //Division.
        if (e.getActionCommand().equals("*"))
            sum = value1 * value2; //Multiplikation.    

        // Ta bort .0 om suman blir ett heltal.
        strSum = Double.toString(sum);
        if (strSum.endsWith(".0"))
            strSum = strSum.replace(".0", "");

        //Här begränsar vi utskriften då vi får fler än antal siffror
        //som får plats i resultatet.
        if (strSum.length() > RESULT_DISPLAY_LIMIT)
            strSum = strSum.substring(0, RESULT_DISPLAY_LIMIT);

        //Här lägger vi in strSum till resultatutskriften.
        resultTextField.setText(strSum);
    }

    //Från interfacet ActionListener.
    public void actionPerformed(ActionEvent e) {

        //Här kollar vi ifall det skrivs in +,-,/ eller * före tal
        //Om så är fallet skriver vi in 0 som tal så att programmet inte 
        //kraschar.
        if (number2TextField.getText().equals("")) {
            number2TextField.setText("0");
        }
        if (number1TextField.getText().equals("")) {
            number1TextField.setText("0");
        }
        calculateResult(e);
    }

    //I den här metoden hämtar vi vilken sorts beräkning som ska utföras.
    private void buildActionButtonPanel() {
        //Skapa panelen.
        JPanel panel =
            new JPanel(new GridLayout(ACTION_BUTTON_GRID_X, ACTION_BUTTON_GRID_Y, GRID_HGAP,
                GRID_VGAP));

        //Lägg till knappar till panelen.
        JButton button = new JButton("+");
        button.addActionListener(this);
        panel.add(button);

        button = new JButton("-");
        button.addActionListener(this);
        panel.add(button);

        button = new JButton("*");
        button.addActionListener(this);
        panel.add(button);

        button = new JButton("/");
        button.addActionListener(this);
        panel.add(button);

        //Lägg till i fönsterbehållaren.
        cont.add(panel, BorderLayout.CENTER);
    }

    //I denna metod hämtar lägger vi ut tal 1 och tal 2 som ska skrivas in.
    private void buildNumberFieldPanel() {

        JPanel panel =
            new JPanel(new GridLayout(NUMBER_FIELD_GRID_X, NUMBER_FIELD_GRID_Y, GRID_HGAP,
                GRID_VGAP));

        JLabel label = new JLabel("Tal 1:");
        JLabel label2 = new JLabel("Tal 2:");

        number1TextField = new JTextField();
        number2TextField = new JTextField();

        //Här sätter vi storlekten på Text-fälten.
        number1TextField.setPreferredSize(new Dimension(DIMENSION_X, DIMENSION_Y));
        number2TextField.setPreferredSize(new Dimension(DIMENSION_X, DIMENSION_Y));

        number1TextField.setEditable(true); //Möjliggör inmatning från användaren.
        number2TextField.setEditable(true); //Möjliggör inmatning från användaren.

        panel.add(label);
        panel.add(number1TextField);
        panel.add(label2);
        panel.add(number2TextField);

        cont.add(panel, BorderLayout.NORTH);
    }

    //I denna metod visar vi resultatet.
    private void buildResultPanel() {

        JPanel panel =
            new JPanel(new GridLayout(RESULT_PANLEL_GRID_X, RESULT_PANLEL_GRID_Y, GRID_HGAP,
                GRID_VGAP));

        JLabel resultLabel = new JLabel("Result:");

        resultTextField = new JTextField();

        //Här sätter vi storleken på resultatfältet.
        resultTextField.setPreferredSize(new Dimension(DIMENSION_X, DIMENSION_Y));

        resultTextField.setEditable(false); //Hindrar inmatning från användaren.
        resultTextField.setBackground(Color.white);

        panel.add(resultLabel);
        panel.add(resultTextField);

        cont.add(panel, BorderLayout.SOUTH);
    }

    //Main-metod.
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        calc.setVisible(true);
    }

}
