// Namn: Per Sundberg
import java.util.ArrayList;
import java.util.Scanner;

public class RunnerHandler {

    //Instansvariabler.
    private ArrayList<Runner> runners;

    //Konstruktor.
    public RunnerHandler() {
        runners = new ArrayList<Runner>();
    }

    //Visar meny.
    public int menu(Scanner keyboard) {

        //Deklarera variabler.
        int choice = -1;

        System.out.println("1. Lägg till motionslöpare");
        System.out.println("2. Lägg till elitlöpare");
        System.out.println("3. Visa alla löpare");
        System.out.println("4. Visa alla motionslöpare");
        System.out.println("5. Visa alla elitlöpare");
        System.out.println("6. Visa vinnare i Elitklassen");
        System.out.println("7. Avsluta");
        System.out.print("Ditt val ? ");

        choice = keyboard.nextInt();
        keyboard.nextLine(); //Tömmer buffer.

        return choice;
    }

    //Lägga till en motionslöpare.
    public void addNormalRunner(Scanner keyboard) {

        //Deklarera variabler
        int startNumber = 0;
        String name = "";
        Double finishTime = 0.00;
        String tshirtOrNot = "";
        boolean hasOrderedTshirt = false;

        System.out.print("StartNummer: ");
        startNumber = keyboard.nextInt();
        keyboard.nextLine(); //töm buffert
        System.out.print("Namn: ");
        name = keyboard.nextLine();
        System.out.print("Tid(till exempel 45,00): ");
        finishTime = keyboard.nextDouble();
        keyboard.nextLine(); //töm buffert     
        System.out.print("Har beställt T-shirt (j/n): ");
        tshirtOrNot = keyboard.nextLine();
        if (tshirtOrNot.equalsIgnoreCase("j"))
            hasOrderedTshirt = true;
        else
            hasOrderedTshirt = false;

        runners.add(new NormalRunner(startNumber, name, finishTime, hasOrderedTshirt));
    }

    //Lägga till en elitlöpare.
    public void addEliteRunner(Scanner keyboard) {

        //Deklarera variabler
        int startNumber = 0;
        String name = "";
        Double finishTime = 0.00;
        String club = "";
        String licenseNo = "";

        System.out.print("StartNummer: ");
        startNumber = keyboard.nextInt();
        keyboard.nextLine(); //töm buffert
        System.out.print("Namn: ");
        name = keyboard.nextLine();
        System.out.print("Tid(till exempel 45,00): ");
        finishTime = keyboard.nextDouble();
        keyboard.nextLine(); //töm buffert     
        System.out.print("Klubb: ");
        club = keyboard.nextLine();
        System.out.print("LicenseNummer: ");
        licenseNo = keyboard.nextLine();

        runners.add(new EliteRunner(startNumber, name, finishTime, club, licenseNo));
    }

    //Visa alla löpare.
    public void showRunners() {
        showNormalRunners();
        showEliteRunners();
    }

    //Visa alla motionslöpare.
    public void showNormalRunners() {
        System.out.println("Motionslöpare:");
        for (Runner runner : runners)
            if (runner instanceof NormalRunner)
                runner.writeInfo();
    }

    //Visa alla elitlöpare.    
    public void showEliteRunners() {
        System.out.println("Elitlöpare:");
        for (Runner runner : runners)
            if (runner instanceof EliteRunner)
                runner.writeInfo();
    }

    //Visa Elitvinnare
    public void showEliteWinner(Scanner keyboard) {

        //Deklarera variabler
        double leaderTime = 1000;
        Runner winner = null;
        boolean winnerFound = false;

        //Här letar vi efter vinnaren i elit-klassen.
        System.out.println("Vinnare i elit-klassen:");
        for (Runner runner : runners) {
            if (runner instanceof EliteRunner) {
                if (runner.getFinishTime() < leaderTime)
                    winner = runner;
                winnerFound = true;
            }
        }
        //Här skriver vi ut vinnare om det finns minst en deltagare i tävlingsklassen.
        if (winnerFound)
            winner.writeInfo();
        else
            System.out.println("Du måste lägga till minst en deltagare för att få en vinnare");
    }

    //Huvuddelen av programmet.
    public void start(Scanner keyboard) {

        //Deklarera variabler.
        boolean finishProgram = false;

        do {
            switch (menu(keyboard)) {
            case 1:
                addNormalRunner(keyboard);
                break;
            case 2:
                addEliteRunner(keyboard);
                break;
            case 3:
                showRunners();
                break;
            case 4:
                showNormalRunners();
                break;
            case 5:
                showEliteRunners();
                break;
            case 6:
                showEliteWinner(keyboard);
                break;
            case 7:
                finishProgram = true;
                break;
            }
            System.out.print("\n");
        } while (!finishProgram);
    }

    public static void main(String[] args) {

        //Deklarera variabler.
        Scanner keyboard = new Scanner(System.in);

        RunnerHandler runners = new RunnerHandler();

        runners.start(keyboard);

        System.out.println("Välkommen åter");

        keyboard.close(); //Stänger Scanner.
    }
}
