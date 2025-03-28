package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import User.User;
import sys.EventManagementSystem;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class UserMenuFrame extends JFrame {

	private JPanel window;
	private JTextArea outputTF;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	LoginFrame mmf=null;
	 BuyTicket bt=new BuyTicket(this);

	/**
	 * Create the frame.
	 */
	public UserMenuFrame(LoginFrame frame) {
		mmf=frame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 450);
		window = new JPanel();
		window.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(window);
		window.setLayout(null);
		
		outputTF = new JTextArea();
		outputTF.setBounds(10, 154, 625, 246);
		window.add(outputTF);
		outputTF.setColumns(10);
		
		JLabel buyNotifyLbl = new JLabel("");
		buyNotifyLbl.setVerticalAlignment(SwingConstants.TOP);
		buyNotifyLbl.setBounds(10, 53, 193, 40);
		window.add(buyNotifyLbl);
		
		JButton showTicketBtn = new JButton("Show my tickets");
		showTicketBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String,User> n;
				n=EventManagementSystem.getUsers();
				User loggedin=null;
				for(User u:n.values())
				{
					if(mmf.getUsername().equals(u.getEmail()))
					{
						loggedin=u;
					}
				}
				outputTF.setText(EventManagementSystem.viewTickets(loggedin,bt.getTickets())); //!!!!!!!!!!!????????!!!!!!!!!!!!!!!!!??????????????!!!!!!!!!!!!
			}
		});
		showTicketBtn.setBounds(151, 120, 109, 23);
		window.add(showTicketBtn);
		
		JRadioButton conferenceRdBtn = new JRadioButton("Conference");
		buttonGroup.add(conferenceRdBtn);
		conferenceRdBtn.setBounds(212, 11, 109, 23);
		window.add(conferenceRdBtn);
		
		JRadioButton concertRdBtn = new JRadioButton("Concert");
		buttonGroup.add(concertRdBtn);
		concertRdBtn.setBounds(121, 11, 109, 23);
		window.add(concertRdBtn);
		
		JRadioButton sportsEventRdBtn = new JRadioButton("Sports Event");
		buttonGroup.add(sportsEventRdBtn);
		sportsEventRdBtn.setBounds(10, 11, 109, 23);
		window.add(sportsEventRdBtn);
		
		JButton buyRdBtn = new JButton("Buy tickets");
		buyRdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sportsEventRdBtn.isSelected()||conferenceRdBtn.isSelected()||concertRdBtn.isSelected())
				{
					setVisible(false);
					bt.setVisible(true);
				}else {
					buyNotifyLbl.setText("choose one category from above");
					
				}
			}
		});
		buyRdBtn.setBounds(213, 53, 89, 23);
		window.add(buyRdBtn);
		
		JButton showEventsBtn = new JButton("Show Events");
		showEventsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputTF.setText(EventManagementSystem.displayEvents());
			}
		});
		showEventsBtn.setBounds(10, 122, 109, 23);
		window.add(showEventsBtn);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mmf.setVisible(true);
			}
		});
		logoutBtn.setBounds(546, 120, 89, 23);
		window.add(logoutBtn);
		
		JLabel addEventNoteLbl = new JLabel("");
		addEventNoteLbl.setBounds(10, 53, 46, 14);
		window.add(addEventNoteLbl);
		
	
	}
}