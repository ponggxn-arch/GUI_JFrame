package GUIProject2;

import java.awt.Button;
import java.awt.Frame;

public class MyFrame1 {

	public static void main(String[] args) {
		Frame fr = new Frame();
		Button b1 = new Button("Button1");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		fr.add(b1);
		fr.setTitle("My Frame 1");
		fr.setSize(500,300);
		fr.setVisible(true);
	}

}
