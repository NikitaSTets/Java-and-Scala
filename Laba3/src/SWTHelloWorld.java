
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import FLAT.Address;
import Peoples.Human;
import Peoples.Student;
import Peoples.Worker;

public class SWTHelloWorld {
	static int maxSize=0;
	static Human[] humans=new Human[maxSize];
 
	public static void AddHuman(Human human)
    {
    	//Human human=new Human(name,secondName);//input firstName,secondName
		Human[] humans1=new Human[humans.length+1];
		 
	 
	for(int i=0;i<humans.length;i++)
	{
		humans1[i]=humans[i];
	}
	humans1[humans.length]=human;
	humans=humans1;

    }
	public static int LookForHuman(String name,String secondName)
	{
		for(int i=0;i<humans.length;i++)
		{
			if(humans[i].GetName().equals(name) && humans[i].GetSecondName().equals(secondName))
			{
				return i;
			}
		}
		return 0;
	}

    
public static void main (String [] args) {
	Display display = new Display ();
	final Shell shell = new Shell(display);
	
	shell.setSize(400,400);
	shell.setLayout(new GridLayout());
	int count=0;

    
	Composite parent = new Composite(shell, SWT.None); 
 
	 GridLayout gridLayout= new GridLayout(3,false);
     gridLayout.horizontalSpacing=50;
     gridLayout.verticalSpacing=50;
     
     gridLayout.makeColumnsEqualWidth=true;
     Label labelName=new Label(shell,SWT.NONE);
     labelName.setText("Name:  ");       
     Text nameTxt=new Text(shell, SWT.None);
     
     Label labelSecondName=new Label(shell,SWT.None);
     labelSecondName.setText("Second Name:  ");       
     Text secondNameTxt=new Text(shell, SWT.None);
     
     gridLayout.numColumns=2;
     Label labelStreet=new Label(shell,SWT.None);
     labelStreet.setText("Street:");
     Text streetTxt=new Text(shell,SWT.None);
    
     Label labelHouse=new Label(shell,SWT.None);
     labelHouse.setText("House:  ");       
     Text houseTxt=new Text(shell, SWT.None);
    
     Label  labelFlat=new Label(shell,SWT.None);
     labelFlat.setText("Flat:  ");
     Text flatTxt=new Text(shell,  SWT.None);
     
   
     parent.setLayout(gridLayout);
     
     final List listForSettle=new List(parent,SWT.V_SCROLL|SWT.SINGLE|SWT.BORDER);
     listForSettle.setToolTipText("Humans");
     
     final List listForMoveOut=new List(parent,SWT.V_SCROLL|SWT.SINGLE|SWT.BORDER);
     listForMoveOut.setToolTipText("Humans");
     Label label=new Label(parent, SWT.WRAP);
     label.setText("FirstName:Nikita,SecondName:Stets                    ");
    
     listForSettle.addListener(SWT.Selection, new Listener() {
         public void handleEvent(Event e) {
        	 int i=0;
           int[] selection = listForSettle.getSelectionIndices();
           if(selection.length>0 &&humans!=null)
           {
        	   try{
        		  
        	   Address adr=new Address(streetTxt.getText(),Integer.parseInt(houseTxt.getText()),Integer.parseInt(flatTxt.getText()));
        	   if(!streetTxt.getText().isEmpty())
        	   {
        		   String h=listForSettle.getItem(selection[0]);
        		   String[]str=h.split(" ");
        		   humans[LookForHuman(str[0],str[1])].Settle(adr);
        		   listForSettle.remove(selection[0]);
        		   listForMoveOut.add(str[0]+" "+str[1]);
        	   }
        	   }
        	   catch(Exception except)
        	   {
        		   label.setText(except.toString());
        		   i=1;
        	   }
        	   if(i==0)
        	   label.setText(humans[selection[0]].toString());
        	 
           }
           // label.setText(""+humans[selection[0]].toString());
        	 
         }
       });
     
     listForMoveOut.addListener(SWT.Selection, new Listener() {
         public void handleEvent(Event e) {
        	 int i=0;
           int[] selection = listForMoveOut.getSelectionIndices();
           if(selection.length>0 &&humans!=null)
           {
        	   String h=listForMoveOut.getItem(selection[0]);
    		   String[]str=h.split(" ");
        	   try{
        		  
	        	 
	    		   if(!str[0].isEmpty()&&!str[1].isEmpty())
	    		   {
	    			   Human human=humans[LookForHuman(str[0],str[1])];
	    		       human.MoveOut();//no selection[0]
	    		   
	    		   if(human instanceof Student) 
	    			{
	    			 
	    			  ((Student) human).Study(label);
	    		       listForMoveOut.remove(selection[0]);
	        		   listForSettle.add(str[0]+" "+str[1]);
	    		   
    		        }
	    		   if(human instanceof Worker) 
	    			{
	    			 
	    			  ((Worker) human).Work(label);
	    		       listForMoveOut.remove(selection[0]);
	        		   listForSettle.add(str[0]+" "+str[1]);
	    		   
   		        }
	    		   }
        	   }
        	   catch(Exception except)
        	   {
        		   label.setText(except.toString());
        		   i=1;
        	   }
        	   if(i==0)
        	   {
        		  // label.setText(""+humans.length);
        	   }
        	 
           }
          
        	 
         }
       }
     );
     
   
     
     Button createStudentButton = new Button(parent, SWT.NONE);
     createStudentButton.setText("Create student");
     
     createStudentButton.addSelectionListener(new SelectionAdapter()
     {		
    	 @Override public void widgetSelected(final SelectionEvent e)
    	 {

    		if(nameTxt.getText().isEmpty() ||secondNameTxt.getText().isEmpty())
			{
					
			}
    	    else
    	    {
    	    	Student student=new Student(nameTxt.getText(),secondNameTxt.getText());
    	    	listForSettle.add(nameTxt.getText()+" "+secondNameTxt.getText());
    	    	 AddHuman(student);
    	    }     
    	 }
    	
     });
     
     Button createWorkerButton = new Button(parent, SWT.NONE);
     createWorkerButton.setText("Create worker");
     
     createWorkerButton.addSelectionListener(new SelectionAdapter()
     {		
    	 @Override public void widgetSelected(final SelectionEvent e)
    	 {

    		if(nameTxt.getText().isEmpty() ||secondNameTxt.getText().isEmpty())
			{
					
			}
    	    else
    	    {
    	    	Worker worker=new Worker(nameTxt.getText(),secondNameTxt.getText());
    	    	listForSettle.add(nameTxt.getText()+" "+secondNameTxt.getText());
    	    	 AddHuman(worker);
    	    }     
    	 }
    	
     });
     
     
     
     shell.pack();
     //
     shell.open();
    while (!shell.isDisposed()) {
         if (!display.readAndDispatch())
             display.sleep();
     }
     
	display.dispose ();
}
}