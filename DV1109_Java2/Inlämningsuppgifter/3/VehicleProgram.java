// Namn: Per Sundberg
import java.util.ArrayList;
import java.util.Scanner;

public class VehicleProgram {

    //Instansvariabler.
    private ArrayList<Vehicle> vehicles;

    //Konstruktor.
    public VehicleProgram() {
        vehicles = new ArrayList<Vehicle>();
    }

    //Visar meny.
    public int menu(Scanner keyboard) {

        //Deklarera variabler.
        int choice = -1;

        System.out.println("1. Lägg till motorcykel");
        System.out.println("2. Lägg till bil");
        System.out.println("3. Visa hela registret");
        System.out.println("4. Visa alla bilar");
        System.out.println("5. Visa alla motorcyklar");
        System.out.println("6. Sök på märke");
        System.out.println("7. Sök i prisintervall");
        System.out.println("8. Avsluta");
        System.out.print("Ditt val ? ");

        choice = keyboard.nextInt();
        keyboard.nextLine(); //Tömmer buffer.

        return choice;
    }

    //Lägga till en motorcykel till registret.
    public void addMotorCycle(Scanner keyboard) {

        //Deklarera variabler
        String brand = "";
        String engineVolume = "";
        int price = 0;
        String registrationNumer = "";

        System.out.print("Märke: ");
        brand = keyboard.nextLine();
        System.out.print("Motorvolym: ");
        engineVolume = keyboard.nextLine();
        System.out.print("Pris: ");
        price = keyboard.nextInt();
        keyboard.nextLine(); //töm buffer
        System.out.print("RegistreringsNummer: ");
        registrationNumer = keyboard.nextLine();

        vehicles.add(new MotorCycle(brand, engineVolume, price, registrationNumer));
    }

    //Lägga till en bil till registret.
    public void addCar(Scanner keyboard) {

        //Deklarera variabler
        String brand = "";
        String size = "";
        int price = 0;
        String registrationNumer = "";
        int noOfDoors = 0;

        System.out.print("Märke: ");
        brand = keyboard.nextLine();
        System.out.print("Storlek(stor, mellan, liten): ");
        size = keyboard.nextLine();
        System.out.print("Pris: ");
        price = keyboard.nextInt();
        keyboard.nextLine(); //töm buffer
        System.out.print("RegistreringsNummer: ");
        registrationNumer = keyboard.nextLine();
        System.out.print("Antal dörrar: ");
        noOfDoors = keyboard.nextInt();
        keyboard.nextLine(); //töm buffer

        vehicles.add(new Car(brand, size, price, registrationNumer, noOfDoors));
    }

    //Visa alla fordon som finns i registret.
    public void showVechicles() {
        showCars();
        showMotorCycles();
    }

    //Visa alla bilar som finns i registret.
    public void showCars() {
        System.out.println("Registerinnehåll Bilar:");
        for (Vehicle vehicle : vehicles)
            if (vehicle instanceof Car)
                vehicle.writeInfo();
    }

    //Visa alla motorcyklar som finns i registret.    
    public void showMotorCycles() {
        System.out.println("Registerinnehåll MotorCyklar:");
        for (Vehicle vehicle : vehicles)
            if (vehicle instanceof MotorCycle)
                vehicle.writeInfo();
    }

    //Göra en sökning efter ett visst märke och skriva ut det fordonet
    //som matchar märket.
    //Om fordonet inte kan hittas ska det skrivas ut en feltext.
    public void searchForBrands(Scanner keyboard) {

        //Delarera variabler.
        String brand = "";
        boolean vehicleFound = false;

        System.out.print("Märke: ");
        brand = keyboard.nextLine();

        //Här letar vi efter ett visst bilmärke.
        System.out.println("Registerinnehåll Bilar:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                if (vehicle.includes(brand)) {
                    vehicle.writeInfo();
                    vehicleFound = true;
                }
            }
        }

        //Här letar vi efter ett visst motorcykelmärke.
        System.out.println("Registerinnehåll MotorCyklar:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof MotorCycle) {
                if (vehicle.includes(brand)) {
                    vehicle.writeInfo();
                    vehicleFound = true;
                }
            }
        }

        if (!vehicleFound)
            System.out.println("Det finns inget fordon med märke " + brand);
    }

    //Göra en sökning efter ett visst prisintervall och skriva ut det fordonet
    //som matchar prisintervallet.
    //Om fordonet inte kan hittas ska det skrivas ut en feltext.
    public void searchWithinPriceInterval(Scanner keyboard) {

        //Deklarera variabler
        int lowPriceLimit = 0;
        int highPriceLimit = 0;
        boolean vehicleFound = false;

        System.out.print("Nedre prisgräns: ");
        lowPriceLimit = keyboard.nextInt();
        keyboard.nextLine(); //töm buffer

        System.out.print("Övre prisgräns: ");
        highPriceLimit = keyboard.nextInt();
        keyboard.nextLine(); //töm buffer

        //Här letar vi motorcyklare i det inskrivna prisintervallet.
        System.out.println("Registerinnehåll MotorCyklar:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof MotorCycle) {
                if (vehicle.inPriceRange(lowPriceLimit, highPriceLimit)) {
                    vehicle.writeInfo();
                    vehicleFound = true;
                }
            }
        }

        //Här letar vi bilare i det inskrivna prisintervallet.
        System.out.println("Registerinnehåll Bilar:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                if (vehicle.inPriceRange(lowPriceLimit, highPriceLimit)) {
                    vehicle.writeInfo();
                    vehicleFound = true;
                }
            }
        }

        if (!vehicleFound)
            System.out.println("Det finns inget fordon inom prisintervallet " + lowPriceLimit
                + " och " + highPriceLimit);
    }

    //Huvuddelen av programmet.
    public void start(Scanner keyboard) {

        //Deklarera variabler.
        boolean finishProgram = false;

        do {
            switch (menu(keyboard)) {
            case 1:
                addMotorCycle(keyboard);
                break;
            case 2:
                addCar(keyboard);
                break;
            case 3:
                showVechicles();
                break;
            case 4:
                showCars();
                break;
            case 5:
                showMotorCycles();
                break;
            case 6:
                searchForBrands(keyboard);
                break;
            case 7:
                searchWithinPriceInterval(keyboard);
                break;
            case 8:
                finishProgram = true;
                break;
            }
            System.out.print("\n");
        } while (!finishProgram);
    }

    public static void main(String[] args) {

        //Deklarera variabler.
        Scanner keyboard = new Scanner(System.in);

        VehicleProgram vehicles = new VehicleProgram();

        vehicles.start(keyboard);

        System.out.println("Välkommen åter");

        keyboard.close(); //Stänger Scanner.
    }
}
