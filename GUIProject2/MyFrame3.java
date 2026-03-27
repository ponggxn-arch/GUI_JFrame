package GUIProject2;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;

public class MyFrame3 extends JFrame {
	JButton b1,b2,b3,b4,b5;
	Font font=new Font("Consolas",Font.PLAIN,30);
	
	public MyFrame3() {
		setLayout(new BorderLayout());
		
		b1=new JButton("NORTH");
		b2=new JButton("EAST");
		b3=new JButton("SOUTH");
		b4=new JButton("WEST");
		b5=new JButton("CENTER");
		
		add(b1,BorderLayout.NORTH);
		add(b2,BorderLayout.EAST);
		add(b3,BorderLayout.SOUTH);
		add(b4,BorderLayout.WEST);
		add(b5,BorderLayout.CENTER);
		
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
