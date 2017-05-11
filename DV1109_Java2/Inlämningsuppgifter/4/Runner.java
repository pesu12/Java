// Namn: Per Sundberg
public abstract class Runner {

    //instansvariabler;
    private int startNumber = 0;
    private String name = "";
    private double finishTime = 0.00;

    //Konstruktor
    public Runner(int startNumber, String name, Double finishTime) {
        this.startNumber = startNumber;
        this.name = name;
        this.finishTime = finishTime;
    }

    //Get och set metoder
    public String getName() {
        return name;
    }

    public double getFinishTime() {
        return finishTime;
    }

    //Övriga metoder
    public void writeInfo() {
        System.out.println("StartNummer: " + startNumber);
        System.out.println("Namn: " + name);
        System.out.println(String.format("Sluttid: %.2f", finishTime));
    }

}
