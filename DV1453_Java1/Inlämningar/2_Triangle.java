// *****************************************************************************
// Programmet Triangle skriver ut likbenta rätvinkliga trianglar på skärmen.
// Programmet börjar med att fråga användaren efter längden på de 2 lika långa
// sidorna. Därefter ska användaren ange om den räta vinkeln ska vara nedåt (0)
// eller uppåt (1). Baserat på användarens inmatning skrivs nu triangeln ut på
// skärmen. Programkörningen ska fortgå tills användaren matar in värdet -1
// som svar på frågan om längden på de 2 lika långa sidorna.
// Designer Per Sundberg
// *****************************************************************************

import java.util.Scanner;
import java.lang.Math;

// Klassen Triangle. Huvudklassen som anropas när man startar programmet.
public class Triangle {

    //Metoden main
    //Inparameter, String[] args
    //Utparameter -  
    public static void main(String[] args) {

        //Objekt för en triangel skapas
        Figure triangle = new Figure();

        //Metoden displayfigure anropas för att mata in figurdata,
        //visa och beräkna slutresultat på skärmen.
        triangle.displayfigure();
    }

}

//Klassen Figure. Hämtar figurlängder och vinklar 
//beräknar och visar sedan slutresultatet på skärmen.
class Figure {

    //Metoden displayfigure hämtar figurlängder och vinklar. 
    //Metoden displayfigure beräknar även hur många stjärnor
    //som figuren ska bestå av.
    //Inparameter -
    //Utparameter -  
    public void displayfigure() {

        int angle = 0;       //Räta vinkeln uppåt eller neråt.
        int sideLength = 0;  //Längden på de 2 lika långa sidorna.

        final int LENGTH_TO_EXIT_PROGRAM = -1; //Om man anger length-1 avslutas programmet.
        final int RIGHT_ANGLE_UP = 0;          //Den räta vinkeln är riktad uppåt.

        //Deklaration av inmatningsvariabel till konsollen.
        Scanner keyboard = new Scanner(System.in);

        //Fortsätt att ekevera programmet tills -1 skrivs in som sidlängd.
        do
        {
            System.out.print("Ange längden på de 2 lika långa sidorna (Avsluta med -1): ");
            sideLength = keyboard.nextInt();
            System.out.println("");
            if (sideLength != LENGTH_TO_EXIT_PROGRAM) {
                System.out.print("Ska den räta vinkeln vara nedåt (0) eller uppåt (1): 0 ");
                angle = keyboard.nextInt();
                System.out.println("");
                if (angle == RIGHT_ANGLE_UP) {
                    //Här räknar vi ut antalet sjärnor då den räta 
                    //vinkeln är uppåt.
                    writeStars((sideLength * (sideLength + 1) / 2));
                } else {
                    //Här räknar vi ut antalet sjärnor då den räta 
                    //vinkeln är neråt.
                    //För att särskilja detta med metoden då vi räknar ut
                    //antalet sjärnor då den räta vinkeln är uppåt så 
                    //sätter vi ett negativt tecken (-) på anropet
                    //då den räta vinkeln är neråt.
                    writeStars(-(sideLength * (sideLength + 1) / 2));
                }
                System.out.println("");
            }
        } while (sideLength != LENGTH_TO_EXIT_PROGRAM);

        //Här stänger vi inströmmen till konsollen.
        keyboard.close();

        //Sluttext innnan man avslutar.
        System.out.println("Välkommen åter");
    }

    //Denna metod skriver ut en rad med *-tecken så att en
    //liksidig triangel visas.
    //Inparameter NrOfStars, Antalet stjärnor som ska skrivas ut. 
    //                       Detta värde större än 0 då den räta 
    //                       vinkeln är nedåt.
    //                       Detta värde är mindre än 0 då den räta
    //                       vinkeln är uppåt.
    //Utparameter -     
    public static void writeStars(int nrOfStars) {

        int starsPerLine = 1; //Totalt antal stjärnor per rad.
        int stars = 0;        //Räknas upp med 1 för varje ny stjärna per rad.

        starsPerLine = 1;
        
        //Här skrivs triangel ut då den räta vinkeln är nedåt.
        if (nrOfStars > 0) {

            //Forsätt att skriva ut så länge det finns stjärnor.
            while (nrOfStars > 0) {
                stars = 0;
                //Beräkna antalet sjärnor per rad och skriv ut dem.
                do {
                    System.out.print("*");
                    stars++;
                    nrOfStars--;
                } while (stars < starsPerLine);
                System.out.println("");
                starsPerLine++;
            }
        } else {
            //Här är dem räta vinkeln uppåt.

            //Gör om antalet stjärnor till ett postitivt värde.
            nrOfStars = -nrOfStars;

            //Här räknar vi ut hur många rader vi kommer att 
            //behöva skriva ut för det totala antalet stjärnor 
            //som ska skrivas ut.
            starsPerLine = (int)(-0.5 + Math.sqrt(0.25 + (2 * nrOfStars)));

            //Forsätt att skriva ut så länge det finns stjärnor.            
            while (nrOfStars > 0) {
                stars = 0;
                //Beräkna antalet sjärnor per rad och skriv ut dem.                
                do {
                    System.out.print("*");
                    stars++;
                    nrOfStars--;
                } while (stars < starsPerLine);
                System.out.println("");
                starsPerLine--;
            }

        }
    }
}
