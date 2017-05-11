// Namn: Per Sundberg
import javax.swing.*; // För grafiska komponenter.
import java.awt.event.*; // För knapphantering.
import java.awt.*; // För layouts.

public class GUI extends JFrame implements ActionListener
{
    //Instansvariabler.
    private Logic logic;
    private Container cont; //Fönstrets huvudbehållare för grafiska komponenter.
    private JList<Runner> runnerList;
    private JTextField nameFieldNormalRunner, startNrFieldNormalRunner, finishTimeFieldNormalRunner
                    , hasOrderedTshirtFieldNormalRunner;
    private JTextField nameFieldEliteRunner, startNrFieldEliteRunner, finishTimeFieldEliteRunner
                    , licenseNrFieldEliteRunner, clubFieldEliteRunner;

    //Konstanter.
    private static final int FRAME_SIZE_HEIGHT = 300;
    private static final int FRAME_SIZE_LENGTH = 800;
    private static final int MAIN_GRID_HEIGHT = 1;
    private static final int MAIN_GRID_LENGTH = 4;
    private static final int LEFT_PANEL_GRID_HEIGHT = 6;
    private static final int LEFT_PANEL_GRID_LENGTH = 1;
    private static final int CENTER_PANEL_GRID_HEIGHT = 1;
    private static final int CENTER_PANEL_GRID_LENGTH = 1;
    private static final int RUNNER_PANEL_GRID_HEIGHT = 5;
    private static final int RUNNER_PANEL_GRID_LENGTH = 1;
    private static final int NO_ITEMS_IN_LIST = -1;

    //Main-metod.
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

    //Instansiera globala variabler som måste kommas åt i hela klassen.
    private void initiateInstanceVariables()
    {
        logic = new Logic();
        cont = getContentPane();
        nameFieldNormalRunner = new JTextField();
        nameFieldNormalRunner.setBorder(BorderFactory.createTitledBorder("Motionär Namn:"));
        startNrFieldNormalRunner = new JTextField();
        startNrFieldNormalRunner.setBorder(BorderFactory
            .createTitledBorder("Motionär Startnummer:"));
        finishTimeFieldNormalRunner = new JTextField();
        finishTimeFieldNormalRunner.setBorder(BorderFactory
            .createTitledBorder("Motionär Tid (tex 45.00):"));
        hasOrderedTshirtFieldNormalRunner = new JTextField();
        hasOrderedTshirtFieldNormalRunner.setBorder(BorderFactory
            .createTitledBorder("Motionär Beställt Tshirt(ja/nej):"));
        nameFieldEliteRunner = new JTextField();
        nameFieldEliteRunner.setBorder(BorderFactory.createTitledBorder("Elit Namn:"));
        startNrFieldEliteRunner = new JTextField();
        startNrFieldEliteRunner.setBorder(BorderFactory
            .createTitledBorder("ElitLöpare Startnummer:"));
        finishTimeFieldEliteRunner = new JTextField();
        finishTimeFieldEliteRunner.setBorder(BorderFactory
            .createTitledBorder("ElitLöpare Tid (tex 45.00):"));
        licenseNrFieldEliteRunner = new JTextField();
        licenseNrFieldEliteRunner.setBorder(BorderFactory
            .createTitledBorder("ElitLöpare Licensenummer:"));
        clubFieldEliteRunner = new JTextField();
        clubFieldEliteRunner.setBorder(BorderFactory.createTitledBorder("ElitLöpare Klubb:"));

        runnerList = new JList<Runner>();
        runnerList.setBorder(BorderFactory.createTitledBorder("Löpare: <E:Elit, M:Motionär>"));
    }

