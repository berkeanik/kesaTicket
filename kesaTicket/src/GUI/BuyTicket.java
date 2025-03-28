package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Event.Event;
import Ticket.Ticket;
import sys.EventManagementSystem;
import User.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;

public class BuyTicket extends JFrame {

	private JPanel contentPane;
	private JTextField seatNoTF;
	private JTextField eventIdTF;
	UserMenuFrame umf=null;
	//HashMap<String,User> users=new HashMap<>();
	ArrayList<Event> events ;
	ArrayList<Ticket> tickets= new ArrayList<>();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	
	
	/**

	/**
	 * Create the frame.
	 */
	public BuyTicket(UserMenuFrame frame) {
		umf=frame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton yesRdBtn = new JRadioButton("yes");
		buttonGroup.add(yesRdBtn);
		yesRdBtn.setBounds(107, 127, 46, 23);
		contentPane.add(yesRdBtn);
		
		eventIdTF = new JTextField();
		eventIdTF.setBounds(107, 31, 86, 20);
		contentPane.add(eventIdTF);
		eventIdTF.setColumns(10);
		
		JLabel evenIdLbl = new JLabel("Event ID");
		evenIdLbl.setBounds(28, 34, 46, 14);
		contentPane.add(evenIdLbl);
		
		JRadioButton noRdBtn = new JRadioButton("no");
		buttonGroup.add(noRdBtn);
		noRdBtn.setBounds(170, 127, 109, 23);
		contentPane.add(noRdBtn);
		
		seatNoTF = new JTextField();
		seatNoTF.setBounds(107, 79, 86, 20);
		contentPane.add(seatNoTF);
		seatNoTF.setColumns(10);
		
		JLabel seatNoLbl = new JLabel("Seat number");
		seatNoLbl.setBounds(28, 82, 69, 14);
		contentPane.add(seatNoLbl);
		
		JLabel vipLbl = new JLabel("V.I.P. ");
		vipLbl.setBounds(28, 131, 46, 14);
		contentPane.add(vipLbl);
		
		JLabel notifyLbl = new JLabel("");
		notifyLbl.setBounds(28, 223, 485, 14);
		contentPane.add(notifyLbl);
		
		JButton buyBtn = new JButton("Buy ticket");
		buyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String s="";
				for (Ticket t : EventManagementSystem.getTickets()) {
					tickets.add(t);
				}
				
				
				Event selectedEvent=null;
				boolean isVip=false;
				events=EventManagementSystem.getEvents();
				if(!(seatNoTF.getText().isEmpty()||eventIdTF.getText().isEmpty())) {
				if(yesRdBtn.isSelected())
					{
					isVip=true;
					s+="You bought VIP tickets. Prices are doubled!";
					if(Integer.parseInt(seatNoTF.getText())>10)
					{
						notifyLbl.setText("you can't bougt from this seat number(VIP tickets must choose from 1-10)");
					}else {
						for (Event event : events) {
					if(Integer.parseInt(eventIdTF.getText())==event.getId())
					{
					selectedEvent=event;	
					}
				}
					Ticket ticket = new Ticket(new Random().nextInt(1000), Integer.parseInt(eventIdTF.getText()), selectedEvent.getPrice(), isVip, Integer.parseInt(seatNoTF.getText()), umf.mmf.getUsername());
			        tickets.add(ticket);
			        notifyLbl.setText(s+"ticket bought successfuly");
						
					}
					}else
					{
						if(Integer.parseInt(seatNoTF.getText())<10)
						{
							notifyLbl.setText("you can't bought from this seat number(only VIP tickets can choose from 1-10)");
						}else {
							for (Event event : events) {
						if(Integer.parseInt(eventIdTF.getText())==event.getId())
						{
						selectedEvent=event;	
						}
					}
						Ticket ticket = new Ticket(new Random().nextInt(1000), Integer.parseInt(eventIdTF.getText()), selectedEvent.getPrice(), isVip, Integer.parseInt(seatNoTF.getText()), umf.mmf.getUsername());
				        tickets.add(ticket);
				        notifyLbl.setText(s+"ticket bought successfuly");
							
						}
					}}else {
						notifyLbl.setText("fill the neccessary fields");
					}
				
				
				
				
			}
		});
		buyBtn.setBounds(232, 189, 89, 23);
		contentPane.add(buyBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				umf.setVisible(true);
			}
		});
		cancelBtn.setBounds(463, 282, 89, 23);
		contentPane.add(cancelBtn);
	}

}