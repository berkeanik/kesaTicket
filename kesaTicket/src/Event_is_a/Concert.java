package Event_is_a;

import Event.Event;

public class Concert extends Event {
    private String performer;
    private String genre;

    public Concert(String eventName, String date, String location, double price, String performer, String genre) {
        super(eventName, date, location, price);
        this.performer = performer;
        this.genre = genre;
    }

    @Override
    public String displayEventDetails() {
    	String res="";
    	 res+="Performer: " + performer + "\n";
    	 res+="Genre: " + genre  + "\n";
    	 
    	 return res;
    }
}
