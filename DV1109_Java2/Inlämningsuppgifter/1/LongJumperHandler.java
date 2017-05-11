import java.util.ArrayList;
import java.util.Scanner;

public class LongJumperHandler {

    //Instansvariabler.
    private ArrayList<LongJumper> longJumpers;

    //Konstruktor.
    public LongJumperHandler(int noOfLongJumpers) {
        longJumpers = new ArrayList<LongJumper>(noOfLongJumpers);
    }

    //Meny för programmet, returnerar valet.
    public int menu(Scanner keyboard) {

        //Deklarera variabler
        int choice;

        System.out.println("1. Lägg till längdhoppare");
        System.out.println("2. Lägg till hoppresultat för vald längdhoppare (-1 avbryter)");
        System.out.println("3. Visa alla längdhoppare med namn, klubb och hoppresultat");
        System.out.println("4. Avsluta");
        System.out.print("Ange ditt val ? ");
        choice = keyboard.nextInt();
        keyboard.nextLine(); //tömmer buffert
        return choice;
    }

    //Lägger till längdhoppare. 
    public void addLongJumper(Scanner keyboard) {

        //Deklarera variabler
        String name;
        String club;

        System.out.print("Namn: ");
        name = keyboard.nextLine();
        System.out.print("Klubb: ");
        club = keyboard.nextLine();
        longJumpers.add(new LongJumper(name, club));
    }

    //Hämtar max 3 höjdhoppar-resultat och lägger in dessa i LongJumper.
    public void addResult(Scanner keyboard) {

        //Deklarera variabler.
        final int NUMBER_OF_JUMPS = 3;
        int jump[] = new int[NUMBER_OF_JUMPS];
        boolean jumperFound = false;
        int jumperLength = 0;

        //Nollställ jump-arrayen.
        for (int i = 0; i < NUMBER_OF_JUMPS; i++)
            jump[i] = 0;

        System.out.print("Namn: ");
        String name = keyboard.nextLine();
        System.out.print("Klubb: ");
        String club = keyboard.nextLine();

        //Sök igenom alla LongJumper efter deltagaren.
        for (int i = 0; i <longJumpers.size() ; i++) {
            if (name.equalsIgnoreCase(longJumpers.get(i).getName())
                && (club.equalsIgnoreCase(longJumpers.get(i).getClub()))) {
                //Spara max 3 resultat.
                for (int j = 0; j < NUMBER_OF_JUMPS; j++) {
                    System.out.print("LängdResultat i centimeter: Hopp " + (j + 1) + ": ");
                    jumperLength = keyboard.nextInt();
                    keyboard.nextLine(); //töm buffert

                    //Om resultatet är -1 avbryt spara resultat.
                    if (jumperLength == -1)
                        break;

                    //Spara hoppet.
                    jump[j] = jumperLength;
                }
                //Lagra undan resultatet i LongJumper.
                longJumpers.get(i).setJump(jump);

                jumperFound = true;
                break;
            }
        }

        //Skriv ut text ifall man har skrivit in fel deltagare.
        if (!jumperFound)
            System.out.println("Längdhopparen saknas");
    }

    //Visar alla höjdhoppare.
    public void showLongJumpers() {
        for (LongJumper l:longJumpers)
            System.out.println(l);
    }

    //Metod med huvudloopen för programmet.
    public void start(Scanner keyboard) {

        //Deklarera variabler.
        boolean programFinished = false;

        do {
            int choice = menu(keyboard);
            switch (choice) {
            case 1:
                addLongJumper(keyboard);
                break;
            case 2:
                addResult(keyboard);
                break;
            case 3:
                showLongJumpers();
                break;
            case 4:
                programFinished = true;
                break;
            }
            System.out.print("\n"); //extra utskriftsrad
        } while (!programFinished);
    }

    public static void main(String[] args) {

        //Deklaration av variabler.
        Scanner keyboard = new Scanner(System.in);
        int noOfLongJumpers;

        //Hämtar antal deltagare.
        System.out.print("Hur många deltagare är det ? ");
        noOfLongJumpers = keyboard.nextInt();
        keyboard.nextLine(); //tömmer buffert
        System.out.print("\n");

        LongJumperHandler competition = new LongJumperHandler(noOfLongJumpers);

        competition.start(keyboard); //Anropar huvuddelen av programmet.
        keyboard.close(); //Stänger Scanner.

        System.out.println("Välkommen åter");
    }
}
