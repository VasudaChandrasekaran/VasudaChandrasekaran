package dbmsattendance;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import dbmsattendance.namelistpage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class S1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton[] r= new JButton[10];
	private JLabel[] r1=new JLabel[10];
	private JLabel[] r2=new JLabel[10];
	private String gh;
	private int i;
	private ResultSet rs;
	private int n;
	private String sql;
	private String sql1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					S1 frame = new S1();
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
	public S1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		ActionListener lis = new ActionListener() {
			public void actionPerformed(ActionEvent ew) {
				 if (ew.getSource() instanceof JButton) {
					    
		                String text =((JButton) ew.getSource()).getText();
		                if(text.equals("P")) {
		                	((JButton) ew.getSource()).setBackground(Color.RED);
		                	((JButton) ew.getSource()).setText("A");
		                	
		                }
		                if(text.equals("A")) {
		                	((JButton) ew.getSource()).setBackground(Color.BLUE);
		                	((JButton) ew.getSource()).setText("OD");
		                }
		                if(text.equals("OD")) {
		                	((JButton) ew.getSource()).setBackground(Color.GREEN);
		                	((JButton) ew.getSource()).setText("P");
		                }
		                	
				 }
			}

			
		};
		JLabel lblNewLabel = new JLabel("Reg_no");
		lblNewLabel.setBounds(31, 28, 100, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(185, 28, 100, 31);
		contentPane.add(lblName);
		
		JLabel lblAttendance = new JLabel("Attendance");
		lblAttendance.setBounds(310, 28, 100, 31);
		contentPane.add(lblAttendance);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for(i=0;i<n;i++) {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","vasuda123");
						Statement st =con.createStatement();
						String sq1 = "update "+namelistpage.gh+" set Attendance='"+r[i].getText()+"' where Reg_no='"+r1[i].getText()+"'";
						PreparedStatement ps1 = con.prepareStatement(sq1);
						int ra = ps1.executeUpdate();
						if(ra>0) {
							System.out.println("Yes");
							JOptionPane.showMessageDialog(btnNewButton,"submitted","Status", -1);
							
						}
						else {
							System.out.println("No");
						}
					}
				}
				catch(Exception rt) {
					
				}
			}
		});
		btnNewButton.setBounds(375, 548, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","vasuda123");
					Statement st=con.createStatement();
					//String sql="select * from "+gh+"";
					//String sql1 = "select count(*) from "+gh+"";
					PreparedStatement pts1=con.prepareStatement(namelistpage.sql1);
					ResultSet rs2=pts1.executeQuery();
				    while(rs2.next()) {
				    	n=rs2.getInt(1);
				    }
					PreparedStatement pts=con.prepareStatement(namelistpage.sql);
					rs= pts.executeQuery();
					
				}
				catch(Exception et) {
					et.printStackTrace();
				}
				for(i=0;i<n;i++) {
					try {
					if(rs.next()) 
					{			
					r[i]=new JButton("P");
					r[i].setFont(new Font("Tahoma",Font.PLAIN, 10));
					r[i].setBounds(320, (i+1)*55,50,35);
					r[i].setBackground(Color.GREEN);
					r[i].addActionListener(lis);
					r1[i]=new JLabel(rs.getString(1));
					r1[i].setFont(new Font("Tahoma",Font.PLAIN, 10));
					r1[i].setBounds(35, (i+1)*55,70,35);
					contentPane.add(r1[i]);
					r2[i]=new JLabel(rs.getString(2));
					r2[i].setFont(new Font("Tahoma",Font.PLAIN, 10));
					r2[i].setBounds(190, (i+1)*55,75,35);
					contentPane.add(r2[i]);
					contentPane.add(r[i]);
					}}
					catch(Exception yt) {
						}
					}
				
			}
		});
		btnNewButton_1.setBounds(528, 239, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					namelistpage newframe = new namelistpage ();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_2).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_2, this, "Error while establishing connection failed", 0);
				}}
		});
		btnNewButton_2.setBounds(143, 548, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
