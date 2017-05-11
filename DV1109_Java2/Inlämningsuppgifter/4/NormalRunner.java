// Namn: Per Sundberg
public class NormalRunner extends Runner {

    //Instansvariabler.
    private boolean hasOrderedTshirt = false;

    //Konstruktor.
    public NormalRunner(int startNumber, String name, Double finishTime, boolean hasOrderedTshirt) {
        super(startNumber, name, finishTime);
        this.hasOrderedTshirt = hasOrderedTshirt;
    }

    //Andra metoder
    public void writeInfo() {
        super.writeInfo();
        if (!hasOrderedTshirt)
            System.out.println("Har inte beställt T-shirt");
        else
            System.out.println("Har beställt T-shirt");
    }

}
