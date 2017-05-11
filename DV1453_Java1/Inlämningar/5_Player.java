public class Player {

    //Instansvariabler
    private String name = "unknown";
    private int points = 0;

    //Konstruktor
    public Player(String name) {
        this.name = name;
    }

    //Get och Set metoder
    public void setPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    //Övriga metoder
    public String toString() {
        String str = "Namn " + name + " poäng " + points + "\n";
        return str;
    }

}
