package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenuFrame extends JFrame {
    private JButton loginBtn, registerBtn, exitBtn;
    
    LoginFrame lf=new LoginFrame(this);
    RegisterFrame rf=new RegisterFrame(this);

    public MainMenuFrame() {
        setTitle("KESATICKET");
        setSize(560, 472);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window

        loginBtn = new JButton("Login");
        loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        loginBtn.setBounds(142, 346, 104, 23);
        registerBtn = new JButton("Register");
        registerBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        registerBtn.setBounds(294, 346, 100, 23);
        exitBtn = new JButton("Exit");
        exitBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        exitBtn.setBounds(463, 399, 71, 23);

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lf.setVisible(true);  // Open login window
            	setVisible(false);  // Close the current window
            }
        });

        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rf.setVisible(true);  // Open register window
                setVisible(false);  // Close the current window
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(loginBtn);
        panel.add(registerBtn);
        panel.add(exitBtn);

        getContentPane().add(panel);
        
        JLabel welcomLbl = new JLabel("Welcome to KesaTicket");
        welcomLbl.setFont(new Font("Tahoma", Font.BOLD, 25));
        welcomLbl.setHorizontalAlignment(SwingConstants.CENTER);
        welcomLbl.setBounds(115, 297, 312, 38);
        panel.add(welcomLbl);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		lf.setVisible(true);  
            	setVisible(false); 
        		
        	}
        });
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\berke-LENOVO\\Desktop\\Screenshot 2024-12-20 133422.png"));
        lblNewLabel.setBounds(-62, -54, 687, 340);
        panel.add(lblNewLabel);
    }
}
