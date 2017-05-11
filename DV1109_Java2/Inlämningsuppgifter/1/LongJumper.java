public class LongJumper {

    //Instansvariabler.
    private String name;
    private String club;
    private int jump[];

    //Konstruktor.
    public LongJumper(String name, String club) {

        //Deklarera variabler
        final int NUMBER_OF_JUMPS = 3;
        jump = new int[NUMBER_OF_JUMPS];
        
        this.name = name;
        this.club = club;
        
        //Initiera hoppresultat till 0.
        for (int i = 0; i < NUMBER_OF_JUMPS; i++) {
            jump[i] = 0;
        }
    }

    //Get och set metoder.
    public String getName() {
        return name;
    }

    public String getClub() {
        return club;
    }

    public void setJump(int[] jump) {
        this.jump = jump;
    }

    //Övriga metoder.
    public String toString() {
        String str = "Namn: " + name + "\n";
        str += "Klubb: " + club + "\n";
        str +=
            "Resultat: Hopp 1 :" + jump[0] + " cm. Hopp 2 :" + jump[1] + " cm. Hopp 3 :" + jump[2]
                + " cm.";
        return str;
    }
}
