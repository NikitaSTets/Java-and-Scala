package Peoples;
import org.eclipse.swt.widgets.Label;


public class Worker extends Human{
	public void Work(Label label)
	  {
		  label.setText(super.toString()+" start to work");
	  }
	public Worker(String name,String secondName)
	{
		super(name,secondName);
	}
}
