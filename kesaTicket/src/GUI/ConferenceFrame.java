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
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import Event_is_a.*;
import sys.EventManagementSystem;

public class ConferenceFrame extends JFrame {

	private JPanel contentPane;
	private JTextField dateTF;
	private JTextField eventNametTF;
	private JTextField locationTF;
	private JTextField priceTF;
	private JTextField topicCountTF;
	private JTextField topicTF;
	private JTextField speakerNameTF;
	private JTextField speakerCountTF;
	AdminMenuFrame mmf=null;
	
	ArrayList<String> topics = new ArrayList<>();
	 ArrayList<String> speakers = new ArrayList<>();
	 
	 

	public ConferenceFrame(AdminMenuFrame frame) {
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
		
		JLabel notificationLbl = new JLabel("");
		notificationLbl.setBounds(107, 372, 328, 14);
		contentPane.add(notificationLbl);
		
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
		
		JLabel speakerCountLbl = new JLabel("Speaker count:");
		speakerCountLbl.setBounds(231, 172, 90, 14);
		contentPane.add(speakerCountLbl);
		
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
		
		JLabel topicCountLbl = new JLabel("Topic count:");
		topicCountLbl.setBounds(231, 34, 90, 14);
		contentPane.add(topicCountLbl);
		
		JButton addSpeakerBtn = new JButton("Add Speaker");
		addSpeakerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String[] myArray = speakerNameTF.getText().split(",");
				 for (String s : myArray) {
					 speakers.add(s);
				}
				 if(!(topics.size()==Integer.parseInt(speakerCountTF.getText())))
					 notificationLbl.setText("write according to the count");
			}
		});
		addSpeakerBtn.setBounds(385, 258, 105, 23);
		contentPane.add(addSpeakerBtn);
		
		JButton addTopicBtn = new JButton("Add topic");
		addTopicBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				 String[] myArray = topicTF.getText().split(",");
				 for (String s : myArray) {
					 topics.add(s);
				}
				 if(!(topics.size()==Integer.parseInt(topicCountTF.getText())))
					 notificationLbl.setText("write according to the count");
					 
				 
			}
		});
		addTopicBtn.setBounds(385, 115, 105, 23);
		contentPane.add(addTopicBtn);
		
		topicCountTF = new JTextField();
		topicCountTF.setBounds(331, 31, 159, 20);
		contentPane.add(topicCountTF);
		topicCountTF.setColumns(10);
		
		topicTF = new JTextField();
		topicTF.setBounds(332, 74, 158, 20);
		contentPane.add(topicTF);
		topicTF.setColumns(10);
		
		speakerNameTF = new JTextField();
		speakerNameTF.setBounds(332, 209, 158, 20);
		contentPane.add(speakerNameTF);
		speakerNameTF.setColumns(10);
		
		JLabel priceLbl = new JLabel("Price:");
		priceLbl.setBounds(28, 172, 46, 14);
		contentPane.add(priceLbl);
		
		JLabel topicLbl = new JLabel("Topic(\",\"):");
		topicLbl.setBounds(231, 77, 69, 14);
		contentPane.add(topicLbl);
		
		JLabel speakerNameLbl = new JLabel("Speaker Name:");
		speakerNameLbl.setBounds(231, 212, 86, 14);
		contentPane.add(speakerNameLbl);
		
		
		
		speakerCountTF = new JTextField();
		speakerCountTF.setBounds(332, 169, 158, 20);
		contentPane.add(speakerCountTF);
		speakerCountTF.setColumns(10);
		
		
		
		JButton addBtn = new JButton("Add conference");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(eventNametTF.getText().isEmpty() || dateTF.getText().isEmpty() || locationTF.getText().isEmpty() || priceTF.getText().isEmpty())
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
	                 
	               
	  
	                 
	                 Event event = new Conference(eventName, date, location, price, speakers, topics);
	                 notificationLbl.setText(EventManagementSystem.addEvent(event));
	                 mmf.getComboBox().setModel(new DefaultComboBoxModel(EventManagementSystem.getIDs()));
				 }
				 
			}
		});
		addBtn.setBounds(198, 328, 123, 33);
		contentPane.add(addBtn);
		
		
	}
}