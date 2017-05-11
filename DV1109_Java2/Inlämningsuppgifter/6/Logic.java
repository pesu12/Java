// Namn: Per Sundberg
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Logic {

    //Instansvariabler.
    private ArrayList<Runner> runners;
    private Vector<Runner> vectRunners;

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
        boolean boolHasOrderedTshirt = false;

        //Lägga till M: för att urskilja Motionär i JList
        nameWithNormalLabel += name;

        if (hasOrderedTshirt.equalsIgnoreCase("ja"))
            boolHasOrderedTshirt = true;
        else
            boolHasOrderedTshirt = false;

        runners.add(new NormalRunner(startNumber, nameWithNormalLabel, finishTime,
            boolHasOrderedTshirt));
        vectRunners.add(new NormalRunner(startNumber, nameWithNormalLabel, finishTime,
            boolHasOrderedTshirt));
    }

    //Lägga till en elitlöpare.
    public void addEliteRunner(String startNumber, String name, String finishTime, String club,
        String licenseNo) {

        //Deklarera variabler
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
            runnerName = runnerName.substring(3); //Ta bort :E / :M 
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

    //Visa Elitvinnare
    public String showEliteWinner() {

        //Deklarera variabler
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
        strWinner = strWinner.substring(3); //Ta bort :E 
        return strWinner;
    }
}
