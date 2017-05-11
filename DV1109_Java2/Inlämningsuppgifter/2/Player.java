//Namn: Per Sundberg
import java.util.ArrayList;

public class Player {

    //Instansvariabler.
    private String name = "";
    private String birthData = "";

    private ArrayList<GameResult> results;

    //Konstruktor.
    public Player(String name, String birthData) {
        this.name = name;
        this.birthData = birthData;
        results = new ArrayList<GameResult>();
    }

    //Get och Set metoder.
    public void setGame(String gameName, int result) {
        results.add(new GameResult(gameName, result));
    }

    public String getName() {
        return name;
    }

    public String getBirthData() {
        return birthData;
    }

    //Övriga metoder.
    public String toString() {
        String str =
            "Namn: " + name + ", Födelsedata: " + birthData;
        return str;
    }

    public void showResults() {
        
        int totalresult=0;
        for (GameResult result : results) {
            System.out.println(result);
            totalresult+=result.getResult();
        }
        System.out.println("Totala resultatet är "+totalresult);
    }

}
