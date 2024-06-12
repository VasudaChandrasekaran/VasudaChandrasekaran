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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ImageIcon;

public class attendance extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					attendance frame = new attendance();
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
	public attendance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STAFF LOGIN");
		lblNewLabel.setBounds(141, 11, 135, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Emp Name:");
		lblNewLabel_1.setBounds(10, 52, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setBounds(10, 92, 80, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_4 = new JButton("next");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					selecthour newframe=new selecthour();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_4).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_4, this, "Error while establishing connection failed", 0);
				}
			}
		});
		btnNewButton_4.setBounds(305, 201, 89, 23);
		contentPane.add(btnNewButton_4);
		
		textField = new JTextField();
		textField.setBounds(115, 49, 97, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 89, 97, 23);
		contentPane.add(passwordField);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Show Password");
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
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		rdbtnNewRadioButton.setBounds(230, 89, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Sekar\\Downloads\\Simple Plain Aesthetic Neutral Colored Pink Wallpaper With Copyspace Background, Wallpaper, Wallpaper Dinding, Simple Wallpaper Background Image And Wallpaper for Free Download.jpg"));
		lblNewLabel_3.setBounds(0, 0, 424, 250);
		contentPane.add(lblNewLabel_3);
	}
}
