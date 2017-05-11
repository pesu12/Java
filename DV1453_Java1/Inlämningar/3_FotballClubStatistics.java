import java.util.Scanner;

public class FotballClubStatistics {

    //Klassvariabler.
    private FotBallTeam fotballteam1, fotballteam2;

    public void initialize(Scanner keyboard) {

        //Skapa instans av lag 1 och lag 2 där man får skriva in lag-namnet i anropet till
        //konstruktorn.
        System.out.print("Namn på lag nr 1: ");
        fotballteam1 = new FotBallTeam(keyboard.nextLine());

        System.out.print("Namn på lag nr 2: ");
        fotballteam2 = new FotBallTeam(keyboard.nextLine());
    }

    public void start(Scanner keyboard) {

        //Deklarering av variabler. 
        int menyChoice = 0;         //variabel för menyval  
        final int EXIT_PROGRAM = 0; //konstant vid avslut av program

        System.out.println("");

        //Huvudmeny, fortsätt tills man skriver in 0.
        do
        {
            System.out.println("1. Registrera match för " + fotballteam1.getTeamName());
            System.out.println("2. Registrera match för " + fotballteam2.getTeamName());
            System.out.println("3. Visa resultat");
            System.out.println("0. Avsluta");
            System.out.print("Ditt val: ");
            menyChoice = keyboard.nextInt(); //läs in användarens val
            keyboard.nextLine();
            System.out.println("");
            switch (menyChoice) {
            case 1:
                fotballteam1.setMatchRegistred(); //Registrera match för lag1
                System.out.println("Match för " + fotballteam1.getTeamName()
                    + " har nu registrerats");
                System.out.println("");
                break;
            case 2:
                fotballteam2.setMatchRegistred(); //Registrera match för lag2
                System.out.println("Match för " + fotballteam2.getTeamName()
                    + " har nu registrerats");
                System.out.println("");
                break;
            case 3:
                System.out.println(fotballteam1.toString());
                System.out.println(fotballteam2.toString());
                System.out.println("");
                break;
            default:
                menyChoice = EXIT_PROGRAM;
            }
        } while (menyChoice > EXIT_PROGRAM);
    }

    public static void main(String[] args) {

        //Deklarering av key-input. 
        Scanner keyboard = new Scanner(System.in); //inmatningsvariabel till konsollen.       

        //Skapar objekt av den klass man befinner sig i.
        FotballClubStatistics clubstats = new FotballClubStatistics();
        
        //Initialiserar instansvariabel.
        clubstats.initialize(keyboard);
        
        //Startar huvuddelen.
        clubstats.start(keyboard);

        //Här stänger vi inströmmen till konsollen.
        keyboard.close();

        //Sluttext innnan man avslutar.
        System.out.println("Välkommen åter");
    }
}
