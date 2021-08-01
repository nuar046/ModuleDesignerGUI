import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.script.*;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn = null;
	private JTextField textUsername;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JTextField textDatabase;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 382, 254);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(73, 70, 68, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(73, 110, 68, 14);
		frame.getContentPane().add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(151, 67, 127, 20);
		frame.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(151, 107, 127, 20);
		frame.getContentPane().add(passwordField);
		
		lblNewLabel = new JLabel("Database");
		lblNewLabel.setBounds(73, 36, 68, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textDatabase = new JTextField();
		textDatabase.setText("");
		textDatabase.setBounds(151, 33, 127, 20);
		frame.getContentPane().add(textDatabase);
		textDatabase.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = postgressConnection.dbconnector(textUsername.getText(),passwordField.getText(),textDatabase.getText());
					frame.dispose();
					MainPage mp = new MainPage();
					mp.setVisible(true);
				
				}catch(Exception error) {
					JOptionPane.showMessageDialog(null, error);
				}
				
			}
		});
		btnLogin.setBounds(116, 157, 144, 23);
		frame.getContentPane().add(btnLogin);
		
		
	}
}
