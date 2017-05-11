import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PlayerStatistics {

    //Klassvariabler.
    static Player player = new Player("unknown");
    static ArrayList<Player> players = new ArrayList<Player>();

    public static void main(String[] args) {

        //Lokala variabler.
        int menuChoice = 0;

        //Fortsätt tills programmet e slut.
        do {
            //Anropa method menu.
            menuChoice = menu();

            //Case val beroende på svar från menu.
            switch (menuChoice) {
            //Om Case är 1, anropa metod registrera spelare.
            case 1:
                registerPlayer();
                break;

            //Om Case är 2, anropa metod för att lägga in poäng för spelare.
            case 2:
                addPoints();
                break;
            //Om Case är 3, anropa metod för att skriva ut spelare.
            case 3:
                displayPlayers();
                break;
            //Om Case är 4, anropa metod för att skriva ut spelare som 
            //passerat viss poängsumma.
            case 4:
                displayPlayersWithHighPoints();
                break;
            case 0:
                JOptionPane.showMessageDialog(null, "Välkommen åter.");
            }
            //Loopen e slut då menuChoice är 0.
        } while (menuChoice != 0);

        //Stäng program.
        System.exit(0);
    }

    public static int menu() {
        String menutext = "";
        int indata;
        menutext += "1. Registrera spelare (namnet på spelare)\n";
        menutext += "2. Lägg in poäng för spelare\n";
        menutext += "3. Visa alla spelare\n";
        menutext += "4. Visa de spelare som passerat en viss poängsumma\n";
        menutext += "0. Avsluta\n";
        menutext += "Ditt val:";
        indata = Integer.parseInt(JOptionPane.showInputDialog(menutext));

        //Returnera data från menyn
        return indata;
    }

    public static void registerPlayer() {
        String name = "";
        name = JOptionPane.showInputDialog(null, "Spelarens namn:");
        player = new Player(name);
        players.add(player);
    }

    public static void addPoints() {

        String name = "";
        int point = 0;

        name = JOptionPane.showInputDialog(null, "Spelarens namn:");

        //Här söker vi upp namnet för den positionen där vi vill sätta poängen.
        boolean nameExists = false;
        for (int i = 0; i <= players.size() - 1; i++) {
            if (players.get(i).getName().equals(name)) {

                point = Integer.parseInt(JOptionPane.showInputDialog("Mata in poängantalet:"));

                //Sätt poäng.
                players.get(i).setPoints(point);
                nameExists = true;
                //Om vi hittar det vi söker så avbryter vi loopen här.
                break;
            }
        }
        //Om namnet inte hittas skriv ut detta.
        if (!nameExists)
            JOptionPane.showMessageDialog(null, "Hittar ingen spelare med namnet " + name);
    }

    public static void displayPlayers() {
        String displayText = "";
        for (int i = 0; i <= players.size() - 1; i++)
            displayText += players.get(i).getName() + " " + players.get(i).getPoints() + "\n";
        JOptionPane.showMessageDialog(null, displayText);
    }

    public static void displayPlayersWithHighPoints() {

        boolean noOneOverValue = true;
        int inPoints = 0;
        int playerPoints = 0;
        String displayText = "";
        inPoints = Integer.parseInt(JOptionPane.showInputDialog("Ange poänggräns:"));

        //Jämför om players poäng (playerPoints) är större än den poänggräns som matas in.
        for (int i = 0; i <= players.size() - 1; i++) {
            playerPoints = players.get(i).getPoints();
            if (playerPoints > inPoints) {
                noOneOverValue = false;
                displayText += players.get(i).getName() + " har " + playerPoints + " poäng\n";
            }
        }
        //Om man inte har hittat någon player poäng som är över den poänggräns som matas in.
        if (noOneOverValue)
            displayText += "Ingen spelare har över " + inPoints + " poäng.";

        JOptionPane.showMessageDialog(null, displayText);
    }

}
