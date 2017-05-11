// Namn: Per Sundberg
public class EliteRunner extends Runner {

    //Instansvariabler.
    private String club = "";
    private String licensNo = "";

    //Konstruktor.
    public EliteRunner(int startNumber, String name, Double finishTime, String club, String licensNo) {
        super(startNumber, name, finishTime);
        this.club = club;
        this.licensNo = licensNo;
    }

    //Get och set metoder
    public String getName() {
        return super.getName();
    }

    public double getFinishTime() {
        return super.getFinishTime();
    }

    //Andra metoder.
    public void writeInfo() {
        super.writeInfo();
        System.out.println("Klubb: " + club);
        System.out.println("LicensNummer: " + licensNo);
    }

}
