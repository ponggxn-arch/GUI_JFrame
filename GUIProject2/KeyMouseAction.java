package GUIProject2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyMouseAction extends JFrame implements MouseListener{
   JLabel lbJ=new JLabel("J");
   JLabel lbA=new JLabel("A");
   JLabel lbV=new JLabel("V");
   JLabel lbA2=new JLabel("A");
   JButton btnBack=new JButton("Go Back");
   int x1,x2,x3,x4,y1,y2,y3,y4;
   Font f=new Font("Courier New",Font.BOLD,50);

   public KeyMouseAction() {
       x1=300;y1=100;
       x2=350;y2=100;
       x3=400;y3=100;
       x4=450;y4=100;
       
       lbJ.setFont(f);
       lbA.setFont(f);
       lbV.setFont(f);
       lbA2.setFont(f);
       
       lbJ.setBounds(x1,y1,50,50);
       lbA.setBounds(x2,y2,50,50);
       lbV.setBounds(x3,y3,50,50);
       lbA2.setBounds(x4,y4,50,50);
       
       lbJ.addMouseListener(new MouseAdapter() {
    	   public void mouseClicked(MouseEvent e) {
    			// TODO Auto-generated method stub
    			if(lbJ.getForeground()==Color.black) {
    				lbJ.setForeground(Color.red);
    				lbA.setForeground(Color.black);
    				lbV.setForeground(Color.black);
    				lbA2.setForeground(Color.black);
    			}
    		}
	});
       lbA.addMouseListener(new MouseAdapter() {
    	   public void mouseClicked(MouseEvent e) {
    			// TODO Auto-generated method stub
    			if(lbA.getForeground()==Color.black) {
    				lbJ.setForeground(Color.black);
    				lbA.setForeground(Color.red);
    				lbV.setForeground(Color.black);
    				lbA2.setForeground(Color.black);
    			}
    		}
	});
       
       lbV.addMouseListener(new MouseAdapter() {
    	   public void mouseClicked(MouseEvent e) {
    			// TODO Auto-generated method stub
    			if(lbV.getForeground()==Color.black) {
    				lbJ.setForeground(Color.black);
    				lbA.setForeground(Color.black);
    				lbV.setForeground(Color.red);
    				lbA2.setForeground(Color.black);
    			}
    		}
	});
       
       lbA2.addMouseListener(new MouseAdapter() {
    	   public void mouseClicked(MouseEvent e) {
    			// TODO Auto-generated method stub
    			if(lbA2.getForeground()==Color.black) {
    				lbJ.setForeground(Color.black);
    				lbA.setForeground(Color.black);
    				lbV.setForeground(Color.black);
    				lbA2.setForeground(Color.red);
    			}
    		}
	});

       btnBack.setFont(new Font("Consolas",Font.PLAIN,30));
       btnBack.setBounds(300,700,200,50);
       
       add(lbJ);
       add(lbA);
       add(lbV);
       add(lbA2);
       add(btnBack);
      
       lbJ.setForeground(Color.black);
       lbA.setForeground(Color.black);
       lbV.setForeground(Color.black);
       lbA2.setForeground(Color.black);
       
       setLayout(null);
       setSize(800,800);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
   }
   public static void main(String[] args) {
       new KeyMouseAction();
   }
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub

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
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
   

}