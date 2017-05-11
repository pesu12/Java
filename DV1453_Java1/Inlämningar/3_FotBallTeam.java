public class FotBallTeam {

    //instansvariabler.
    private String teamName = "";   //Lagets namn,
    private int matchRegistred = 0; //Antalet registrerade matcher.

    public FotBallTeam(String teamName) {
        this.teamName = teamName;
        matchRegistred = 0;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setMatchRegistred() {
        matchRegistred++;
    }

    public String toString() {
        String str = teamName + " har spelat " + matchRegistred + " matcher";
        return str;
    }
}
