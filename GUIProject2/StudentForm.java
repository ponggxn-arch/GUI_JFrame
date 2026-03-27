package GUIProject2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class StudentForm extends JFrame implements WindowListener{
	
	JTable tblStudent=new JTable();
	JLabel lbID,lbName,lbEmail,lbGpa,lbGender ,lbMajor;
	JTextField txtID,txtName,txtEmail,txtGpa;
	JButton btnInsert,btnDelete,btnUpdate,btnCancel;
	JRadioButton rdMale,rdFemale,rdOther,rdIt,rdCmd,rdCs;
	JScrollPane sp=new JScrollPane(tblStudent);
	DefaultTableModel model;
	Font font=new Font("Dubai" , Font.PLAIN,20);
	ButtonGroup group1=new ButtonGroup();
	ButtonGroup group2=new ButtonGroup();
	
	public StudentForm() {
		lbID=new JLabel("Student ID : ");
		lbName=new JLabel("Student Name :");
		lbEmail=new JLabel("Email : ");
		lbGpa=new JLabel("GPA : ");
		lbGender=new JLabel("Gender : ");
		lbMajor=new JLabel("Major : ");
		txtID=new JTextField();
		txtName=new JTextField();
		txtEmail=new JTextField();
		txtGpa=new JTextField();
		group1.add(rdMale);
		group1.add(rdFemale);
		group1.add(rdOther);
		group2.add(rdIt);
		group2.add(rdCmd);
		group2.add(rdCs);
		
		lbID.setFont(font);
		lbName.setFont(font);
		lbEmail.setFont(font);
		lbGpa.setFont(font);
		lbGender.setFont(font);
		lbMajor.setFont(font);
		txtID.setFont(font);
		txtName.setFont(font);
		txtEmail.setFont(font);
		txtGpa.setFont(font);
		
		btnInsert=new JButton("Insert");
		btnDelete=new JButton("Delete");
		btnUpdate=new JButton("Update");
		btnCancel=new JButton("Cancel");

		rdMale=new JRadioButton("Male");
		rdFemale=new JRadioButton("Female");
		rdOther=new JRadioButton("Other");
		rdIt=new JRadioButton("IT");
		rdCmd=new JRadioButton("CMD");
		rdCs=new JRadioButton("CS");
		
		rdMale.setFont(font);
		rdFemale.setFont(font);
		rdOther.setFont(font);
		rdIt.setFont(font);
		rdCmd.setFont(font);
		rdCs.setFont(font);

		btnInsert.setFont(font);
		btnDelete.setFont(font);
		btnUpdate.setFont(font);
		btnCancel.setFont(font);

		
		lbID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbName.setHorizontalAlignment(SwingConstants.RIGHT);
		lbGpa.setHorizontalAlignment(SwingConstants.RIGHT);
		lbEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lbGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMajor.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		btnInsert.setBounds(220,600,150,50);
		btnDelete.setBounds(380,600,150,50);
		btnUpdate.setBounds(540,600,150,50);
		btnCancel.setBounds(700,600,150,50);
		
		lbID.setBounds(10, 400, 200, 30);
		txtID.setBounds(220, 400, 150, 40);
		
		lbName.setBounds(10, 460, 200, 30);
		txtName.setBounds(220, 460, 250, 40);
		
		lbEmail.setBounds(10, 520, 200, 30);
		txtEmail.setBounds(220, 520, 250, 40);
		
		lbGpa.setBounds(450, 400, 150, 30);
		txtGpa.setBounds(620, 400, 100, 40);
		
		lbGender.setBounds(450, 450, 150, 30);
		rdMale.setBounds(620,450,100,40);
		rdFemale.setBounds(720,450,100,40);
		rdOther.setBounds(820,450,100,40);
		
		lbGender.setBounds(450, 450, 150, 30);
		rdMale.setBounds(620,450,100,40);
		rdFemale.setBounds(720,450,100,40);
		rdOther.setBounds(820,450,100,40);
		
		lbMajor.setBounds(450, 500, 150, 30);
		rdIt.setBounds(620,500,100,40);
		rdCmd.setBounds(720,500,100,40);
		rdCs.setBounds(820,500,100,40);
		
		add(rdIt);add(rdCmd);add(rdCs);
		add(rdMale);add(rdFemale);add(rdOther);
		add(lbID);add(txtID);
		add(lbName);add(txtName);
		add(lbEmail);add(txtEmail);
		add(lbGpa);add(txtGpa);add(lbGender);add(lbMajor);
		add(btnInsert);add(btnUpdate);
		add(btnDelete);add(btnCancel);
		group1.add(rdMale);
		group1.add(rdFemale);
		group1.add(rdOther);
		group2.add(rdIt);
		group2.add(rdCmd);
		group2.add(rdCs);
		
		model=(DefaultTableModel) tblStudent.getModel();
		sp.setBounds(10,10,1260,350);
		add(sp);
		
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int row=tblStudent.getSelectedRow();
				
				model.setValueAt(txtID.getText(), row, 0);
				model.setValueAt(txtName.getText(), row, 1);
				model.setValueAt(txtGpa.getText(), row, 2);
				model.setValueAt(txtEmail.getText(), row, 3);
				if(rdMale.isSelected()) {
					model.setValueAt("Male", row, 4);
				}
				else if(rdFemale.isSelected()) {
					model.setValueAt("Female", row, 4);
				}
				else {
					model.setValueAt("Other", row, 4);
				}
				if(rdIt.isSelected()) {
					model.setValueAt("IT", row, 5);
				}
				else if(rdCmd.isSelected()) {
					model.setValueAt("CMD", row, 5);
				}
				else {
					model.setValueAt("CS", row, 5);
				}

			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(JOptionPane.showConfirmDialog(null, "Are you sure?","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					try {
						int row=tblStudent.getSelectedRow();
						model.removeRow(row);
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Cannot delete!");
					}
				}
			}
		});
		
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String rows[]=new String[6];
				rows[0]=txtID.getText();
				rows[1]=txtName.getText();
				rows[2]=txtGpa.getText();
				rows[3]=txtEmail.getText();
				
				if(rdMale.isSelected()) {
					rows[4]="Male";
				}
				else if(rdFemale.isSelected()) {
					rows[4]="Female";
				}
				else {
					rows[4]="Other";
				}
				if(rdIt.isSelected()) {
					rows[5]="IT";
				}
				else if(rdCmd.isSelected()) {
					rows[5]="CMD";
				}
				else {
					rows[5]="Cs";
				}
				
				
				model.addRow(rows);
				
				txtID.setText("");
				txtName.setText("");
				txtGpa.setText("");
				txtEmail.setText("");
				
			}
		});
		//คลาสที่สืบทอด interface เรียบร้อย
		tblStudent.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int row=tblStudent.getSelectedRow();
				txtID.setText(model.getValueAt(row, 0).toString());
				txtName.setText(model.getValueAt(row, 1).toString());
				txtGpa.setText(model.getValueAt(row, 2).toString());
				txtEmail.setText(model.getValueAt(row, 3).toString());
				String gender=model.getValueAt(row, 4).toString();
				String major=model.getValueAt(row, 5).toString();
				if(gender.equals("Male")) {
					rdMale.setSelected(true);
				}
				else if(gender.equals("Female")) {
					rdFemale.setSelected(true);
				}
				else {
					rdOther.setSelected(true);
				}
				if(major.equals("IT")) {
					rdIt.setSelected(true);
				}
				else if(major.equals("CMD")) {
					rdCmd.setSelected(true);
				}
				else {
					rdCs.setSelected(true);
				}
			}
		});
		
		addWindowListener(this);
		
		setLayout(null);
		setTitle("Student Form");
		setSize(1300,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentForm();
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		String colName[]= {"Student ID", "Student Name", "GPA", "Email" , "Gender" , "Major"};
		model.setColumnIdentifiers(colName);
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
