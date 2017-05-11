// Namn: Per Sundberg
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerHandler {

    //Instansvariabler.
    private ArrayList<Player> players;

    //Konstanter.
    final int MIN_RESULT = 0;
    final int MAX_RESULT = 100;

    //Konstruktor
    public PlayerHandler() {
        players = new ArrayList<Player>();
    }

    //Lägga till spelare och födelsedata.
    public void addPlayer(Scanner keyboard) {

        //Deklarera variabler.
        String name = "";
        String birthData = "";

        System.out.print("Namn: ");
        name = keyboard.nextLine();
        System.out.print("Födelsedata: ");
        birthData = keyboard.nextLine();

        players.add(new Player(name, birthData));
    }

    //Lägga till Spelnamn och spelresultat för en spelare.
    public void addGame(Scanner keyboard) {

        //Deklarera variabler.
        String name = "";
        String gameName = "";
        String birthData = "";
        int result = -1;
        boolean nameFound = false;

        System.out.print("Namn: ");
        name = keyboard.nextLine();
        System.out.print("Födelsedata: ");
        birthData = keyboard.nextLine();

        for (Player player : players) {
            if (name.equalsIgnoreCase(player.getName())
                && birthData.equalsIgnoreCase(player.getBirthData())) {
                System.out.print("Spelets namn: ");
                gameName = keyboard.nextLine();
                System.out.print("Resultat: ");
                result = keyboard.nextInt();
                keyboard.nextLine(); //Tömmer buffer.
                nameFound = true;
                //Kolla om spelresultatet ligger inom max och min.
                if (result >= MIN_RESULT && result <= MAX_RESULT)
                    player.setGame(gameName, result);
                else
                    System.out.println("Resultatet måste vara mellan " + MIN_RESULT + " och "
                        + MAX_RESULT);
            }
        }
        if (!nameFound)
            System.out.println("Spelaren saknas");
    }

    //Visa spel och spelresultat för en viss spelare.
    public void showGameForPlayer(Scanner keyboard) {

        //Deklarera variabler.
        String name = "";
        String birthData = "";
        boolean nameFound = false;

        System.out.print("Namn: ");
        name = keyboard.nextLine();
        System.out.print("Födelsedata: ");
        birthData = keyboard.nextLine();

        for (Player player : players) {
            if (name.equalsIgnoreCase(player.getName())
                && birthData.equalsIgnoreCase(player.getBirthData())) {
                System.out.println(player);
                player.showResults();
                nameFound = true;
            }
        }
        if (!nameFound)
            System.out.println("Spelaren saknas");
    }

    //Visa alla spelare.
    public void showPlayers() {
        for (Player player : players) {
            System.out.println(player);
            player.showResults();
        }
    }

    //Visar meny.
    public int menu(Scanner keyboard) {

        //Deklarera variabler.
        int choice = -1;

        System.out.println("1. Lägg till spelare");
        System.out.println("2. Lägg till spelresultat för spelare (poäng " + MIN_RESULT + " - "
            + MAX_RESULT + ")");
        System.out.println("3. Visa alla spel samt total resultatpoäng för angiven spelare");
        System.out.println("4. Visa alla spelade spel för samtliga spelare");
        System.out.println("5. Avsluta");
        System.out.print("Ditt val ? ");

        choice = keyboard.nextInt();
        keyboard.nextLine(); //Tömmer buffer.

        return choice;
    }

    //Huvuddelen av programmet.
    public void start(Scanner keyboard) {

        //Deklarera variabler.
        boolean finishProgram = false;

        do {
            switch (menu(keyboard)) {
            case 1:
                addPlayer(keyboard);
                break;
            case 2:
                addGame(keyboard);
                break;
            case 3: {
                showGameForPlayer(keyboard);
                break;
            }
            case 4:
                showPlayers();
                break;
            case 5:
                finishProgram = true;
                break;
            }
            System.out.print("\n");
        } while (!finishProgram);
    }

    public static void main(String[] args) {

        //Deklarera variabler.
        Scanner keyboard = new Scanner(System.in);

        PlayerHandler handler = new PlayerHandler();

        handler.start(keyboard);

        System.out.println("Välkommen åter");

        keyboard.close(); //Stänger Scanner.
    }
}
