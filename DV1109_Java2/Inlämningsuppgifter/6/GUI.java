// Namn: Per Sundberg
import javax.swing.*; // för grafiska komponenter
import java.awt.event.*; // för knapphantering
import java.awt.*; // för layouts
import java.util.Scanner;

public class GUI extends JFrame implements ActionListener
{
    //Instansvariabler.
    private Logic logic;
    private Container cont; //fönstrets huvudbehållare för grafiska komponenter
    private JList<Runner> runnerList;
    private JTextField nameField, startNrField, finishTimeField, licenseNrField;
    private JTextField clubField, hasOrderedTshirtField;

    //main-metod.
    public static void main(String[] args)
    {
        GUI frame = new GUI();
        frame.setVisible(true);
    }

    //Konstruktor.
    public GUI()
    {
        super();
        initiateInstanceVariables();
        buildFrame();
    }

    //Instaniera globala variabler som måste kommas åt i hela klassen.
    private void initiateInstanceVariables()
    {
        logic = new Logic();
        cont = getContentPane();
        nameField = new JTextField();
        nameField.setBorder(BorderFactory.createTitledBorder("Namn:"));
        startNrField = new JTextField();
        startNrField.setBorder(BorderFactory.createTitledBorder("Startnummer:"));
        finishTimeField = new JTextField();
        finishTimeField.setBorder(BorderFactory.createTitledBorder("Tid (tex 45.00):"));
        hasOrderedTshirtField = new JTextField();
        hasOrderedTshirtField.setBorder(BorderFactory
            .createTitledBorder("Har Beställt Tshirt(ja/nej):"));
        licenseNrField = new JTextField();
        licenseNrField.setBorder(BorderFactory.createTitledBorder("Licensenummer:"));
        clubField = new JTextField();
        clubField.setBorder(BorderFactory.createTitledBorder("Klubb:"));

        runnerList = new JList<Runner>();
        runnerList.setBorder(BorderFactory.createTitledBorder("Löpare: <E:Elit, M:Motionär>"));
    }

