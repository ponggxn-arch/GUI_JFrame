package GUIProject2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class MyFrame6 extends JFrame {
	JPanel b1,b2,b3,b4,b5,b6,b7,b8,b9;
	
	Font font=new Font("Consolas",Font.PLAIN,30);
	
	public MyFrame6() {
		setLayout(new BorderLayout());
		setTitle("My Frame 2");
		
		b1=new JPanel();
		b2=new JPanel();
		b3=new JPanel();
		b4=new JPanel();
		b5=new JPanel();
		b6=new JPanel();
		b7=new JPanel();
		b8=new JPanel();
		b9=new JPanel();
		
		setLayout(new GridLayout(3,3));
		
		b1.setBackground(Color.RED);
		b2.setBackground(Color.RED);
		b3.setBackground(Color.RED);
		b4.setBackground(Color.RED);
		b5.setBackground(Color.RED);
		b6.setBackground(Color.RED);
		b7.setBackground(Color.RED);
		b8.setBackground(Color.RED);
		b9.setBackground(Color.RED);
		
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);
		b5.setFont(font);
		
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame3();
	}

}
