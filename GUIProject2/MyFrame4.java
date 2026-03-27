package GUIProject2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame4 extends JFrame implements ActionListener {
	JButton b1,b2,b3,b4,b5;
	JPanel pn1;
	
	public MyFrame4() {
		pn1 = new JPanel();
		b1 = new JButton("One");
		b2 = new JButton("Two");
		b3 = new JButton("Three");
		b4 = new JButton("Four");
		b5 = new JButton("Five");
		
		add(b1);add(b2);
		add(b3);add(b4);
		add(b5);
		
		
		b1.addActionListener(this);

		
		pn1.add(b1);
		pn1.add(b2);
		pn1.add(b3);
		pn1.add(b4);
		pn1.add(b5);
		
		pn1.setBackground(Color.BLACK);
		add(pn1,BorderLayout.SOUTH);
		
		
		/*pn1 = new JPanel();
		pn2 = new JPanel();
		pn3 = new JPanel();
		
		pn1.setBackground(Color.GREEN);
		pn2.setBackground(Color.BLACK);
		pn3.setBackground(Color.GREEN);
		
		add(pn1);
		add(pn2);
		add(pn3);
		setLayout(new GridLayout());*/
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new MyFrame4();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
	}
}
