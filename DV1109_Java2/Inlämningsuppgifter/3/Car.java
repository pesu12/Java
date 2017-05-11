// Namn: Per Sundberg
public class Car extends Vehicle {

    //Instansvariabler.
    private String size = "";
    private int noOfDoors = 0;

    //Konstruktor.
    public Car(String brand, String size, int price, String registrationNumer, int noOfDoors) {
        super(brand, price, registrationNumer);
        this.size = size;
        this.noOfDoors = noOfDoors;
    }

    //Övriga metoder

    //Metod för att skriva ut Bil.
    public void writeInfo() {
        super.writeInfo();
        System.out.println("Storlek: " + size);
        System.out.println("Antal dörrar: " + noOfDoors);
    }
}
