package FLAT;
import Peoples.Human;
import FLAT.Address;;

public class Flat {
private  Address  address=null;
Room[] rooms;
int countOfTenands=0;
	public Flat(Address address,int countOfrooms)
	{
		this.address=address;
		rooms=new Room[countOfrooms];
		for(int i=0;i<countOfrooms;i++)
		{
			rooms[i].countOfTenands=3;
		}
	}
	
	public boolean Settl(Human human)
	{
		if(rooms==null)
		{
			return false;
		}
		for(int i=0;i<rooms.length;i++)
		{
			if(rooms[i].AddTenads(human))
				return true;
		}
		return false;
	}
	public boolean MoveOut()
	{
		for(int i=0;i<rooms.length;i++)
		{
			if(rooms[i].RemoveLast())
				return true;
				
		}
		return false;
	}
}
