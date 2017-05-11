// Namn: Per Sundberg
public abstract class Runner {

    //instansvariabler;
    private String startNumber = "";
    private String name = "";
    private String finishTime = "";

    //Konstruktor.
    public Runner(String startNumber, String name, String finishTime) {
        this.startNumber = startNumber;
        this.name = name;
        this.finishTime = finishTime;
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

}
