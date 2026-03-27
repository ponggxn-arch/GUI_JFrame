package GUIProject2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTable tblEmp;
	private DefaultTableModel model;
	private JButton btnInsert;
	private JTextField txtSalary;
	private JLabel lblSalary;
	private JTextField txtAge;
	private JLabel lblAge;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnLoad;
	JRadioButton rdbtnNewRadioButton,rdbtnNewRadioButton_1,rdbtnNewRadioButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm frame = new EmployeeForm();
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
	public EmployeeForm() {

		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/empdb","root","");
					Statement stm=con.createStatement();
					String sql="select * from tb_employee ";
					ResultSet rs= stm.executeQuery(sql);
					
					while(rs.next()){
						
						String row[]= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
						model.addRow(row);
		}
					stm.close();
					con.close();
		
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setTitle("Employee Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 577);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtID = new JTextField();
		txtID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.requestFocus();
			}
		});
		txtID.setBounds(162, 24, 117, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(320, 25, 76, 14);
		contentPane.add(lblName);
		
		JLabel lblID = new JLabel("Employee ID");
		lblID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblID.setBounds(41, 23, 111, 19);
		contentPane.add(lblID);
		
		txtName = new JTextField();
		txtName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSalary.requestFocus();
			}
		});
		txtName.setColumns(10);
		txtName.setBounds(406, 24, 246, 20);
		contentPane.add(txtName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 306, 610, 221);
		contentPane.add(scrollPane);
		
		tblEmp = new JTable();
		tblEmp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(tblEmp);
		JTableHeader head=tblEmp.getTableHeader();
		head.setFont(new Font("Tahoma", Font.BOLD,12));
		
//		tblEmp.setModel(model);
		
		tblEmp.setModel(model=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Salary", "Position" , "Age"
			}
		));
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String rows[] = {txtID.getText(), txtName.getText(),txtSalary.getText(),txtAge.getText()};
				model.addRow(rows);*/
				
				Connection conn;
				String pst;
				try {
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost/empdb","root","");
					String sql="insert into tb_employee (eid,ename,salary,position,age) values(?,?,?,?,?)";
//					String sql="insert into tb_employee (eid,ename,salary) values(?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, txtID.getText());
					ps.setString(2, txtName.getText());
					ps.setLong(3, Long.parseLong(txtSalary.getText()));
					
					if(rdbtnNewRadioButton.isSelected()) {
						pst ="Full Time";
					}
					else if(rdbtnNewRadioButton_1.isSelected()) {
						pst ="Part Time";
					}
					else {
						pst ="Manager";
					}

					ps.setString(4,pst);
					ps.setInt(5, Integer.parseInt(txtAge.getText()));
				
					if(ps.executeUpdate()>=1) {
						JOptionPane.showMessageDialog(null, "insert complete");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtID.setText("");
				txtName.setText("");
				txtSalary.setText("");
				txtAge.setText("");
				txtID.requestFocus();

				
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnInsert.setBounds(45, 272, 89, 23);
		contentPane.add(btnInsert);
		
		txtSalary = new JTextField();
		txtSalary.setBounds(162, 51, 117, 20);
		contentPane.add(txtSalary);
		txtSalary.setColumns(10);
		
		lblSalary = new JLabel("Salary");
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSalary.setBounds(41, 53, 111, 19);
		contentPane.add(lblSalary);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(406, 51, 42, 20);
		contentPane.add(txtAge);
		
		lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAge.setBounds(285, 50, 111, 19);
		contentPane.add(lblAge);
		
		rdbtnNewRadioButton = new JRadioButton("Full Time");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBackground(new Color(192, 192, 192));
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(162, 105, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Part Time");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_1.setBackground(new Color(192, 192, 192));
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(162, 144, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Manager");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_2.setBackground(new Color(192, 192, 192));
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(162, 183, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPosition.setBounds(45, 105, 111, 19);
		contentPane.add(lblPosition);
		
		JLabel lblNewLabel = new JLabel("Years");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(457, 55, 46, 14);
		contentPane.add(lblNewLabel);
		
		btnLoad = new JButton("Load data");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				tblEmp.setModel(model=new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ID", "Name", "Salary", "Position" , "Age"
						}
					));
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/empdb","root","");
					Statement stm=con.createStatement();
					String sql="select * from tb_employee ";
					ResultSet rs= stm.executeQuery(sql);
					
					while(rs.next()){
						
						String row[]= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
						model.addRow(row);
		}
					stm.close();
					con.close();
		
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLoad.setBounds(563, 272, 89, 23);
		contentPane.add(btnLoad);
	}
}
