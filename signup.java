package dbmsattendance;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.sql.*;
import javax.swing.ImageIcon;
public class signup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGNUP");
		lblNewLabel.setBounds(198, 10, 37, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setBounds(70, 65, 92, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setBounds(70, 114, 92, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("confirm password");
		lblNewLabel_3.setBounds(70, 154, 110, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_3 = new JButton("back");
		btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				loginpage newframe = new loginpage ();
				newframe.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_3).dispose();
			}
			
			catch(Exception o) {
				JOptionPane.showMessageDialog(btnNewButton_3,this,"error while establishing connenction failed",0);
			}
			
			
		}
		});
		btnNewButton_3.setBounds(31, 199, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("next");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{String us = textField.getText();
				String np = passwordField.getText();
				String cp = passwordField_1.getText();
				if(np.equals(cp)){
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","vasuda123");
				System.out.println("1");
				Statement st = con.createStatement();
				String sql2 = "select count(*) as COUNT from access";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ResultSet res2 = ps2.executeQuery();
				String sql = "SELECT * FROM access";
				ResultSet res1 = st.executeQuery(sql);
				int c = 0;
				while(res2.next()) {
					c = res2.getInt(1);
					
				}
				c=c+2;
				while(res1.next()) {
					String use1 = res1.getString("username");
					if(us!=use1) {
						String sql3 = "insert into access values('"+us+"','"+np+"')";
						PreparedStatement pts = con.prepareStatement(sql3);
						pts.executeUpdate(sql3);
						try {
							loginpage newframe=new loginpage();
							newframe.setVisible(true);
							SwingUtilities.windowForComponent(btnNewButton_3).dispose();
						}
						catch(Exception o) {
							JOptionPane.showMessageDialog(btnNewButton_4,this,"error while establishing connenction failed",0);
						}} 
						else {
							textField.setText("");
							passwordField.setText("");
						}
						
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"password mismatch");
				}
				
					
				}
				catch(Exception r) {
					JOptionPane.showMessageDialog(btnNewButton_4,this,"error while establishing connenction failed",0);			
					}
			}}
		);
		btnNewButton_4.setBounds(299, 197, 89, 23);
		contentPane.add(btnNewButton_4);
		
		textField = new JTextField();
		textField.setBounds(198, 62, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(198, 111, 89, 23);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(196, 151, 88, 23);
		contentPane.add(passwordField_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("show password");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton.setBounds(297, 110, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Sekar\\Downloads\\Download free image of Aesthetic landscape mobile wallpaper, brown crayon texture by Baifern about abstract beige, abstract minimal, brown aesthetic wallpaper, wallpaper background minimalist abstract, and beige cr.jpg"));
		lblNewLabel_4.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_4);

}}
