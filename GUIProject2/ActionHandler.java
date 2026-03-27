package GUIProject2.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ActionHandler implements ActionListener{

	MyFrame8 frame;
	public ActionHandler(MyFrame8 frame) {
		this.frame=frame;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src=e.getSource();
		String name=frame.txtName.getText();
		
		if(src==frame.btLogin) {
			JOptionPane.showMessageDialog(frame, "Username = " + name );
		}
		else if(src==frame.btCancel){
			JOptionPane.showMessageDialog(frame, "You click cancel !" );
		}
		else if(src==frame.txtName) {
			frame.txtPass.requestFocus();
			frame.txtPass.selectAll();
		}
		else if(src==frame.txtPass) {
			frame.btLogin.requestFocus();
		}
	}
}
