package JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DemoJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtID;
	private JTextField txtName;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblGPA;
	private JTextField txtGpa;
	private JLabel lblYear;
	private Connection con;
	private DefaultTableModel model;
	private String url="jdbc:mysql://localhost/jframe";
	private JComboBox comboBoxYear;
	private JRadioButton rdbtnMale,rdbtnFemale,rdbtnOther;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoJFrame frame = new DemoJFrame();
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
	public DemoJFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			
				try {
					//1. Load Driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					//2. Create Connection
					con=DriverManager.getConnection(url,"root","");
					String sql="select * from demojframe";
					//3. Execute sql Command
					Statement sm=con.createStatement();
					ResultSet rs=sm.executeQuery(sql);
					
					while(rs.next()) {
						String rows[]= {rs.getString(1),
								rs.getString(2),
								rs.getString("gpa"),
								rs.getString("year"),
								rs.getString("gender"),
								rs.getString("email")};
						
						model.addRow(rows);
					}
					//4. Close Connection
					sm.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 213, 617, 204);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row=table.getSelectedRow();
				txtID.setText(table.getValueAt(row, 0).toString());
				txtName.setText(table.getValueAt(row, 1).toString());
				txtGpa.setText(table.getValueAt(row, 2).toString());
				comboBoxYear.setSelectedItem(table.getValueAt(row, 3).toString());
				txtEmail.setText(table.getValueAt(row, 4).toString());
				String gender=table.getValueAt(row, 5).toString();
				if(gender.equals("Male")) {
					rdbtnMale.setSelected(true);
				}
				else if(gender.equals("Female")) {
					rdbtnFemale.setSelected(true);
				}
				else {
					rdbtnOther.setSelected(true);
				}
			}
			
			
		});
		scrollPane.setViewportView(table);
		table.setModel(model=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name" , "GPA" , "Year" , "Gender" , "Email"
			}
		));
		
		
		JLabel lblID = new JLabel("ID :");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblID.setBounds(89, 45, 81, 32);
		contentPane.add(lblID);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(295, 42, 96, 39);
		contentPane.add(lblName);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtID.setBounds(133, 49, 96, 19);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtName.setColumns(10);
		txtName.setBounds(360, 52, 96, 19);
		contentPane.add(txtName);
		
		lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(299, 84, 81, 13);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtEmail.setBounds(360, 81, 96, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		lblGPA = new JLabel("GPA :");
		lblGPA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGPA.setBounds(78, 87, 45, 13);
		contentPane.add(lblGPA);
		
		txtGpa = new JTextField();
		txtGpa.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtGpa.setColumns(10);
		txtGpa.setBounds(133, 84, 96, 19);
		contentPane.add(txtGpa);
		
		lblYear = new JLabel("Year :");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYear.setBounds(78, 118, 45, 13);
		contentPane.add(lblYear);
		
		JComboBox comboBoxYear = new JComboBox();
		comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBoxYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxYear.setBounds(133, 116, 96, 21);
		contentPane.add(comboBoxYear);

		
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(284, 118, 86, 13);
		contentPane.add(lblGender);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnFemale.setBounds(422, 114, 86, 21);
		contentPane.add(rdbtnFemale);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnMale.setBounds(360, 114, 75, 21);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnOther.setBounds(506, 114, 81, 21);
		contentPane.add(rdbtnOther);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con=DriverManager.getConnection(url,"root","");
					String sql="insert into demojframe (id,name,gpa,year,gender,email) values(?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, txtID.getText());
					ps.setString(2, txtName.getText());
					ps.setString(3, txtGpa.getText());
					int year=Integer.parseInt(comboBoxYear.getSelectedItem().toString());
					ps.setInt(4, year);

					String gender;
					if(rdbtnMale.isSelected()) {
						gender="Male";
					}else if(rdbtnFemale.isSelected()) {
						gender="Female";
					}else {
						gender="Other";
					}
					ps.setString(5, gender);
					ps.setString(6, txtEmail.getText());

				
					
					if(ps.executeUpdate()>=1) {
						JOptionPane.showMessageDialog(null, "Insert complete...");
					}
					
					ps.close();
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnInsert.setBounds(40, 168, 85, 21);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(133, 168, 85, 21);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con=DriverManager.getConnection(url,"root","");
					String sql="delete from demojframe where id=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, txtID.getText());
					
					if(JOptionPane.showConfirmDialog(null,"Are you sure?","Confirmation",JOptionPane.YES_NO_OPTION )==JOptionPane.YES_OPTION) {
						
						if(ps.executeUpdate()>=1) {
							JOptionPane.showMessageDialog(null, "Selected row was deleted...");
						}
					}
					
					ps.close();
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(228, 168, 85, 21);
		contentPane.add(btnDelete);
		
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(566, 168, 85, 21);
		contentPane.add(btnRefresh);
	}
}
