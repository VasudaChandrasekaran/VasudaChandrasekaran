package dbmsattendance;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class updatepassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatepassword frame = new updatepassword();
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
	public updatepassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE PASSWORD");
		lblNewLabel.setBounds(159, 34, 137, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBounds(88, 113, 126, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CONFIRM PASSWORD");
		lblNewLabel_2.setBounds(88, 138, 126, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.addActionListener(new ActionListener() {
			private int yu;

			public void actionPerformed(ActionEvent e) {
				try {
					int i=1;
					String us1 = textField.getText();
					String np = passwordField.getText();	
					String cp = passwordField_1.getText();
					if(np.equals(cp))
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","vasuda123");
					Statement st1 = con1.createStatement();
					String sql1 =  "Select * from access";
					ResultSet res1 = st1.executeQuery(sql1);
					while(res1.next()) {
						String use1 = res1.getString("username");
						System.out.print("1");
						if(us1.equals(use1) && np.equals(cp)) {
							yu=1;
							String sql2 = "update access set password = '"+np+"' where username = '"+us1+"'";
							PreparedStatement pts = con1.prepareStatement(sql2);
							System.out.print(np);
						    /*pts.setValueAt(np,sql2,0);
						    System.out.print(i);
							pts.setInt(1,i);
							System.out.println(sql2);*/
							System.out.println("2");
							pts.executeUpdate(sql2);
							System.out.print("success");
							JOptionPane.showMessageDialog(btnNewButton_2, " data updated", "updated", -1);
							try {
								loginpage newframe = new loginpage();
							    newframe.setVisible(true);
								SwingUtilities.windowForComponent(btnNewButton_2).dispose();
								
							}
							catch(Exception a)
							{
								JOptionPane.showMessageDialog(btnNewButton_2, this, "Error while establishing connection failed", 0);
							}
						}
						else {
							textField.setText("");
							passwordField.setText("");
							passwordField_1.setText("");
							yu=0;
							
						}
						i++;
						
					}
					if(yu==0) {
						JOptionPane.showMessageDialog(null,"password mismatch");
					}
						
					
					}
			
					catch(Exception os)
					{
						System.out.print(os);
						JOptionPane.showMessageDialog(btnNewButton_2, this, "Error while establishing connection failed", 0);
					}
			}
		});
		btnNewButton_2.setBounds(159, 185, 89, 23);
		contentPane.add(btnNewButton_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(224, 110, 120, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(224, 138, 120, 20);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_3 = new JLabel("user name");
		lblNewLabel_3.setBounds(86, 73, 105, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(224, 70, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Sekar\\Downloads\\Download free image of Aesthetic landscape mobile wallpaper, brown crayon texture by Baifern about abstract beige, abstract minimal, brown aesthetic wallpaper, wallpaper background minimalist abstract, and beig (1).jpg"));
		lblNewLabel_4.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_4);
	}
}
