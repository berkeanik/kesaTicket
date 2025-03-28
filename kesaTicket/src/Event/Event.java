package Event;

import has_a.Identifiable;

public abstract class Event implements Identifiable {
	protected String eventName;
    protected String date;
    protected String location;
    protected double price;
    protected int eventId;

    public Event(String eventName, String date, String location, double price) {
        this.eventName = eventName;
        this.date = date;
        this.location = location;
        this.price = price;
    }

    // Abstract method to display event details
    public abstract String displayEventDetails();

    @Override
    public int getId() {
        return getEventId();
    }

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getEventId() {
		return eventId;
	}
	
	public String getEventName() {
		return eventName;
	}

	public String getDate() {
		return date;
	}

	public String getLocation() {
		return location;
	}


	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
}