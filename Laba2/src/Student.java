import org.eclipse.swt.widgets.*;
public class Student extends Human{
  public void Study(Label label)
  {
	  label.setText(super.toString()+" start to study");
  }
  public Student(String name,String secondName)
  {	  
	super(name,secondName);
  }
}
