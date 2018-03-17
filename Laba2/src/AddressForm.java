import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
public class AddressForm
{

    // ==================== 2. Instance Fields ============================
   // Address address;
    private Shell shell;
    Label labelStreet;
    Text streetTxt;
    
    Label labelHouse;      
    Text houseTxt;
    
    Label labelFlat; 
    Text flatTxt;
    
    Button save;


    // ==================== 4. Constructors ===============================

    public AddressForm()
    {
         shell = new Shell(Display.getCurrent());
         shell.setLayout(new GridLayout());
        
    	  Composite parent = new Composite(shell, SWT.None); 
     
    	  GridLayout gridLayout= new GridLayout();
          gridLayout.horizontalSpacing=50;
          gridLayout.verticalSpacing=50;
         
          gridLayout.numColumns=2;
         
    	 // fillLayout.type= SWT.VERTICAL; 
           parent.setLayout(gridLayout);
           labelStreet=new Label(shell,SWT.None);
           labelStreet.setText("Street:");
           streetTxt=new Text(shell,SWT.None);
          
           labelHouse=new Label(shell,SWT.None);
           labelHouse.setText("House:  ");       
           houseTxt=new Text(shell, SWT.None);
          
           labelFlat=new Label(shell,SWT.None);
           labelFlat.setText("Flat:  ");
           flatTxt=new Text(shell,  SWT.None);
          
           save=new Button(shell,SWT.None);
           save.setText("Save");
    }


    // ==================== 6. Action Methods =============================

    public Address open()
    {
    	Address address=null;
        shell.open();
        String[] result=new String[3];
        result[0]=streetTxt.getText();
        result[1]=houseTxt.getText();
        result[2]=flatTxt.getText();
        try{
        	address=new Address(streetTxt.getText(),Integer.parseInt(houseTxt.getText()), Integer.parseInt(flatTxt.getText()));
        }
        catch(Exception e)
        {}
        return address;
    }

    public Address close()
    {
    	Address address=null;
               // Don't call shell.close(), because then
               // you'll have to re-create it
    	try{
        address=new Address(streetTxt.getText(),Integer.parseInt(houseTxt.getText()), Integer.parseInt(flatTxt.getText()));
    	}
    	catch(Exception err)
    	{}
        shell.setVisible(false);
        return address;
    }
}