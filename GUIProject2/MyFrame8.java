package GUIProject2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MyFrame8 extends JFrame /* implements ActionListener */{
	JLabel lbName,lbPass;
	JTextField txtName;
	JPasswordField txtPass;
	JButton btLogin,btCancel;
	
	public MyFrame8() {
		lbName=new JLabel("Username :");
		lbPass=new JLabel("Password :");
		txtName=new JTextField();
		txtPass=new JPasswordField();
		btLogin=new JButton("Login");
		btCancel=new JButton("Cancel");
		setLayout(null);
		
		lbName.setBounds(50,100,100,30);
		lbPass.setBounds(50,150,100,30);
		txtName.setBounds(150,100,200,30);
		txtPass.setBounds(150,150,200,30);
		btLogin.setBounds(150,200,95,35);
		btCancel.setBounds(254,200,95,35);
					      //x,  y,  w, h
		add(lbName);
		add(lbPass);
		add(txtName);
		add(txtPass);
		add(btLogin);
		add(btCancel);
		
		txtName.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtPass.requestFocus();
				txtPass.selectAll();
			}
		});
		
		txtPass.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btLogin.requestFocus();
			}
		});
		
		btLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(btLogin, "Username : " +txtName.getText());
			}
		});
		
		btCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtName.setText("");
				txtPass.setText("");
			}
		});
		
		/*ActionHandler ac=new ActionHandler(this);
		btLogin.addActionListener(ac);
		btCancel.addActionListener(ac);
		txtName.addActionListener(ac);
		txtPass.addActionListener(ac);
		*/
		
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame8();

	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//String cmd=e.getActionCommand();
		Object src=e.getSource();
		String name=txtName.getText();
		
		if(src==btLogin) {
			JOptionPane.showMessageDialog(this, "Username = " + name );
		}
		else if(src==btCancel){
			JOptionPane.showMessageDialog(this, "You click cancel !" );
		}
		else if(src==txtName) {
			txtPass.requestFocus();
			txtPass.selectAll();
		}
		else if(src==txtPass) {
			btLogin.requestFocus();
		}*/
	}


