
public class SchoolChild {

    //Instansvariabler
    private String name;
    private int yearOfBirth;

    //Konstruktorer    
    public SchoolChild() {
        name="";
        yearOfBirth=0;
    }
    
    public SchoolChild(String name,int yearOfBirth) {
        this.name=name;
        this.yearOfBirth=yearOfBirth;

    }
    
    //Get/set-metoder
    public String getName() {
        return name;
    }
    
    public int getYearOfBirth() {
        return yearOfBirth;
    }
        
    public String toString() {
        String Str="Namn "+ name+ " är född " + yearOfBirth + "\n";
        return Str;
    }
}
