// Namn: Per Sundberg
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class NormalRunner extends Runner {

    //Instansvariabler.
    private String hasOrderedTshirt = "";

    //Konstruktorer.
    public NormalRunner(String startNumber, String name, String finishTime, String hasOrderedTshirt) {
        super(startNumber, name, finishTime);
        this.hasOrderedTshirt = hasOrderedTshirt;
    }

    public NormalRunner() {
        super();
        hasOrderedTshirt = "";
    }

    //Get och set metoder.
    public String getOrderedTshirt() {

        return hasOrderedTshirt;
    }

    //Övriga metoder.
    public void writeInfo() {
        super.writeInfo();
        if (hasOrderedTshirt.equalsIgnoreCase("ja"))
            System.out.println("Har inte beställt T-shirt");
        else
            System.out.println("Har beställt T-shirt");
    }

    //Lagra undan NormalRunner till fil.
    public void save(PrintWriter out) {
        super.save(out);
        out.println(hasOrderedTshirt);
    }

    //Hämta NormalRunner från fil.
    public void read(BufferedReader in) {
        try {
            super.read(in);
            hasOrderedTshirt = in.readLine();

        } catch (IOException e) {
            System.out.println("Kunde inte läsa en person från fil");
            e.printStackTrace();
        }
    }
}
