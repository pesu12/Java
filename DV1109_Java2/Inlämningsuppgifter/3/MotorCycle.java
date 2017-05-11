// Namn Per Sundberg
public class MotorCycle extends Vehicle {

    //Instansvariabler.
    private String engineVolume = "";

    //Konstruktor.
    public MotorCycle(String brand, String engineVolume, int price, String registrationNumer) {
        super(brand, price, registrationNumer);
        this.engineVolume = engineVolume;
    }

    //Övriga metoder.
    public void writeInfo() {
        super.writeInfo();
        System.out.println("Motorvolym: " + engineVolume);    
    }
}
