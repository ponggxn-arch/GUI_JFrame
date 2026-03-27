package dbase;

/*
 * Database name: dbase
 * Table name : tb_student
 * column list : sid,sname,gpa,year,email,gender
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Connection con;
	private String url="jdbc:mysql://localhost/dbase";
	private DefaultTableModel model;
	private JTextField txtGpa;
	private JTextField txtName;
	private JTextField txtID;
	private JTextField txtEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox cbYear;
	private JRadioButton rdMale,rdFemale,rdOther;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame();
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
	public StudentFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			
				try {
					//1. Load Driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					//2. Create Connection
					con=DriverManager.getConnection(url,"root","");
					String sql="select * from tb_student";
					//3. Execute sql Command
					Statement sm=con.createStatement();
					ResultSet rs=sm.executeQuery(sql);
					
					while(rs.next()) {
						String rows[]= {rs.getString(1),
								rs.getString(2),
								rs.getString("gpa"),
								rs.getString("year"),
								rs.getString("email"),
								rs.getString("gender")};
						
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
		setBounds(100, 100, 653, 467);
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
				cbYear.setSelectedItem(table.getValueAt(row, 3).toString());
				txtEmail.setText(table.getValueAt(row, 4).toString());
				String gender=table.getValueAt(row, 5).toString();
				if(gender.equals("Male")) {
					rdMale.setSelected(true);
				}
				else if(gender.equals("Female")) {
					rdFemale.setSelected(true);
				}
				else {
					rdOther.setSelected(true);
				}
			}
			
			
		});
		scrollPane.setViewportView(table);
		table.setModel(model=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name" , "GPA" , "Year" , "Email" , "Gender"
			}
		));
		
		txtGpa = new JTextField();
		txtGpa.setBounds(80, 66, 86, 28);
		contentPane.add(txtGpa);
		txtGpa.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(255, 31, 201, 28);
		contentPane.add(txtName);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(80, 31, 86, 28);
		contentPane.add(txtID);
		
		cbYear = new JComboBox();
		cbYear.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		cbYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbYear.setBounds(80, 105, 86, 28);
		contentPane.add(cbYear);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(255, 66, 201, 28);
		contentPane.add(txtEmail);
		
		rdMale = new JRadioButton("Male");
		buttonGroup.add(rdMale);
		rdMale.setBounds(265, 102, 57, 23);
		contentPane.add(rdMale);
		
		rdFemale = new JRadioButton("Female");
		buttonGroup.add(rdFemale);
		rdFemale.setBounds(324, 102, 70, 23);
		contentPane.add(rdFemale);
		
		rdOther = new JRadioButton("Other");
		buttonGroup.add(rdOther);
		rdOther.setBounds(396, 101, 57, 23);
		contentPane.add(rdOther);
		
		JLabel lblID = new JLabel("ID :");
		lblID.setBounds(34, 38, 46, 14);
		contentPane.add(lblID);
		
		JLabel lblGpa = new JLabel("GPA :");
		lblGpa.setBounds(24, 73, 46, 14);
		contentPane.add(lblGpa);
		
		JLabel lblYear = new JLabel("Year :");
		lblYear.setBounds(24, 105, 46, 14);
		contentPane.add(lblYear);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(212, 38, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(212, 73, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(203, 105, 46, 14);
		contentPane.add(lblGender);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con=DriverManager.getConnection(url,"root","");
					String sql="insert into tb_student (sid,sname,gpa,year,gender,email) values(?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, txtID.getText());
					ps.setString(2, txtName.getText());
					ps.setString(3, txtGpa.getText());
					int year=Integer.parseInt(cbYear.getSelectedItem().toString());
					ps.setInt(4, year);

					String gender;
					if(rdMale.isSelected()) {
						gender="Male";
					}else if(rdFemale.isSelected()) {
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
		btnInsert.setBounds(10, 179, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con=DriverManager.getConnection(url,"root","");
					String sql="delete from tb_student where sid=?";
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
		btnDelete.setBounds(111, 179, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con=DriverManager.getConnection(url,"root","");
					String sql = "update tb_student set sname=?, gender=?, gpa=?, year=?, email=? where sid=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, txtName.getText());
					String gender;
					if(rdMale.isSelected()) {
						gender="Male";
					}
					else if(rdFemale.isSelected()) {
						gender="Female";
					}else {
						gender="Other";
					}
					ps.setString(2, gender);
					ps.setFloat(3,Float.parseFloat(txtGpa.getText()));
					int year=Integer.parseInt(cbYear.getSelectedItem().toString());
					ps.setInt(4, year);
					
					ps.setString(5, txtEmail.getText());
					ps.setString(6, txtID.getText());

	
					
					if(ps.executeUpdate()>=1) {
						JOptionPane.showMessageDialog(null, "Update complete...");						
					}
					ps.close();
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(214, 179, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(model=new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ID", "Name" , "GPA" , "Year" , "Email" , "Gender"
						}
					));
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection(url,"root","");
					String sql="select * from tb_student";
					Statement sm=con.createStatement();
					ResultSet rs=sm.executeQuery(sql);
					
					while(rs.next()) {
						String rows[]= {rs.getString(1),
								rs.getString(2),
								rs.getString("gpa"),
								rs.getString("year"),
								rs.getString("email"),
								rs.getString("gender")};
						
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
		btnRefresh.setBounds(538, 179, 89, 23);
		contentPane.add(btnRefresh);
	}
}
