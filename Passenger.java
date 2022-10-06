package BusTicket;

public class Passenger 
{
	int id;
	String Name;
	String birthP;
	int age;
	String allotment;
	int seatNum;
	Passenger(int id,String Name, int age, String birthP)
	{
		this.id = id;
		this.Name = Name;
		this.birthP =birthP;
		this.age = age;
		allotment = "Not alloted";
		seatNum = -1;
	}
	public int getId()
	{
		return id;
	}
	public String toString()
	{
		return "\n"+id+"\t"+Name+"\t  "+birthP+"\t\t"
				+age+"\t"+allotment+"\t\t"+seatNum;
	}
}