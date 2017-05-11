import java.util.Scanner;

public class HandleSchoolChildren {

    public static void main(String[] args) {

        //Lokala variabler.
        int noOfChildren = 0;
        String name = "";
        int yearOfBirth = 0;
        int noOfChildrenOver3 = 0;
        int noOfChildrenUnder4 = 0;
        int ageCountUnder4 = 0;
        int ageCountOver3 = 0;

        Scanner keyboard = new Scanner(System.in);
        
        //Lokal konstant.
        final int THIS_YEAR = 2013;


        //Instansvariabler. 
        SchoolChild[] schoolChild;
        SchoolChild[] schoolChildUnder4 = null;
        SchoolChild[] schoolChildOver3 = null;

        //Läs in antal barn från användaren.
        System.out.print("Hur många barn vill du registrera ? ");
        noOfChildren = keyboard.nextInt();
        keyboard.nextLine();

        //Skapa array schoolChild.
        schoolChild = new SchoolChild[noOfChildren];

        //Läs in namn och födelseår från användaren.
        for (int i = 0; i < noOfChildren; i++) {
            System.out.print("Namn: ");
            name = keyboard.nextLine();
            System.out.print("Födelseår: ");
            yearOfBirth = keyboard.nextInt();
            keyboard.nextLine();

            //Lagra data för om personen är under 4 år.
            if ((THIS_YEAR - yearOfBirth) < 4)
                noOfChildrenUnder4++;
                
            schoolChild[i] = new SchoolChild(name, yearOfBirth);
        }

        //Skapa array schoolChildUnder4.
        for (int i = 0; i < noOfChildrenUnder4; i++) {
            schoolChildUnder4 = new SchoolChild[noOfChildrenUnder4];
        }

        //Räkna ut antalet barn över 3 år.
        noOfChildrenOver3 = noOfChildren - noOfChildrenUnder4;

        //Skapa array schoolChildOver3.
        for (int i = 0; i < noOfChildrenOver3; i++) {
            schoolChildOver3 = new SchoolChild[noOfChildrenOver3];
        }

        //Loopa igenom antal barn.
        for (int i = 0; i < noOfChildren; i++) {

            //Om barnet är under 4 år skapa instans av objektet schoolChildrenUnder4.
            if ((THIS_YEAR - schoolChild[i].getYearOfBirth()) < 4) {
                schoolChildUnder4[ageCountUnder4] = schoolChild[i];
                ageCountUnder4++;
                //Om barnet är över 3 år skapa instans av objektet schoolChildrenOver3.
            } else {
                schoolChildOver3[ageCountOver3] = schoolChild[i];
                ageCountOver3++;
            }
        }

        //Loop, skriv ut data för barnen som är under 4 år.
        if (ageCountUnder4 > 0) {
            System.out.println("\nFöljande (" + schoolChildUnder4.length
                + "st) barn är under 4 år:");
            for (int i = 0; i < schoolChildUnder4.length; i++) {
                System.out.println(schoolChildUnder4[i].getName() + " född år "
                    + schoolChildUnder4[i].getYearOfBirth());
            }
        }

        //Loop, skriv ut data för barnen som är över 3 år.
        if (ageCountOver3 > 0) {
            System.out.println("Följande (" + schoolChildOver3.length
                + "st) barn är 4 år eller mer:");
            for (int i = 0; i < schoolChildOver3.length; i++) {
                System.out.println(schoolChildOver3[i].getName() + " född år "
                    + schoolChildOver3[i].getYearOfBirth());
            }
        }
        //Stäng Scanner.
        keyboard.close();
    }

}
