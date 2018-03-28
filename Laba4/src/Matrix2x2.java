
public class Matrix2x2 implements Runnable{

	int a11=0,a12=0,a21=0,a22=0;
	double result=0;
	public Matrix2x2(int a11,int a12,int a21,int a22)
	{
		this.a11= a11;
		this.a22=a22;
		this.a21=a21;
		this.a12=a12;
	}
	public Matrix2x2(String a11,String a12,String a21,String a22)
	{
		
		try{
			this.a11= Integer.parseInt(a11);
			this.a22=Integer.parseInt(a22);
			this.a21=Integer.parseInt(a21);
			this.a12=Integer.parseInt(a12);
		    System.out.println(this.hashCode());
		}
		catch(Exception e)
		{
			
		}
	}
	@Override
	public void run() {	
		result=a11*a22-a21*a12;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public double GetResult()
	{
		return result;
	}
	
	

}