    //Här bygger vi upp huvudgrafik-sidan.
    private void buildFrame()
    {
        setTitle("Löpar-tävling");
        setSize(FRAME_SIZE_LENGTH, FRAME_SIZE_HEIGHT);
        cont.setLayout(new GridLayout(MAIN_GRID_HEIGHT, MAIN_GRID_LENGTH));

        //Här bygger vi upp den vänstra panelen med knappar.
        JPanel leftPanel =
            new JPanel(new GridLayout(LEFT_PANEL_GRID_HEIGHT, LEFT_PANEL_GRID_LENGTH));
        JButton button = new JButton("Lägg till Motionslöpare");
        button.addActionListener(this);
        button.setActionCommand("AddNormalRunner");
        leftPanel.add(button);

        button = new JButton("Visa MotionsLöpare");
        button.addActionListener(this);
        button.setActionCommand("ShowNormalRunner");
        leftPanel.add(button);

        button = new JButton("Lägg till ElitLöpare");
        button.addActionListener(this);
        button.setActionCommand("AddEliteRunner");
        leftPanel.add(button);

        button = new JButton("Visa EliteLöpare");
        button.addActionListener(this);
        button.setActionCommand("ShowEliteRunner");
        leftPanel.add(button);

        button = new JButton("Visa elitvinnare");
        button.addActionListener(this);
        button.setActionCommand("ShowEliteWinner");
        leftPanel.add(button);

        button = new JButton("Rensa datafält");
        button.addActionListener(this);
        button.setActionCommand("ClearFields");
        leftPanel.add(button);

        cont.add(leftPanel);

        //Här bygger vi upp mitten-panelen med 1 Jlista.
        JPanel centerPanel =
            new JPanel(new GridLayout(CENTER_PANEL_GRID_LENGTH, CENTER_PANEL_GRID_HEIGHT));
        centerPanel.add(runnerList);
        cont.add(centerPanel);

        //Här bygger vi upp Motionärtextfield med datafält.
        JPanel normalRunnerPanel =
            new JPanel(new GridLayout(RUNNER_PANEL_GRID_HEIGHT, RUNNER_PANEL_GRID_LENGTH));
        normalRunnerPanel.add(nameFieldNormalRunner);
        normalRunnerPanel.add(startNrFieldNormalRunner);
        normalRunnerPanel.add(finishTimeFieldNormalRunner);
        normalRunnerPanel.add(hasOrderedTshirtFieldNormalRunner);
        normalRunnerPanel.add(new JLabel(""));

        cont.add(normalRunnerPanel);

        //Här bygger vi upp Elitlöpartextfield med datafält.
        JPanel eliteRunnertPanel =
            new JPanel(new GridLayout(RUNNER_PANEL_GRID_HEIGHT, RUNNER_PANEL_GRID_LENGTH));
        eliteRunnertPanel.add(nameFieldEliteRunner);
        eliteRunnertPanel.add(startNrFieldEliteRunner);
        eliteRunnertPanel.add(finishTimeFieldEliteRunner);
        eliteRunnertPanel.add(licenseNrFieldEliteRunner);
        eliteRunnertPanel.add(clubFieldEliteRunner);
        cont.add(eliteRunnertPanel);

        buildMenu();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void buildMenu() {
        //Menyrad.
        JMenuBar menuBar = new JMenuBar();

        //Meny.
        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        //Menyalternativ.
        JMenuItem item = new JMenuItem("Spara på fil");
        item.setActionCommand("SaveToFile");
        item.addActionListener(this);
        menu.add(item);

        item = new JMenuItem("Läs från fil");
        item.setActionCommand("ReadFromFile");
        item.addActionListener(this);
        menu.add(item);

        item = new JMenuItem("Avsluta");
        item.setActionCommand("Quit");
        item.addActionListener(this);
        menu.add(item);

        //Lägg till menyn till fönstret.
        setJMenuBar(menuBar);
    }

    //Här läggs Motionslöpare till och adderas i JListen.
    private void addNormalRunner()
    {
        logic.addNormalRunner(startNrFieldNormalRunner.getText(), nameFieldNormalRunner.getText(),
            finishTimeFieldNormalRunner.getText(), hasOrderedTshirtFieldNormalRunner.getText());
        runnerList.setListData(logic.getAllRunners());
    }

    //Här läggs Elitlöpare till och adderas i JListen.
    private void addEliteRunner()
    {
        logic.addEliteRunner(startNrFieldEliteRunner.getText(), nameFieldEliteRunner.getText(),
            finishTimeFieldEliteRunner.getText(), clubFieldEliteRunner.getText(),
            licenseNrFieldEliteRunner.getText());
        runnerList.setListData(logic.getAllRunners());
    }

    //Här visas data för den Motionslöpare som man klickar på i JListen.
    private void ShowNormalRunner()
    {
        int position = runnerList.getSelectedIndex();
        //Om man trycker på knappen Visa Motionär och trycker på en Motionär
        //i JList så får man fortsätta , annars sätts runnerName till ""
        //och man får en felutskrift att man måste trycka på rätt rad och knapp.
        if ((position > NO_ITEMS_IN_LIST)
            && (!(logic.getNameForRunnerAt(position, "M:").equals(""))))
        {
            nameFieldNormalRunner.setText(logic.getNameForRunnerAt(position, "M:"));
            startNrFieldNormalRunner.setText(logic.getStartNrForRunnerAt(position));
            finishTimeFieldNormalRunner.setText(logic.getTimeForRunnerAt(position));
            hasOrderedTshirtFieldNormalRunner.setText(logic.getOrderedTshirtForRunnerAt(position));
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
        if ((position > NO_ITEMS_IN_LIST)
            && (!(logic.getNameForRunnerAt(position, "E: ").equals(""))))
        {
            nameFieldEliteRunner.setText(logic.getNameForRunnerAt(position, "E:"));
            startNrFieldEliteRunner.setText(logic.getStartNrForRunnerAt(position));
            finishTimeFieldEliteRunner.setText(logic.getTimeForRunnerAt(position));
            licenseNrFieldEliteRunner.setText(logic.getLicenseNoForRunnerAt(position));
            clubFieldEliteRunner.setText(logic.getClubForRunnerAt(position));
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
        if (position > NO_ITEMS_IN_LIST)
        {
            //Här packar vi upp vinnardata och sätter till de olika fälten.
            String[] tokens = logic.showEliteWinner().split("\\;");
            nameFieldEliteRunner.setText(tokens[0]);
            startNrFieldEliteRunner.setText(tokens[1]);
            finishTimeFieldEliteRunner.setText(tokens[2]);
            clubFieldEliteRunner.setText(tokens[3]);
            licenseNrFieldEliteRunner.setText(tokens[4]);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Du måste markera en Elitlöpare i listan!");
        }
    }

    //Här rensar vi datafälten.
    private void clear()
    {
        nameFieldNormalRunner.setText("");
        startNrFieldNormalRunner.setText("");
        finishTimeFieldNormalRunner.setText("");
        hasOrderedTshirtFieldNormalRunner.setText("");

        nameFieldEliteRunner.setText("");
        startNrFieldEliteRunner.setText("");
        finishTimeFieldEliteRunner.setText("");
        licenseNrFieldEliteRunner.setText("");
        clubFieldEliteRunner.setText("");
    }

    //Här visar vi ett spara-fil-fönster.
    private void saveToFile() {
        //String fileName = JOptionPane.showInputDialog(this, "Ange filnamn");
        JFileChooser chooser = new JFileChooser(".");
        int returnVal = chooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String fileName = chooser.getSelectedFile().getAbsolutePath();
            logic.save(fileName);
        }
    }

    //Här visar vi ett hämta-fil-fönster.
    private void readFromFile() {
        JFileChooser chooser = new JFileChooser(".");
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String fileName = chooser.getSelectedFile().getAbsolutePath();
            logic.read(fileName);
            runnerList.setListData(logic.getAllRunners());
        }
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

        if (theText.equals("SaveToFile")) { //Spara till Fil.
            clear();
            saveToFile();
        }

        if (theText.equals("ReadFromFile")) { //Hämta från Fil.
            clear();
            readFromFile();
        }

        if (theText.equals("Quit")) //Valt menyfliken Avsluta.
        {
            System.exit(0);
        }
    }

}