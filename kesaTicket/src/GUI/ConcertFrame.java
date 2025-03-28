package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Event.Event;
import sys.EventManagementSystem;
import Event_is_a.*;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConcertFrame extends JFrame {

	private JPanel contentPane;
	private JTextField dateTF;
	private JTextField eventNametTF;
	private JTextField locationTF;
	private JTextField priceTF;
	private JTextField genreTF;
	private JTextField performerTF;
	AdminMenuFrame mmf=null;

	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ConcertFrame(AdminMenuFrame frame) {
		mmf=frame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 352);
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
		
		JLabel notifyLbl = new JLabel("");
		notifyLbl.setBounds(107, 267, 342, 14);
		contentPane.add(notifyLbl);
		
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
		
		JLabel genreLbl = new JLabel("Genre:");
		genreLbl.setBounds(259, 34, 90, 14);
		contentPane.add(genreLbl);
		
		genreTF = new JTextField();
		genreTF.setBounds(331, 31, 159, 20);
		contentPane.add(genreTF);
		genreTF.setColumns(10);
		
		performerTF = new JTextField();
		performerTF.setBounds(332, 74, 158, 20);
		contentPane.add(performerTF);
		performerTF.setColumns(10);
		
		
		JButton addBtn = new JButton("Add concert");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(eventNametTF.getText().isEmpty() || dateTF.getText().isEmpty() || locationTF.getText().isEmpty() 
						|| priceTF.getText().isEmpty() || genreTF.getText().isEmpty() || performerTF.getText().isEmpty())
					notifyLbl.setText("please fill all the fields");
				 else
				 {
					 String eventName = eventNametTF.getText();
	                 
	                 
	                 String date = dateTF.getText();
	                 while (!EventManagementSystem.isValidDate(date)) {
	                	 notifyLbl.setText("Invalid date format. Enter date (YYYY-MM-DD): ");  
	                     date = dateTF.getText();
	                 }
	                
	                 String location = locationTF.getText();
	                 
	                 double price = Double.parseDouble(priceTF.getText()); 
	                 
	                 String genre= genreTF.getText();
	                 
	                 String performer= performerTF.getText();
	                 
	                 Event event = new Concert(eventName, date, location, price, performer, genre);
	                 
	                 notifyLbl.setText(EventManagementSystem.addEvent(event));
	                 mmf.getComboBox().setModel(new DefaultComboBoxModel(EventManagementSystem.getIDs()));
				 }
                

			}
		});
		addBtn.setBounds(207, 223, 123, 33);
		contentPane.add(addBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		cancelBtn.setBounds(484, 279, 89, 23);
		contentPane.add(cancelBtn);
		
		
		
		JLabel priceLbl = new JLabel("Price:");
		priceLbl.setBounds(28, 172, 46, 14);
		contentPane.add(priceLbl);
		
		JLabel performerLbl = new JLabel("Performer:");
		performerLbl.setBounds(259, 77, 99, 14);
		contentPane.add(performerLbl);
		
		JLabel notificationLbl = new JLabel("");
		notificationLbl.setBounds(241, 372, 46, 14);
		contentPane.add(notificationLbl);
	}
}