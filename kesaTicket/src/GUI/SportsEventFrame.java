package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Event.Event;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Event_is_a.*;
import sys.EventManagementSystem;

public class SportsEventFrame extends JFrame {

	private JPanel contentPane;
	private JTextField dateTF;
	private JTextField eventNametTF;
	private JTextField locationTF;
	private JTextField priceTF;
	private JTextField homeTF;
	private JTextField awayTF;
	private JTextField matchTypeTF;
	AdminMenuFrame mmf=null;


	/**
	 * Create the frame.
	 */
	public SportsEventFrame(AdminMenuFrame frame) {
		mmf=frame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		eventNametTF = new JTextField();
		eventNametTF.setBounds(107, 31, 86, 20);
		contentPane.add(eventNametTF);
		eventNametTF.setColumns(10);
		
		JLabel evenNameLbl = new JLabel("Event name:");
		evenNameLbl.setBounds(28, 34, 69, 14);
		contentPane.add(evenNameLbl);
		
		dateTF = new JTextField();
		dateTF.setText("(YYYY-MM-DD)");
		dateTF.setBounds(107, 74, 86, 20);
		contentPane.add(dateTF);
		dateTF.setColumns(10);
		
		JLabel dateLbl = new JLabel("Date:");
		dateLbl.setBounds(28, 77, 69, 14);
		contentPane.add(dateLbl);
		
		JLabel matchTypeLbl = new JLabel("Match type:");
		matchTypeLbl.setBounds(231, 122, 90, 14);
		contentPane.add(matchTypeLbl);
		
		JLabel notifyLbl = new JLabel("");
		notifyLbl.setBounds(170, 223, 46, 14);
		contentPane.add(notifyLbl);
		
		
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelBtn.setBounds(484, 361, 89, 23);
		contentPane.add(cancelBtn);
		
		JLabel locationLbl = new JLabel("Location:");
		locationLbl.setBounds(28, 122, 46, 14);
		contentPane.add(locationLbl);
		
		locationTF = new JTextField();
		locationTF.setBounds(107, 119, 86, 20);
		contentPane.add(locationTF);
		locationTF.setColumns(10);
		
		priceTF = new JTextField();
		priceTF.setBounds(107, 169, 86, 20);
		contentPane.add(priceTF);
		priceTF.setColumns(10);
		
		JLabel homeLbl = new JLabel("Home team:");
		homeLbl.setBounds(231, 34, 90, 14);
		contentPane.add(homeLbl);
		
		homeTF = new JTextField();
		homeTF.setBounds(331, 31, 159, 20);
		contentPane.add(homeTF);
		homeTF.setColumns(10);
		
		awayTF = new JTextField();
		awayTF.setBounds(332, 74, 158, 20);
		contentPane.add(awayTF);
		awayTF.setColumns(10);
		
		JLabel priceLbl = new JLabel("Price:");
		priceLbl.setBounds(28, 172, 46, 14);
		contentPane.add(priceLbl);
		
		JLabel awayLbl = new JLabel("Away team:");
		awayLbl.setBounds(231, 77, 90, 14);
		contentPane.add(awayLbl);
		
		JLabel notificationLbl = new JLabel("");
		notificationLbl.setBounds(107, 372, 312, 14);
		contentPane.add(notificationLbl);
		
		matchTypeTF = new JTextField();
		matchTypeTF.setBounds(331, 119, 158, 20);
		contentPane.add(matchTypeTF);
		matchTypeTF.setColumns(10);
		
		
		
		
		JButton addBtn = new JButton("Add sports event");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(eventNametTF.getText().isEmpty() || dateTF.getText().isEmpty() || locationTF.getText().isEmpty() || 
						 priceTF.getText().isEmpty() || homeTF.getText().isEmpty() || awayTF.getText().isEmpty() || matchTypeTF.getText().isEmpty())
					 notificationLbl.setText("please fill all the fields");
				 else
				 {
					 String eventName = eventNametTF.getText();
	                 
	                 
	                 String date = dateTF.getText();
	                 while (!EventManagementSystem.isValidDate(date)) {
	                	 notificationLbl.setText("Invalid date format. Enter date (YYYY-MM-DD): ");
	                     date = dateTF.getText();
	                 }
	                
	                 String location = locationTF.getText();
	                 
	                 double price = Double.parseDouble(priceTF.getText()); 
	                 
	                 String home= homeTF.getText();
	                 
	                 String away= awayTF.getText();
	                 
	                 String matchType= matchTypeTF.getText();
	                 
	                 Event event = new SportsEvent(eventName, date, location, price, home, away, matchType);
	                 notificationLbl.setText(EventManagementSystem.addEvent(event));
	                 mmf.getComboBox().setModel(new DefaultComboBoxModel(EventManagementSystem.getIDs()));
				 }
				  
			}
		});
		addBtn.setBounds(198, 328, 123, 33);
		contentPane.add(addBtn);
		
		
	}
}