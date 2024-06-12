package dbmsattendance;


import java.awt.EventQueue;
import javax.swing.*;
import java.sql.*;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class loginpage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	private JLabel error;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpage frame = new loginpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 error = new JLabel("");
		 error.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		 error.setBounds(10, 124, 221, 62);
		 contentPane.add(error);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setBounds(71, 50, 105, 39);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 14));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("password");
		lblNewLabel.setBounds(71, 102, 105, 14);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 14));
		contentPane.add(lblNewLabel);
		
		user = new JTextField();
		user.setBounds(174, 61, 86, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(174, 101, 86, 20);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(270, 143, 105, 23);
		btnNewButton.addActionListener(new ActionListener() {
			private int yu;

			public void actionPerformed(ActionEvent e) {try {
				int er=0;
				String us = user.getText();
				String ps = pass.getText();
				System.out.println(us);
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println(ps);
				Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","vasuda123");
				System.out.println("1");
				Statement st = con.createStatement();
				System.out.println("1");
				String sql = "Select * from access";
				System.out.println("1");
				ResultSet rs = st.executeQuery(sql);
				System.out.println("1");
				while(rs.next()){
				String username = rs.getString("username");
				System.out.println("1-");
				String password = rs.getString("password");
				System.out.println("1-");

				if(us.equals(username) && ps.equals(password)){
					yu=1;
				new second ().setVisible(true);
				System.out.println("true");
				SwingUtilities.windowForComponent(btnNewButton).dispose();
				er=0;
				break;
				}
				else if(us.equals(username) && ps!=password){
					
					yu=2;
				
				}
				else{
				user.setText("");
				pass.setText("");
				yu=0;
				System.out.println("false");
				er=1;
				}
				if(yu==2) {
					JOptionPane.showMessageDialog(null,"password mismatch");
				}
				
				
			}
				if(er==1)
					{
					error.setVisible(true);
					error.setText("incorrect Password or username");
					}
					}
			catch(Exception o) {
				JOptionPane.showMessageDialog(null,o);
			}
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 14));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("FORGET PASSWORD");
		btnNewButton_1.setBounds(10, 185, 195, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new updatepassword().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_1,this,"error while establishing connenction failed",0);
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 14));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SIGN IN/SIGN UP");
		btnNewButton_2.setBounds(10, 210, 195, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new signup().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_2).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_2,this,"error while establishing connenction failed",0);
				}
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 14));
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(-13, 0, 447, 261);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Sekar\\Downloads\\WhatsApp Image 2024-02-25 at 18.27.03.jpeg"));
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("New label");
		label.setBounds(159, 11, 46, 14);
		contentPane.add(label);
	}
}
