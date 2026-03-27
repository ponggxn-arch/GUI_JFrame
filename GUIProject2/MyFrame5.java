package GUIProject2;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

public class MyFrame5 extends JFrame {
	JPanel b1,b2,b3,b4,b5,b6,b7,b8,b9;
	
	public MyFrame5() {
		setLayout(new BorderLayout());
		
		b1=new JPanel();
		b2=new JPanel();
		b3=new JPanel();
		b4=new JPanel();
		b5=new JPanel();
		b6=new JPanel();
		b7=new JPanel();
		b8=new JPanel();
		b9=new JPanel();
		
		
		
		b1.setBackground(Color.RED);

		b3.setBackground(Color.RED);
		b4.setBackground(Color.RED);
		b5.setBackground(Color.RED);
		b6.setBackground(Color.RED);
		b7.setBackground(Color.RED);

		b9.setBackground(Color.RED);
		
		setLayout(new GridLayout(3,3));
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);

		
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame5();
	}

}
