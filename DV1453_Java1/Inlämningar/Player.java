
public class Player {
    
    private String name;
    private String club;
    private int result;
    
    //Konstruktor
    public Player(String name,String club,int result) {
        this.name=name;
        this.club=club;
        this.result=result;
    }
    
    //Get och Set metoder
    public String getPlayerName() {
        return name;
    }
    
    public String getPlayerClub() {
        return club;
    }
    
    public int getResult() {
        return result;
    }
    
    //Andra metoder
    public String toString() { 
        String str="Namn:"+ name + "\n";
        str+="Klubb:"+ club + "\n";
        str+="Resultat:"+ result+"\n";
       return str;
    }

}
