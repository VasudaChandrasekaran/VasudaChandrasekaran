package dbmsattendance;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class second extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					second frame = new second();
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
	public second() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loginpage newframe =  new loginpage ();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
				}

			}
		});
		btnNewButton.setBounds(180, 206, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("ATTENDANCE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					attendance newframe=new attendance();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_2).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_2, this, "Error while establishing connection failed", 0);
				}
			}
		});
		btnNewButton_2.setBounds(160, 67, 122, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("LEAVE MANAGEMENT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					leave newframe=new leave();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_3).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_3, this, "Error while establishing connection failed", 0);
				}
			}
		});
		btnNewButton_3.setBounds(137, 137, 158, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sekar\\Downloads\\Pin by Thn on Noivas in 2022 _ Floral wallpaper phone, Scrapbook background, Floral poster.jpg"));
		lblNewLabel.setBounds(-20, -5, 464, 274);
		contentPane.add(lblNewLabel);
	}

}
