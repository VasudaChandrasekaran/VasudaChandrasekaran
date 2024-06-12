package dbmsattendance;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class namelistpage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static String gh;
	static String sql;
	static String sql1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					namelistpage frame = new namelistpage();
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
	public namelistpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Apply");
		btnNewButton.setBounds(253, 92, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					S1 frame = new S1();
					frame.setVisible(true);
				} catch (Exception e4) {
					e4.printStackTrace();
				}
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(195, 93, 48, 22);
		comboBox.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				if((comboBox.getSelectedItem())=="cse") {
					gh="cse";
					sql="select * from cse";
					sql1 = "select count(*) from cse";
					System.out.println(comboBox.getSelectedItem()+sql1+sql);
				}
				if((comboBox.getSelectedItem())=="mct") {
					gh="mct";
					sql="select * from mct";
					sql1 = "select count(*) from mct";
					System.out.println(comboBox.getSelectedItem());
				}
				if((comboBox.getSelectedItem())=="ads") {
					gh="newads";
					sql="select * from newads";
					sql1 = "select count(*) from newads";
					System.out.println(comboBox.getSelectedItem());
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "cse", "mct", "ads"}));
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Select the Department");
		lblNewLabel.setBounds(26, 89, 163, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				   selecthour newframe = new selecthour ();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_1, this, "Error while establishing connection failed", 0);
				}
			}
		});
		btnNewButton_1.setBounds(195, 210, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Sekar\\Downloads\\Premium Vector _ Hand painted watercolor abstract watercolor background.jpg"));
		lblNewLabel_1.setBounds(-20, 0, 454, 261);
		contentPane.add(lblNewLabel_1);
	}
}
