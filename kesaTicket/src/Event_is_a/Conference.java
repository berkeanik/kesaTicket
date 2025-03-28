package Event_is_a;

import java.util.ArrayList;
import Event.Event;

public class Conference extends Event {
	private ArrayList<String> speakers;
	private ArrayList<String> topics;

    public Conference(String eventName, String date, String location, double price, ArrayList<String> speakers, ArrayList<String> topics) {
        super(eventName, date, location, price);
        this.speakers = speakers;
        this.topics = topics;
    }

    @Override
    public String displayEventDetails() {
    	String res="";
    	 res+="Speakers: " + String.join(", ", speakers)  + "\n";
    	 res+="Topics: " + String.join(", ", topics) + "\n";
    	 return res;
    }
}