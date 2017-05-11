import java.util.ArrayList;
import java.util.Scanner;

public class BouleGame {

    private ArrayList<Player> players; //lista med de olika boulespelarna.

    public BouleGame() {
        players = new ArrayList<Player>();
    }

    //Skapa nytt objekt som läggs in i arraylistan.
    public void addPlayer(Scanner keyboard) {
        System.out.print("Namn: ");
        String name = keyboard.nextLine();
        System.out.print("Klubb: ");
        String club = keyboard.nextLine();
        System.out.print("Resultat: ");
        int result = keyboard.nextInt();
        keyboard.nextLine();
        players.add(new Player(name, club, result));
    }

    //Visar alla objekten som finns i arraylistan.
    public void showAllPlayers() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println("Namn: " + players.get(i).getPlayerName());
            System.out.println("Klubb: " + players.get(i).getPlayerClub());
            System.out.println("Resultat: " + players.get(i).getResult());
        }
    }

    //Visar alla objekten från arraylistan som tillhör en viss klubb.
    //Skriv annars ut att ingen spelare hittades för efterfrågade klubben.
    public void showAllPlayersForAClub(Scanner keyboard) {
        boolean playerFound = false;
        System.out.print("Ange klubb: ");
        String club = keyboard.nextLine();
        for (int i = 0; i < players.size(); i++) {
            if (club.equals(players.get(i).getPlayerClub())) {

                System.out.println("Namn: " + players.get(i).getPlayerName());
                System.out.println("Klubb: " + players.get(i).getPlayerClub());
                System.out.println("Resultat: " + players.get(i).getResult());
                playerFound = true;
            }
        }
        if (!playerFound)
            System.out.println("Det finns tyvärr inga registrerade spelare i denna klubb");
    }

    //Ta bort ett player-objekt från arraylistan.
    //Om det efterfrågade player-objektet inte finns, gör felutskrift.
    public void removePlayer(Scanner keyboard) {
        boolean playerRemoved = false;
        System.out.print("Ange namn: ");
        String club = keyboard.nextLine();

        for (int i = 0; i < players.size(); i++) {
            if (club.equals(players.get(i).getPlayerName())) {
                players.remove(i);
                playerRemoved = true;
                break;
            }
        }
        if (!playerRemoved)
            System.out.println("Det finns ingen spelare med detta namn");
    }

    //Hämta objektet för den spelare som har högst resultat 
    public Player highestResult() {
        int highestResult = 0; //Sparar undan högsta resultatet.
        Player personWithHighestResult = null;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getResult() > highestResult) {
                highestResult = players.get(i).getResult();
                personWithHighestResult = players.get(i);
            }
        }
        return personWithHighestResult; //objektet med högsta resultatet.

    }

    //Huvudmetoden för programmet med bland annat huvudmenyn.
    public void start() {
        int menuChoice = 0;
        boolean endProgram = false;
        Scanner keyboard = new Scanner(System.in);

        do {
            System.out.println("1. Lägg till ny deltagare");
            System.out.println("2. Visa alla deltagare");
            System.out.println("3. Visa alla deltagare från viss klubb");
            System.out.println("4. Ta bort deltagare");
            System.out.println("5. Visa bästa resultat");
            System.out.println("0. Avsluta");
            System.out.print("Ditt val: ");
            menuChoice = keyboard.nextInt();
            keyboard.nextLine();
            switch (menuChoice) {
            case 1:
                addPlayer(keyboard);
                break;
            case 2:
                showAllPlayers();
                break;
            case 3:
                showAllPlayersForAClub(keyboard);
                break;
            case 4:
                removePlayer(keyboard);
                break;
            case 5:
                System.out.println("Bästa resultatet " + highestResult().getResult()
                    + " poäng har "
                    + highestResult().getPlayerName());
                break;
            case 0:
                endProgram = true;
            }
            System.out.print("\n");
        } while (!endProgram);
        keyboard.close();
    }

    public static void main(String[] args) {

        BouleGame bouleGame = new BouleGame(); //Skapar objekt av den klass man befinner sig i.
        bouleGame.start(); //Startar huvuddelen

        System.out.println("Välkommen åter");
    }

}