    //Här bygger vi upp huvudgrafik-sidan.
    private void buildFrame()
    {
        setTitle("Löpar-tävling");
        setSize(550, 300);
        cont.setLayout(new GridLayout(1, 3));

        //Här bygger vi upp den vänstra panelen med knappar.
        JPanel leftPanel = new JPanel(new GridLayout(6, 1));
        JButton addNormalRunnerButton = new JButton("Lägg till Motionslöpare");
        addNormalRunnerButton.addActionListener(this);
        addNormalRunnerButton.setActionCommand("AddNormalRunner");
        leftPanel.add(addNormalRunnerButton);

        JButton showMotionRunnerButton = new JButton("Visa MotionsLöpare");
        showMotionRunnerButton.addActionListener(this);
        showMotionRunnerButton.setActionCommand("ShowNormalRunner");
        leftPanel.add(showMotionRunnerButton);

        JButton addEliteRunnerButton = new JButton("Lägg till ElitLöpare");
        addEliteRunnerButton.addActionListener(this);
        addEliteRunnerButton.setActionCommand("AddEliteRunner");
        leftPanel.add(addEliteRunnerButton);

        JButton showEliteRunnerButton = new JButton("Visa EliteLöpare");
        showEliteRunnerButton.addActionListener(this);
        showEliteRunnerButton.setActionCommand("ShowEliteRunner");
        leftPanel.add(showEliteRunnerButton);

        JButton showEliteWinnerButton = new JButton("Visa elitvinnare");
        showEliteWinnerButton.addActionListener(this);
        showEliteWinnerButton.setActionCommand("ShowEliteWinner");
        leftPanel.add(showEliteWinnerButton);

        JButton clearButton = new JButton("Rensa datafält");
        clearButton.addActionListener(this);
        clearButton.setActionCommand("ClearFields");
        leftPanel.add(clearButton);
        cont.add(leftPanel);

        //Här bygger vi upp mitten-panelen med 2 Jlistor.
        JPanel centerPanel = new JPanel(new GridLayout(1, 1));

        centerPanel.add(runnerList);

        cont.add(centerPanel);

        //Här bygger vi upp högerpanelen med datafält.
        JPanel rightPanel = new JPanel(new GridLayout(6, 1));
        rightPanel.add(nameField);
        rightPanel.add(startNrField);
        rightPanel.add(finishTimeField);
        rightPanel.add(hasOrderedTshirtField);
        rightPanel.add(licenseNrField);
        rightPanel.add(clubField);
        cont.add(rightPanel);
        buildMenu();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //Här bygger vi upp filmenyn högst upp.
    private void buildMenu()
    {
        JMenuBar menuBar = new JMenuBar(); //Lägg till topmeny.
        JMenu newRunner = new JMenu("Ny Löpare");
        menuBar.add(newRunner); //lägg till Löparemeny.

        JMenuItem addNormalRunner = new JMenuItem("Lägg till MotionsLöpare");
        addNormalRunner.setActionCommand("AddNormalRunner");
        addNormalRunner.addActionListener(this);
        newRunner.add(addNormalRunner);

        JMenuItem addEliteRunner = new JMenuItem("Lägg till ElitLöpare");
        addEliteRunner.setActionCommand("AddEliteRunner");
        addEliteRunner.addActionListener(this);
        newRunner.add(addEliteRunner);

        JMenuItem quit = new JMenuItem("Avsluta");
        quit.setActionCommand("Quit");
        quit.addActionListener(this);
        newRunner.add(quit);

        JMenu showRunner = new JMenu("Visa Löpare");
        menuBar.add(showRunner); //lägg till en meny till menyraden.

        JMenuItem showNormalRunner = new JMenuItem("Visa MotionsLöpare");
        showNormalRunner.setActionCommand("ShowNormalRunner");
        showNormalRunner.addActionListener(this);
        showRunner.add(showNormalRunner);

        JMenuItem showEliteRunner = new JMenuItem("Visa ElitLöpare");
        showEliteRunner.setActionCommand("ShowEliteRunner");
        showEliteRunner.addActionListener(this);
        showRunner.add(showEliteRunner);

        JMenuItem showEliteWinner = new JMenuItem("Visa ElitVinnare");
        showEliteWinner.setActionCommand("ShowEliteWinner");
        showEliteWinner.addActionListener(this);
        showRunner.add(showEliteWinner);

        setJMenuBar(menuBar);
    }

    //Här läggs Motionslöpare till och adderas i JListen.
    private void addNormalRunner()
    {
        //Kolla att de rätta fälten är ifyllda för motionär.
        if (startNrField.getText().equals("") || nameField.getText().equals("")
            || finishTimeField.getText().equals("") || hasOrderedTshirtField.getText().equals("")
            || !clubField.getText().equals("") || !licenseNrField.getText().equals(""))
            JOptionPane.showMessageDialog(null,
                "Du måste fylla i del rätta fälten för Motionslöpare i listan!");
        else {
            logic.addNormalRunner(startNrField.getText(), nameField.getText(),
                finishTimeField.getText(), hasOrderedTshirtField.getText());
            runnerList.setListData(logic.getAllRunners());
        }
    }

    //Här läggs Elitlöpare till och adderas i JListen.
    private void addEliteRunner()
    {
        //Kolla att de rätta fälten är ifyllda för elitlöpare.
        if (startNrField.getText().equals("") || nameField.getText().equals("")
            || finishTimeField.getText().equals("") || clubField.getText().equals("")
            || licenseNrField.getText().equals("") || !hasOrderedTshirtField.getText().equals(""))
            JOptionPane.showMessageDialog(null,
                "Du måste fylla i del rätta  fälten för Elitlöpare i listan!");
        else {

            logic.addEliteRunner(startNrField.getText(), nameField.getText(),
                finishTimeField.getText(), clubField.getText(), licenseNrField.getText());
            runnerList.setListData(logic.getAllRunners());
        }
    }

    //Här visas data för den Motionslöpare som man klickar på i JListen.
    private void ShowNormalRunner()
    {
        int position = runnerList.getSelectedIndex();
        //Om man trycker på knappen Visa Motionär och trycker på en Motionär
        //i JList så får man fortsätta , annars sätts runnerName till ""
        //och man får en felutskrift att man måste trycka på rätt rad och knapp.
        if ((position > -1) && (!(logic.getNameForRunnerAt(position, "M:").equals(""))))
        {
            nameField.setText(logic.getNameForRunnerAt(position, "M:"));
            startNrField.setText(logic.getStartNrForRunnerAt(position));
            finishTimeField.setText(logic.getTimeForRunnerAt(position));
            hasOrderedTshirtField.setText(logic.getOrderedTshirtForRunnerAt(position));
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Du måste markera en Motionslöpare i listan!");
        }
    }

    //Här visas data för den Elitlöpare som man klickar på i JListen.    
    private void ShowEliteRunner()
    {
        int position = runnerList.getSelectedIndex();
        //Om man trycker på knappen Visa Elitlöpare och trycker på en motionär
        //i JList så får man fortsätta , annars sätts runnerName till ""
        //och man får en felutskrift att man måste trycka på rätt rad och knapp.
        if ((position > -1) && (!(logic.getNameForRunnerAt(position, "E: ").equals(""))))
        {
            nameField.setText(logic.getNameForRunnerAt(position, "E:"));
            startNrField.setText(logic.getStartNrForRunnerAt(position));
            finishTimeField.setText(logic.getTimeForRunnerAt(position));
            licenseNrField.setText(logic.getLicenseNoForRunnerAt(position));
            clubField.setText(logic.getClubForRunnerAt(position));
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Du måste markera en Elitlöpare i listan!");
        }
    }

    //Här visas data för den Elitlöpare som man har vunnit.    
    private void showEliteWinner()
    {
        int position = runnerList.getSelectedIndex();
        if (position > -1)
        {
            //Här packar vi upp vinnardata och sätter till de olika fälten.
            String[] tokens = logic.showEliteWinner().split("\\;");
            nameField.setText(tokens[0]);
            startNrField.setText(tokens[1]);
            finishTimeField.setText(tokens[2]);
            clubField.setText(tokens[3]);
            licenseNrField.setText(tokens[4]);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Du måste markera en Elitlöpare i listan!");
        }
    }

    //Här rensar vi datafälten.
    private void clear()
    {
        nameField.setText("");
        startNrField.setText("");
        finishTimeField.setText("");
        licenseNrField.setText("");
        clubField.setText("");
        hasOrderedTshirtField.setText("");
    }

    //Denna metoden visar vad som händer när man trycker på en knapp.
    //Eller väljer något i fil-menyn högst upp.
    public void actionPerformed(ActionEvent event)
    {
        String theText = event.getActionCommand();
        if (theText.equals("AddNormalRunner")) //Tryckt på knappen Lägg till Motionslöpare.
        {
            addNormalRunner();
        }
        if (theText.equals("AddEliteRunner")) //Tryckt på knappen Visa MotionsLöparInfo.
        {
            addEliteRunner();
        }

        if (theText.equals("ShowNormalRunner")) //Tryckt på knappen Lägg till Motionslöpare.
        {
            clear();
            ShowNormalRunner();
        }

        if (theText.equals("ShowEliteRunner")) //Tryckt på knappen Visa EliteLöparInfo.
        {
            clear();
            ShowEliteRunner();
        }

        if (theText.equals("ShowEliteWinner")) //Tryckt på knappen Visa EliteLöparInfo.
        {
            clear();
            showEliteWinner();
        }

        if (theText.equals("ClearFields")) //Rensa datafält.
        {
            clear();
        }
        if (theText.equals("Quit")) //Valt menyfliken Avsluta.
        {
            System.exit(0);
        }
    }

}