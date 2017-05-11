// Namn: Per Sundberg
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Runner {

    //instansvariabler;
    private String startNumber = "";
    private String name = "";
    private String finishTime = "";

    //Konstruktorer.
    public Runner(String startNumber, String name, String finishTime) {
        this.startNumber = startNumber;
        this.name = name;
        this.finishTime = finishTime;
    }

    public Runner() {
        startNumber = "";
        name = "";
        finishTime = "";
    }

    //Get och set metoder.
    public String getName() {
        return name;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public String getStartNumber() {
        return startNumber;
    }

    public String getOrderedTshirt() {
        return getOrderedTshirt();
    }

    public String getLicensNo() {
        return getLicensNo();
    }

    public String getClub() {
        return getClub();
    }

    //Övriga metoder
    public String toString() {
        return name;
    }

    public String winnerData() {
        return name + ";" + startNumber + ";" + finishTime;
    }

    public void writeInfo() {
        System.out.println("StartNummer: " + startNumber);
        System.out.println("Namn: " + name);
        System.out.println("Sluttid :" + finishTime);
    }

    //Lagra undan Runnerdata till fil.
    public void save(PrintWriter out) {
        out.println(startNumber);
        out.println(name);
        out.println(finishTime);
    }

    //Hämta Runnerdata från fil.
    public void read(BufferedReader in) {
        try {
            startNumber = in.readLine();
            name = in.readLine();
            finishTime = in.readLine();
        } catch (IOException e) {
            System.out.println("Kunde inte läsa en person från fil");
            e.printStackTrace();
        }
    }

}
