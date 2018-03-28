import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {
	private static final Insets insets = new Insets(0, 0, 0, 0);
	private static final int countOfCell=9;
	public static void main(String args[])
	{
		final JFrame frame = new JFrame("Laba 4");
		JLabel resultLabel=new JLabel();
	    JButton button =new JButton("Count");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(new GridBagLayout());

	    final JTextField[] textFieldArray=new JTextField[countOfCell];
	    for(int i=0;i<countOfCell;i++)
	    {
	    	textFieldArray[i] = new JTextField( new Integer(i).toString());
	    }
       
	    
	    // Row One 
	    addComponent(frame, textFieldArray[0], 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);   
	    addComponent(frame, textFieldArray[1], 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);	   
	    addComponent(frame, textFieldArray[2], 2, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	    // Row Two  	   
	    addComponent(frame,textFieldArray[3], 0, 1,1 , 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	    addComponent(frame, textFieldArray[4], 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);	    
	    addComponent(frame,textFieldArray[5], 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);	    
	    addComponent(frame, resultLabel, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	    addComponent(frame, button, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	    // Row Three
	    addComponent(frame, textFieldArray[6], 0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	    addComponent(frame,textFieldArray[7], 1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	    addComponent(frame, textFieldArray[8], 2, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	    
	 
	   

	    button.addActionListener(new ActionListener() {            
	      Matrix2x2 a1=null;
	      Matrix2x2 a2=null;
	      Matrix2x2 a3=null;
		  double a11=0,a12=0,a13=0;
		
	      @Override
			public void actionPerformed(ActionEvent e) {
	    	  boolean contin=true;;
	    	  for(int i=0;i<countOfCell;i++)
	    	  {
		    	  try
		    	  {
		    		  Integer.parseInt(textFieldArray[i].getText());
		    		  textFieldArray[i].setBackground(Color.green);
		    	  }
		    	  catch(Exception e1)
		    	  {
		    		  textFieldArray[i].setBackground(Color.red);	
		    		  contin=false;
		    	  }

	    	  }
	    	  if(contin){
	    	  a1=new Matrix2x2(Integer.parseInt(textFieldArray[4].getText()), Integer.parseInt(textFieldArray[5].getText()),Integer.parseInt(textFieldArray[7].getText()),Integer.parseInt(textFieldArray[8].getText()));    
			  a2=new Matrix2x2(Integer.parseInt(textFieldArray[3].getText()), Integer.parseInt(textFieldArray[5].getText()),Integer.parseInt(textFieldArray[6].getText()),Integer.parseInt(textFieldArray[8].getText()));
		      a3=new Matrix2x2(Integer.parseInt(textFieldArray[3].getText()), Integer.parseInt(textFieldArray[4].getText()),Integer.parseInt(textFieldArray[6].getText()),Integer.parseInt(textFieldArray[7].getText())) ;
	    	  
				Thread t1=new Thread(a1);
				Thread t2=new Thread(a2);
				Thread t3=new Thread(a3);
				t1.start();
				t2.start();
				t3.start();
				
			    try {
					t1.join();					
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			    try {
					t2.join();
					
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			    try {
					t3.join();
					
					a11=Double.parseDouble(textFieldArray[0].getText());
					a12=Double.parseDouble(textFieldArray[1].getText());
					a13=Double.parseDouble(textFieldArray[2].getText());
					resultLabel.setText("Result:"+new Double(-a11*a1.GetResult()+a12*a2.GetResult()-a13*a3.GetResult()).toString());
				} catch (InterruptedException e1) {
				
					e1.printStackTrace();
				}
			    
				
				
	    	  }	
			}
		});
	   
	    
	    frame.setSize(500, 200);
	    frame.setVisible(true);
	}
	 private static void addComponent(Container container, Component component, int gridx, int gridy,
		      int gridwidth, int gridheight, int anchor, int fill) {
		    GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
		        anchor, fill, insets, 0, 0);
		    container.add(component, gbc);
		  }
}
