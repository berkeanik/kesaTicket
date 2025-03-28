package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import User.User;
import sys.EventManagementSystem;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTF;
	private JPasswordField passwordTF;
	private String email=null;
	MainMenuFrame mmf=null;
	AdminMenuFrame amf=new AdminMenuFrame(this);
    UserMenuFrame umf=new UserMenuFrame(this);
	
    
    public String getUsername() {
		return email;
	}
    
    
	 EventManagementSystem system = new EventManagementSystem();
	/**
	 * Create the frame.
	 */
	public LoginFrame(MainMenuFrame frame) {
		
		
		
		mmf=frame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(143, 41, 164, 20);
		contentPane.add(usernameTF);
		usernameTF.setColumns(10);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(143, 86, 164, 20);
		contentPane.add(passwordTF);
		passwordTF.setColumns(10);
		
		
		JLabel notifyLbl = new JLabel("");
		notifyLbl.setBounds(143, 178, 164, 20);
		contentPane.add(notifyLbl);
		
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User loggedInUser = null;
				email=usernameTF.getText();
				String password=passwordTF.getText();
				if(passwordTF.getText().isEmpty()|| usernameTF.getText().isEmpty())
				{
					notifyLbl.setText("it cant be empty");
				}
				else
				{
					if (system.getUsers().containsKey(email) && system.getUsers().get(email).getPassword().equals(password)) {
	                    loggedInUser = system.getUsers().get(email);
	                    
	                    notifyLbl.setText("Welcome " + (loggedInUser.isAdmin() ? "Admin " : "") + email);
	                    
	                    
	                    if (loggedInUser.isAdmin()) {
	                        amf.setVisible(true);
	                        setVisible(false);
	    				 }
	    				 else {
	    					 umf.setVisible(true);
	    					 setVisible(false);
	    					 
	    				 }
	                    
			}  else {
				 notifyLbl.setText("Invalid email or password.");
            }
				}
				 
			}}
		);
		loginBtn.setBounds(143, 144, 89, 23);
		contentPane.add(loginBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				mmf.setVisible(true);
			}
		});
		cancelBtn.setBounds(335, 227, 89, 23);
		contentPane.add(cancelBtn);
		
		JLabel paswordLbl = new JLabel("Password:");
		paswordLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		paswordLbl.setBounds(34, 86, 74, 20);
		contentPane.add(paswordLbl);
		
		JLabel usernameLbl = new JLabel("Username:");
		usernameLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		usernameLbl.setBounds(34, 44, 74, 14);
		contentPane.add(usernameLbl);
		
	
	}
}
