// Namn: Per Sundberg
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

}
