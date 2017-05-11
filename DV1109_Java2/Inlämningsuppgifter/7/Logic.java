// Namn: Per Sundberg
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;

public class Logic {

    //Instansvariabler.
    private ArrayList<Runner> runners;
    private Vector<Runner> vectRunners;

    //Konstanter.
    private static final int END_POS_FOR_EM_TEXT = 3;

    //Konstruktor.
    public Logic() {
        runners = new ArrayList<Runner>();
        vectRunners = new Vector<Runner>();
    }

    //Lägga till en motionslöpare.
    public void addNormalRunner(String startNumber, String name, String finishTime,
        String hasOrderedTshirt) {

        //Deklarera variabler.
        String nameWithNormalLabel = "M: ";

        //Lägga till M: för att urskilja Motionär i JList.
        nameWithNormalLabel += name;

        runners.add(new NormalRunner(startNumber, nameWithNormalLabel, finishTime,
            hasOrderedTshirt));
        vectRunners.add(new NormalRunner(startNumber, nameWithNormalLabel, finishTime,
            hasOrderedTshirt));
    }

    //Lägga till en elitlöpare.
    public void addEliteRunner(String startNumber, String name, String finishTime, String club,
        String licenseNo) {

        //Deklarera variabler.
        String nameWithEliteLabel = "E: ";

        //Lägga till E: för att urskilja Elitlöpare i JList.
        nameWithEliteLabel += name;

        runners.add(new EliteRunner(startNumber, nameWithEliteLabel, finishTime, club,
            licenseNo));
        vectRunners.add(new EliteRunner(startNumber, nameWithEliteLabel, finishTime, club,
            licenseNo));
    }

    //Hämta alla löpare.
    public Vector<Runner> getAllRunners()
    {
        return vectRunners;
    }

    //Hämta löpare-namn för löpare i JList.
    public String getNameForRunnerAt(int position, String runnerType)
    {
        String runnerName = "";
        Runner runner = runners.get(position);
        runnerName = runner.getName();
        //Om man trycker på knappen Visa Motionär och trycker på en Motionslöpare
        //i JList så får man fortsätta , annars sätts runnerName till ""
        //och man får en felutskrift att man måste trycka på rätt rad och knapp.
        if ((runnerType.contains("E:") && runner.getName().contains("E:"))
            || (runnerType.contains("M:") && runner.getName().contains("M:")))
            runnerName = runnerName.substring(END_POS_FOR_EM_TEXT); //Ta bort :E / :M 
        else
            runnerName = "";
        return runnerName;
    }

    //Hämta löpar-nummer för löpare i JList.    
    public String getStartNrForRunnerAt(int position)
    {
        Runner runner = runners.get(position);
        return runner.getStartNumber();
    }

    //Hämta löpar-resultat för löpare i JList.  
    public String getTimeForRunnerAt(int position)
    {
        Runner runner = runners.get(position);
        return runner.getFinishTime();
    }

    //Hämta löpar-data för om man har beställt t-shirt för löpare i JList.    
    public String getOrderedTshirtForRunnerAt(int position)
    {
        Runner runner = vectRunners.get(position);
        return runner.getOrderedTshirt();
    }

    //Hämta löpar-data licens för löpare i JList.    
    public String getLicenseNoForRunnerAt(int position)
    {
        Runner runner = vectRunners.get(position);
        return runner.getLicensNo();
    }

    //Hämta löparklubb. för löpare i JList.
    public String getClubForRunnerAt(int position)
    {
        Runner runner = vectRunners.get(position);
        return runner.getClub();
    }

    //Visa Elitvinnare.
    public String showEliteWinner() {

        //Deklarera variabler.
        double leaderTime = 1000;
        Runner winner = null;
        boolean winnerFound = false;
        String strWinner = "";

        //Här letar vi efter vinnaren i elit-klassen.
        for (Runner runner : runners) {
            if (runner instanceof EliteRunner) {
                if (Double.parseDouble(runner.getFinishTime()) < leaderTime)
                    winner = runner;
                leaderTime = (Double.parseDouble(runner.getFinishTime()));
                winnerFound = true;
            }
        }
        //Här skriver vi ut vinnare om det finns minst en deltagare i tävlingsklassen.
        if (winnerFound)
            strWinner = winner.winnerData();
        else
            strWinner = "NoWinner";
        strWinner = strWinner.substring(END_POS_FOR_EM_TEXT); //Ta bort :E 
        return strWinner;
    }

    //Här spar vi undan Motionslöpare och Elit-löpare till en textfil.
    public void save(String fileName) {

        int numberOfNormalRunners = 0;
        int numberOfEliteRunners = 0;

        try {

            PrintWriter out = new PrintWriter(fileName);

            //Sortera runners.
            Collections.sort(runners, new MyRunnerSorting());

            //Ta reda på hur många löpare det finns av Motionärer och av ElitLöpare.
            for (int i = 0; i < runners.size(); i++) {
                if (runners.get(i).getName().contains("M:"))
                    numberOfNormalRunners++;
                if (runners.get(i).getName().contains("E:"))
                    numberOfEliteRunners++;
            }

            //Spara antal Motionärer och Elitlöpare till fil.
            out.println(numberOfNormalRunners);
            out.println(numberOfEliteRunners);

            //Spara all persondata.
            for (int i = 0; i < runners.size(); i++) {
                runners.get(i).save(out);
            }

            //Stäng filen.
            out.close();
        } catch (IOException e) {
            System.out.println("Kunde inte spara på fil");
            e.printStackTrace();
        }
    }

    //Här hämtar vi Motionslöpare och Elit-löpare från en textfil.    
    public void read(String fileName) {
        runners.clear(); //Töm runner innan läsning från fil.
        vectRunners.clear(); //Töm vectrunner innan läsning från fil.
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            int numberOfNormalRunners = Integer.parseInt(in.readLine());
            int numberOfEliteRunners = Integer.parseInt(in.readLine());
            for (int i = 0; i < numberOfEliteRunners; i++) {
                EliteRunner p = new EliteRunner();
                p.read(in);
                runners.add(p);
                vectRunners.add(p);
            }

            for (int i = 0; i < numberOfNormalRunners; i++) {
                NormalRunner p = new NormalRunner();
                p.read(in);
                runners.add(p);
                vectRunners.add(p);
            }

            //Stäng fil
            in.close();
        } catch (IOException e) {
            System.out.println("Kunde inte läsa från fil");
            e.printStackTrace();
        }
    }
}

//Detta är en klass som används för att sortera Runner från en Arraylista(runners).
class MyRunnerSorting implements Comparator<Runner> {

    public int compare(Runner r1, Runner r2) {
        return r1.getName().compareTo(r2.getName());
    }
}
