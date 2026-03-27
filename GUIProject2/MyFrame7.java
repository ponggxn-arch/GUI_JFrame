package GUIProject2;


import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
	
public class MyFrame7 extends JFrame implements ActionListener{
	JButton b1,b2,b3,b4,b5;
	CardLayout card;
	Container c;
	
	public MyFrame7() {
		card = new CardLayout(50,50);
		c=getContentPane();
		setLayout(card);
		
		b1=new JButton("Card 1");
		b2=new JButton("Card 2");
		b3=new JButton("Card 3");
		b4=new JButton("Card 4");
		b5=new JButton("Card 5");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);	
		b5.addActionListener(this);
		
		c.add("1",b1);
		c.add("2",b2);
		c.add("3",b3);
		c.add("4",b4);
		c.add("5",b5);
		
		
		setTitle("Card Demo");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame7();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		card.next(c);
		
	}

}
