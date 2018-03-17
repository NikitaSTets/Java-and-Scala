/*import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;*/

public class Address  {
private String street;
private int house;
private int flat;

public Address(String street,int house,int flat)
{
	this.street=street;
	this.house=house;
	this.flat=flat;
}

@Override
	public String toString() {
		// TODO Auto-generated method stub
		return street;
	}

}
