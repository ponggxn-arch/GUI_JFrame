package GUIProject2;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator extends JFrame {
	JPanel p1,p2;
	JTextField txtRes;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bc,bback;
	Font font=new Font("Consolas" , Font.BOLD,40);
	
	public Calculator() {
		
		p1=new JPanel();
		p2=new JPanel();
		txtRes=new JTextField("0");
		b1=new JButton("1");
		b2=new JButton("2");
		b3=new JButton("3");
		b4=new JButton("4");
		b5=new JButton("5");
		b6=new JButton("6");
		b7=new JButton("7");
		b8=new JButton("8");
		b9=new JButton("9");
		b0=new JButton("0");
		bc=new JButton("C");
		bback=new JButton("Back");
		
		txtRes.setFont(font);
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);
		b5.setFont(font);
		b6.setFont(font);
		b7.setFont(font);
		b8.setFont(font);
		b9.setFont(font);
		b0.setFont(font);
		bc.setFont(font);
		bback.setFont(font);
		
		bc.setForeground(Color.red);
		bback.setForeground(Color.blue);
		
		p1.setBackground(Color.darkGray);
		p1.setLayout(new GridLayout(1,1,10,10));
		txtRes.setHorizontalAlignment(SwingConstants.RIGHT);
		txtRes.setEditable(false);
		p1.add(txtRes);
		add(p1,BorderLayout.NORTH);
		
		p2.setLayout(new GridLayout(4,3,20,10));
		p2.add(b1);p2.add(b2);p2.add(b3);
		p2.add(b4);p2.add(b5);p2.add(b6);
		p2.add(b7);p2.add(b8);p2.add(b9);
		p2.add(bback);p2.add(b0);p2.add(bc);
		
		add(p1,BorderLayout.NORTH);
		add(p2);
		
		
		
		setTitle("Calculator");
		setSize(500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	
		
	b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String res = txtRes.getText();
				
				if(res.equals("0")) {
					txtRes.setText("1");
				}
				else {
					txtRes.setText(res+"1");
				}
			}
		});
	
	b2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String res = txtRes.getText();
			
			if(res.equals("0")) {
				txtRes.setText("2");
			}
			else {
				txtRes.setText(res+"2");
			}
		}
	});
	
	b3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String res = txtRes.getText();
			
			if(res.equals("0")) {
				txtRes.setText("3");
			}
			else {
				txtRes.setText(res+"3");
			}
		}
	});
	
	b4.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String res = txtRes.getText();
			
			if(res.equals("0")) {
				txtRes.setText("4");
			}
			else {
				txtRes.setText(res+"4");
			}
		}
	});
	
	b5.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String res = txtRes.getText();
			
			if(res.equals("0")) {
				txtRes.setText("5");
			}
			else {
				txtRes.setText(res+"5");
			}
		}
	});
	
	b6.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String res = txtRes.getText();
			
			if(res.equals("0")) {
				txtRes.setText("6");
			}
			else {
				txtRes.setText(res+"6");
			}
		}
	});
	
	b7.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String res = txtRes.getText();
			
			if(res.equals("0")) {
				txtRes.setText("7");
			}
			else {
				txtRes.setText(res+"7");
			}
		}
	});
	
	b8.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String res = txtRes.getText();
			
			if(res.equals("0")) {
				txtRes.setText("8");
			}
			else {
				txtRes.setText(res+"8");
			}
		}
	});
		
	b9.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String res = txtRes.getText();
			
			if(res.equals("0")) {
				txtRes.setText("9");
			}
			else {
				txtRes.setText(res+"9");
			}
		}
	});
	
	b0.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String res = txtRes.getText();
			
			if(res.equals("0")) {
				txtRes.setText("0");
			}
			else {
				txtRes.setText(res+"0");
			}
		}
	});
	
	bback.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String res = txtRes.getText();
			
			  if (res.length() > 0) {
		         res = res.substring(0, res.length() - 1);
		         
		         if (res.isEmpty()) {
		             res = "0";
		         }
		         
		         txtRes.setText(res);
		     }
		 }
	});
	
	bc.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			txtRes.setText("0");
		 }
	});
	
}
	
	public static void main(String[] args) {
		new Calculator();
	}
}
