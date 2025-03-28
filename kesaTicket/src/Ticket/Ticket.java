package Ticket;

import java.util.HashMap;
import java.util.HashSet;

import has_a.Identifiable;

public class Ticket implements Identifiable {
    private int ticketId;
    private int eventId;
    private double price;
    private boolean isVip;
    private int seatNumber;
    private String userEmail;

    public static final int MAX_VIP_TICKETS = 10;
    public static HashMap<Integer, HashSet<Integer>> eventSeats = new HashMap<>(); // Keeps track of booked seat numbers for each event

    public Ticket(int ticketId, int eventId, double price, boolean isVip, int seatNumber, String userEmail) {
        this.ticketId = ticketId;
        this.eventId = eventId;
        this.price = price;
        this.isVip = isVip;
        this.seatNumber = seatNumber;
        this.userEmail = userEmail;
    }

    public double getFinalPrice() {
        if (isVip) {
            return price * 2; // VIP ticket costs double
        }
        return price;
    }

    @Override
    public int getId() {
        return ticketId;
    }

	public String getUserEmail() {
		return userEmail;
	}

	public int getEventId() {
		return eventId;
	}

	public int getSeatNumber() {
		return seatNumber;
	}
}