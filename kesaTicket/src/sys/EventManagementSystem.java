package sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import Event_is_a.Concert;
import Event_is_a.Conference;
import Event.Event;
import Event_is_a.SportsEvent;
import Ticket.Ticket;
import User.User;




public class EventManagementSystem {
	static private ArrayList<Event> events = new ArrayList<>();
	static private HashMap<String, User> users = new HashMap<>();
	static private ArrayList<Ticket> tickets = new ArrayList<>();
	static private int nextEventId = 1; // Initial event ID
	static private String[] arr= new String[15];

    public static String addEvent(Event event) {
    	String res="";
        event.setEventId(nextEventId++); // Event ID is assigned sequentially
        events.add(event);
        res+=("Event added: " + event.getEventName() + " (ID: " + event.getEventId() + ")");
        return res;
    }

    public static String deleteEvent(int eventId) {
    	String res="";
        events.removeIf(event -> event.getId() == eventId);
        res+=("Event deleted.");
        return res;
    }
    
    
    public static String[] getIDs() {
    	int i=0;
    	
    	for (Event e : events) {
			arr[i]=e.getEventId() + "";
			
			i++;
		}
    	return arr;
    }
    
    

    public static String displayEvents() {
        String res="\n--- Available Events ---\\n";
        if (events.isEmpty()) {
           res+="No events available.\\n";
            
        }
        for (Event event : events) {
        	 res+="\n--- " + event.getClass().getSimpleName() + " ---\n";

            // Print common event details
        	 res+="Event Name: " + event.getEventName() + "\n";
        	 res+="Event ID: " + event.getId() + "\n";
        	 res+="Date: " + event.getDate() + "\n";
        	 res+="Location: " + event.getLocation() + "\n";
        	 res+="Price: " + event.getPrice() + "\n";

            // Event-specific details
            event.displayEventDetails();

            res+="-------------------------------";
        }
        
        return res;
    }

    public static ArrayList<Event> getEvents() {
		return events;
	}

	public static ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public static void buyTicket(User user, Scanner scanner) {
        displayEvents();
        System.out.print("\nEnter event ID to buy ticket: ");
        int eventId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Event selectedEvent = null;
        for (Event event : events) {
            if (event.getId() == eventId) {
                selectedEvent = event;
                break;
            }
        }

        if (selectedEvent != null) {
            System.out.print("Is this a VIP ticket? (yes/no): ");
            String vipChoice = scanner.nextLine().toLowerCase();
            boolean isVip = vipChoice.equals("yes");

            int seatNumber = -1; // Initial invalid seat number
            boolean validSeat = false;

            // Loop to ask for valid seat number
            while (!validSeat) {
                System.out.print("Enter seat number: ");
                seatNumber = scanner.nextInt();
                scanner.nextLine(); // consume newline

                // Check seat range based on ticket type
                if (isVip && (seatNumber < 0 || seatNumber > 10)) {
                    System.out.println("Invalid seat number for VIP. Please choose a seat between 0 and 10.");
                } else if (!isVip && (seatNumber < 11 || seatNumber > 99)) {
                    System.out.println("Invalid seat number for non-VIP. Please choose a seat between 11 and 99.");
                } else if (Ticket.eventSeats.getOrDefault(eventId, new HashSet<>()).contains(seatNumber)) {
                    System.out.println("Seat " + seatNumber + " is already taken. Please choose another seat.");
                } else {
                    validSeat = true;
                }
            }

            // Create ticket and associate it with the user's email
            Ticket ticket = new Ticket(new Random().nextInt(1000), eventId, selectedEvent.getPrice(), isVip, seatNumber, user.getEmail());
            tickets.add(ticket);
            Ticket.eventSeats.computeIfAbsent(eventId, k -> new HashSet<>()).add(seatNumber);

            double finalPrice = ticket.getFinalPrice();

            // Apply student discount
            if (user.isStudent()) {
                double discount = isVip ? finalPrice * 0.25 : 0; // Only apply discount for VIP tickets
                finalPrice -= discount;
                System.out.println("Student discount applied! Discount: " + discount);
            }

            System.out.println("Ticket purchased for event: " + selectedEvent.getEventName());
            System.out.println("Seat number: " + seatNumber + ", Final price: " + finalPrice);
            if (isVip) {
                System.out.println("VIP ticket purchased. Price is doubled.");
            }
        } else {
            System.out.println("Invalid event ID.");
        }
    }

    public static String viewTickets(User user,ArrayList<Ticket> ticketsG) {
       String res="\n--- Your Tickets ---\n";
        boolean hasTickets = false;

        for (Ticket ticket : ticketsG) {
            // Only display the tickets for the logged-in user
            if (ticket.getUserEmail().equals(user.getEmail())) {
                Event event = null;
                for (Event e : events) {
                    if (e.getId() == ticket.getEventId()) {
                        event = e;
                        break;
                    }
                }
                if (event != null) {
                    res+=("Event: " + event.getEventName() + ", Date: " + event.getDate() + ", Location: " + event.getLocation() + ", Seat: " + ticket.getSeatNumber() + ", Price: " + ticket.getFinalPrice()+"\n");
                    hasTickets = true;
                }
            }
        }

        if (!hasTickets) {
           res+=("You have no tickets.");
        }
        
        return res;
    }

    public static void addUser(User user) {
        getUsers().put(user.getEmail(), user);
    }

    public static void createTestUsers() {
        addUser(new User("admin1@bilkent.com", "adminpass", true, false)); // Admin
        addUser(new User("student1@bilkent.com", "studentpass", false, true)); // Student
        addUser(new User("user1@bilkent.com", "userpass", false, false)); // Normal user
    }

    public static void createTestEvents() {
        // Creating 2 sports events
        addEvent(new SportsEvent("Football Match", "2024-12-20", "Ali Sami Yen Stadium", 50, "Fenerbahçe", "Galatasaray", "Final"));
        addEvent(new SportsEvent("Basketball Game", "2024-12-22", "Madison Square Garden", 40, "New York Knicks", "Dallas Mavericks", "Season Game"));

        // Creating 1 conference event
        ArrayList<String> speakers = new ArrayList<>();
        speakers.add("John Doe");
        speakers.add("Jane Smith");
        ArrayList<String> topics = new ArrayList<>();
        topics.add("AI in 2025");
        topics.add("Future of Technology");
        addEvent(new Conference("Tech Conference", "2024-12-25", "Convention Center", 100, speakers, topics));

        // Creating 2 concert events
        addEvent(new Concert("Rock Concert", "2024-12-30", "Los Angeles Sofi Stadium", 80, "Daft Punk", "Rock"));
        addEvent(new Concert("Pop Concert", "2024-12-28", "Volkswagen Arena", 60, "The Wekknd", "Pop"));
    }

    public static double calculateTotalRevenue() {
        double totalRevenue = 0.0;
        for (Ticket ticket : tickets) {
            totalRevenue += ticket.getFinalPrice();
        }
        return totalRevenue;
    }

    // Method to check if the date format is valid
    public static boolean isValidDate(String date) {
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        return date.matches(regex);
    }

	public static HashMap<String, User> getUsers() {
		return users;
	}
}