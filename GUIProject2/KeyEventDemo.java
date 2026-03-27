package GUIProject2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyEventDemo extends JFrame implements KeyListener , ActionListener{
	JLabel label=new JLabel("A");
	JButton btn=new JButton("Go Back");
	
	int x=220,y=200;
	public KeyEventDemo() {
		label.setFont(new Font("Consolas",Font.BOLD,80));
		label.setBounds(x,y,160,80);
		label.setFocusable(true);
		label.requestFocus();
		label.addKeyListener(this);
		
		btn.setFont(new Font("Consolas",Font.BOLD,25));
		btn.setBounds(170,300,150,50);
		btn.addActionListener(this);
		
		add(btn);
		add(label);
		setLayout(null);
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KeyEventDemo();
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code=e.getKeyCode();
		switch(code) {
			case 37:x-=5;break;
			case 38:y-=5;break;
			case 39:x+=5;break;
			case 40:y+=5;break;
		}
		label.setBounds(x,y,150,80);
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		x=220;
		y=200;
		label.setBounds(x,y,150,80);
		label.requestFocus();
	}

}
