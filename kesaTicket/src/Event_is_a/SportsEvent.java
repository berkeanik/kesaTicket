package Event_is_a;
import Event.Event;


public class SportsEvent extends Event {
	private String homeTeam;
	private String awayTeam;
	private String matchType;

    public SportsEvent(String eventName, String date, String location, double price, String homeTeam, String awayTeam, String matchType) {
        super(eventName, date, location, price);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matchType = matchType;
    }

    @Override
    public String displayEventDetails() {
    	String res="";
    	 res+="Match Type: " + matchType+ "\n";
    	 res+="Home Team: " + homeTeam+ "\n";
    	 res+="Away Team: " + awayTeam+ "\n";
    	 
    	 return res;
    }
}