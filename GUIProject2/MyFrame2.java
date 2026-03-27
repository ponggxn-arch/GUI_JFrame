package GUIProject2;

import java.awt.Button;
import java.awt.Frame;

public class MyFrame2 extends Frame{
	
	Button b1,b2;
	
	public MyFrame2() {
		b1 = new Button("Button1");
		b2 = new Button("Button2");
		
		add(b1);
		add(b2);
		
		setSize(500,300);
		setVisible(true);
		setTitle("My Frame 2");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame2();
	}

}
