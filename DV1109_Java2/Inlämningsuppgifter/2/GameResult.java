//Namn: Per Sundberg
public class GameResult {

    //Instansvariabler.
    private String gameName = "";
    private int result = 0;

    //Konstruktor.
    public GameResult(String gameName, int result) {
        this.gameName = gameName;
        this.result = result;
    }
    
    public int getResult() {
        return result;
    }

    //Övriga metoder.
    public String toString() {
        String str = "Spel " + gameName + ", " + result + " poäng";
        return str;
    }
}
