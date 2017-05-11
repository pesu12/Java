// Namn: Per Sundberg
public class NormalRunner extends Runner {

    //Instansvariabler.
    private boolean hasOrderedTshirt = false;

    //Konstruktor.
    public NormalRunner(String startNumber, String name, String finishTime, boolean hasOrderedTshirt) {
        super(startNumber, name, finishTime);
        this.hasOrderedTshirt = hasOrderedTshirt;
    }

    //Get och set metoder.
    public String getOrderedTshirt() {
        String str = "";
        if (hasOrderedTshirt)
            str = "Ja";
        else
            str = "Nej";
        return str;
    }

    //Övriga metoder.
    public void writeInfo() {
        super.writeInfo();
        if (!hasOrderedTshirt)
            System.out.println("Har inte beställt T-shirt");
        else
            System.out.println("Har beställt T-shirt");
    }
}
