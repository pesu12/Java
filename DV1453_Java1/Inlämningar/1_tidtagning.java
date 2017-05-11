//Detta är ett tidtagningsprogram för Göteborgsvarvet där man matar in tidpunkten
//för en löpares starttid och sluttid. Därefter beräknar och visar programmet 
//löparens tid i timmar, minuter och sekunder.
// Designer Per Sundberg

import java.io.*;
import java.text.*;
import java.util.*;

public class tidtagning {
    public static void main(String[] args) {
      taTid person1=new taTid();
      person1.exekveraTidTagning();
      }
}


class taTid{
    public void exekveraTidTagning() {
    
        Date startTid, slutTid;
        long tidsDifferans,tidsDiffTimmar,tidsDiffMinuter,tidsDiffSekunder=0;
        
        System.out.println("Starttid:");    
        startTid=hemtaTid();
        
        System.out.println("Malgangstid:");
        slutTid=hemtaTid();
        
        //System.out.println("*** Kalkylerar Resultat ***");
        
        tidsDifferans = slutTid.getTime() - startTid.getTime();
        tidsDiffTimmar = tidsDifferans / (60 * 60 * 1000);               
        tidsDiffMinuter = tidsDifferans / (60 * 1000) -(tidsDiffTimmar*60);         
        tidsDiffSekunder = tidsDifferans / 1000 -(tidsDiffTimmar*60*60)-(tidsDiffMinuter*60); 

        // System.out.println("tidsDifferans:" + tidsDifferans);
        
        if (tidsDifferans>-1)
            System.out.println("Resultat: " + tidsDiffTimmar + " timme " + tidsDiffMinuter +"  minuter "+ tidsDiffSekunder + " sekunder");
        else
            System.out.println("Felaktig inmatning: malgangstiden ligger före starttiden");            
    }
    
            
    public Date hemtaTid() {
                
        Date tid;
        String timme,minut,stringTid,sekunder="";
        
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");         

        System.out.print("Timme: ");    
        timme=hemtaSiffor();
        
        System.out.print("Minut: ");
        minut=hemtaSiffor();    
        
        System.out.print("Sekund: ");
        sekunder=hemtaSiffor(); 
        
        System.out.println("");
        
        stringTid=timme + ":" + minut + ":" + sekunder;
        
        try {       
            tid = format.parse(stringTid);
        } catch (Exception e) {
                throw new RuntimeException(e);
        }   
        
        System.out.println("Tid: " + tid);

        return tid;
    }
    
    public String hemtaSiffor() {
    
            String inData="";
            int siffror = 0;
            
            Reader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            try {
                inData = br.readLine();
          //      siffror = Integer.parseInt(inData);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }   
        return inData;
    }
    
}