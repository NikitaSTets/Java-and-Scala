package FLAT;
import Peoples.Human;


public class Room {
 int countOfTenands=0;
 Human[] humans;
 int current=0;
 public Room(int count)
 {
	 countOfTenands=count;
	 humans=new Human[count];
 }
 public boolean AddTenads(Human human)
 {
	 
	 if(current+1<countOfTenands)
	  {
		 current++;
		 humans[current]=human;
		 return true;
	  }
	 return false;
	   
 }
 public boolean RemoveLast()
 {
	 if(current!=0)
	 {
	  humans[current]=null;
	  current--;
	  return true;
	 }
	 return false;
 }
}
