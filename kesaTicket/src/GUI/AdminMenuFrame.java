package GUI;

import java.awt.Event;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Event_is_a.Concert;
import sys.EventManagementSystem;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class AdminMenuFrame extends JFrame {

	private JPanel window;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextArea outputTF;
	private JComboBox<String> comboBox;
	LoginFrame mmf=null;
	
	 ConcertFrame concert=new ConcertFrame(this);
	 ConferenceFrame conference=new ConferenceFrame(this);
	 SportsEventFrame se=new SportsEventFrame(this);
	 

	public JComboBox<String> getComboBox() {
		return comboBox;
	}


	


	public AdminMenuFrame(LoginFrame frame) {
		mmf=frame;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 450);
		window = new JPanel();
		window.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(window);
		window.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 174, 615, 226);
		window.add(scrollPane);
		 		
		
		
		
		JButton revenueBtn = new JButton("Show total revenue");
		revenueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				outputTF.setText("" + EventManagementSystem.calculateTotalRevenue());
			}
		});
		revenueBtn.setBounds(151, 120, 133, 23);
		window.add(revenueBtn);
		
		JRadioButton conferenceRdBtn = new JRadioButton("Conference");
		buttonGroup.add(conferenceRdBtn);
		conferenceRdBtn.setBounds(232, 11, 109, 23);
		window.add(conferenceRdBtn);
		
		JRadioButton concertRdBtn = new JRadioButton("Concert");
		buttonGroup.add(concertRdBtn);
		concertRdBtn.setBounds(121, 11, 109, 23);
		window.add(concertRdBtn);
		
		JRadioButton sportsEventRdBtn = new JRadioButton("Sports Event");
		buttonGroup.add(sportsEventRdBtn);
		sportsEventRdBtn.setBounds(10, 11, 109, 23);
		window.add(sportsEventRdBtn);
		
		JLabel promptlabel = new JLabel("");
		promptlabel.setBounds(20, 54, 165, 13);
		window.add(promptlabel);
		
		JButton addBtn = new JButton("Add Event");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(conferenceRdBtn.isSelected())
				{
					conference.setVisible(true);
				}
				else if(concertRdBtn.isSelected())
				{
					concert.setVisible(true);
				}
				else if(sportsEventRdBtn.isSelected())
				{
					se.setVisible(true);
				}
				else
				{
					promptlabel.setText("Please choose one button");
				}
			}
		});
		addBtn.setBounds(232, 49, 89, 23);
		window.add(addBtn);
		
		JButton viewEventsBtn = new JButton("View Events");
		viewEventsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputTF.setText(EventManagementSystem.displayEvents());
			}
		});
		viewEventsBtn.setBounds(10, 122, 109, 23);
		window.add(viewEventsBtn);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				mmf.setVisible(true);
			}
		});
		logoutBtn.setBounds(546, 120, 89, 23);
		window.add(logoutBtn);
		
		JLabel addEventNoteLbl = new JLabel("");
		addEventNoteLbl.setBounds(10, 53, 46, 14);
		window.add(addEventNoteLbl);
		
		JLabel buyNotifyLbl = new JLabel("");
		buyNotifyLbl.setVerticalAlignment(SwingConstants.TOP);
		buyNotifyLbl.setBounds(10, 53, 193, 40);
		window.add(buyNotifyLbl);
		
		JButton refreshbutton = new JButton("refresh");
		refreshbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setModel(new DefaultComboBoxModel(EventManagementSystem.getIDs()));
			}
		});
		refreshbutton.setBounds(368, 12, 83, 21);
		window.add(refreshbutton);
		
		comboBox = new JComboBox();
		comboBox.setBounds(523, 12, 95, 21);
		window.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(EventManagementSystem.getIDs()));
		
		
		JButton deleteBtn = new JButton("Delete event");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int delevid=Integer.parseInt((String)comboBox.getSelectedItem());
				outputTF.setText(EventManagementSystem.deleteEvent(delevid));  
				comboBox.setModel(new DefaultComboBoxModel(EventManagementSystem.getIDs()));
				
			}
		});
		deleteBtn.setBounds(523, 43, 95, 23);
		window.add(deleteBtn);
		
		JLabel eventIdLbl = new JLabel("Event ID");
		eventIdLbl.setBounds(467, 15, 46, 14);
		window.add(eventIdLbl);
		
		outputTF = new JTextArea();
		outputTF.setBounds(20, 174, 615, 226);
		window.add(outputTF);
		
		
		
		
		
		
		
		
		
	
	}
}
