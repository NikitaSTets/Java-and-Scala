import org.eclipse.swt.*;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.Label;
public class Human {
	private  Address address=null;
	private String firstName;
	private String secondName;
	//private AddressForm addressForm;
	
	public Human(String firstName,String secondName)
	{
		this.firstName=firstName;
		this.secondName=secondName;
	}
	public Human()
	{
		this.firstName=null;
		this.secondName=null;
	}
	public void Settle(Address adr)
	{
	  String[] result;
	  address=adr;  
	}
	public String GetName() {
		return firstName;
	}
	public String GetSecondName() {
		return secondName;
	}
	@Override public String toString() 
	{  
		if(address!=null)
		return "firstName:"+firstName+",Second Name:"+secondName +address.toString();
		else 
	    return "firstName:"+firstName+",Second Name:"+secondName;
	};

	public void MoveOut()
	{
		address=null;
	}

}
