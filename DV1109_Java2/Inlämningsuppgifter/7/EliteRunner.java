// Namn: Per Sundberg
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class EliteRunner extends Runner {

    //Instansvariabler.
    private String club = "";
    private String licensNo = "";

    //Konstruktor.
    public EliteRunner(String startNumber, String name, String finishTime, String club,
        String licensNo) {
        super(startNumber, name, finishTime);
        this.club = club;
        this.licensNo = licensNo;
    }

    public EliteRunner() {
        super();
        club = "";
        licensNo = "";
    }

    //Get och Set metoder.
    public String getLicensNo() {
        return licensNo;
    }

    public String getClub() {
        return club;
    }

    //Övriga metoder.
    public String winnerData() {
        String str = "";
        str += super.winnerData();
        str += ";" + club + ";" + licensNo;
        return str;
    }

    public void writeInfo() {
        super.writeInfo();
        System.out.println("Klubb: " + club);
        System.out.println("LicensNummer: " + licensNo);
    }

    //Lagra undan NormalRunner till fil.
    public void save(PrintWriter out) {
        super.save(out);
        out.println(club);
        out.println(licensNo);
    }

    //Hämta NormalRunner från fil.
    public void read(BufferedReader in) {
        try {
            super.read(in);
            club = in.readLine();
            licensNo = in.readLine();

        } catch (IOException e) {
            System.out.println("Kunde inte läsa en person från fil");
            e.printStackTrace();
        }
    }

}
