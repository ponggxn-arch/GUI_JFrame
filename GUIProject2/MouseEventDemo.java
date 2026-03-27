package GUIProject2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MouseEventDemo extends JFrame implements MouseListener{
	JLabel label=new JLabel("0");
	JButton btnOK=new JButton("OK");
	int cnt=0;
	
	public MouseEventDemo() {
		label.setForeground(Color.black);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Consolas",Font.BOLD,80));
		
		label.addMouseListener(this); //ส่งเหตุการณ์
		btnOK.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				label.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				label.setForeground(Color.red);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		}); 

		
		label.setBounds(175,210,150,80);
		btnOK.setBounds(200,400,100,50);
		setLayout(null);
		add(label);
		add(btnOK);
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseEventDemo();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(label.getForeground()==Color.black) {
			
			cnt++;
		    label.setText(Integer.toString(cnt));
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}			


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		Object obj=e.getSource();
		if(obj.equals(btnOK)) {
			label.setForeground(Color.red);
		}
			
		label.setForeground(Color.black);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

		cnt=0;
	    label.setText(Integer.toString(cnt));
	    
		Object obj=e.getSource();
	    if(obj.equals(btnOK)) {
			label.setForeground(Color.black);
		}
	}

}
