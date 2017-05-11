// Namn: Per Sundberg
public class Vehicle {

    //Instansvariabler.
    private String brand = "";
    private int price = 0;
    private String registrationNumber = "";

    //Konstruktor.
    public Vehicle(String brand, int price, String registrationNumber) {
        this.brand = brand;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    //Övriga metoder.
    public void writeInfo() {
        System.out.println("Märke: " + brand);
        System.out.println("Pris: " + price);
        System.out.println("Registreringsnummer: " + registrationNumber);
    }

    //Metod för att se om ett visst fordonsmärke finns.
    //Om märket hittas skickar true tillbaka.
    //Om märket inte hittas skickar false tillbaka.    
    public boolean includes(String searchStr) {
        if (searchStr.equalsIgnoreCase(brand))
            return true;
        else
            return false;
    }

    //Metod för att som om en fordon inom ett prisintervall finns.
    //Om prisintervallet hittas skickar true tillbaka.
    //Om prisintervallet inte hittas skickar false tillbaka.      
    public boolean inPriceRange(int fromPrice, int toPrice) {
        if ((price>=fromPrice)&&(price<=toPrice))
           return true;
        else
           return false;
    }
}
