package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import User.User;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import sys.EventManagementSystem;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordTF;
	private JTextField usernameTF;

	MainMenuFrame mmf=null;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public RegisterFrame(MainMenuFrame frame) {
		mmf=frame;

		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 300);
		contentPane = new JPanel();
		contentPane.addKeyListener(new KeyAdapter() {});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(131, 21, 192, 20);
		contentPane.add(usernameTF);
		usernameTF.setColumns(10);
		
		JLabel notifyLbl = new JLabel("");
		notifyLbl.setHorizontalAlignment(SwingConstants.CENTER);
		notifyLbl.setBounds(83, 191, 192, 14);
		contentPane.add(notifyLbl);
		
		passwordTF = new JPasswordField();
		passwordTF.addKeyListener(new KeyAdapter() {
			
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					if(passwordTF.getPassword().length>6)
					{
						
						notifyLbl.setText("password is secure!");
					}else
					{
						notifyLbl.setText("password is not secure enough!");
					}
						
				}
					
				}
			
		});
		passwordTF.setBounds(131, 66, 192, 20);
		contentPane.add(passwordTF);
		passwordTF.setColumns(10);
		
		JLabel usernameLbl = new JLabel("Username:");
		usernameLbl.setBounds(26, 24, 73, 14);
		contentPane.add(usernameLbl);
		
		JLabel passwordLbl = new JLabel("Password:");
		passwordLbl.setBounds(26, 69, 73, 14);
		contentPane.add(passwordLbl);
		
		JRadioButton yesRdBtn = new JRadioButton("yes");
		buttonGroup.add(yesRdBtn);
		yesRdBtn.setBounds(131, 114, 55, 23);
		contentPane.add(yesRdBtn);
		
		JRadioButton noRdBtn = new JRadioButton("no");
		buttonGroup.add(noRdBtn);
		noRdBtn.setBounds(188, 114, 55, 23);
		contentPane.add(noRdBtn);
		
		JButton registerBtn = new JButton("Register");
		registerBtn.addKeyListener(new KeyAdapter() {
			
		});
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String email=usernameTF.getText();
					String password=passwordTF.getPassword()+"";
					if(email.isEmpty()||password.isEmpty())
					{
						notifyLbl.setText("fill the neccessary fields");
					}else
					{
					boolean isStudent=false;
					if(yesRdBtn.isSelected())
					{
						isStudent=true;
					}
				User user = new User(email, password, false, isStudent);
                EventManagementSystem.addUser(user);
                notifyLbl.setText("you are registered successfuly!");
					}
					
				
			}
		});
		registerBtn.setBounds(131, 158, 89, 23);
		contentPane.add(registerBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mmf.setVisible(true);
				
			}
		});
		cancelBtn.setBounds(356, 232, 89, 23);
		contentPane.add(cancelBtn);
		
		JLabel stuLbl = new JLabel("Are you a student?");
		stuLbl.setBounds(26, 118, 99, 14);
		contentPane.add(stuLbl);
		
		JLabel secureLbl = new JLabel("press enter to check the security of the password");
		secureLbl.setBounds(10, 236, 313, 14);
		contentPane.add(secureLbl);
		
	
	}
}