package BusTicket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BusTicket 
{
	private static int seatcount = 2;
	private static int lower = seatcount/2;
	private static int upper = seatcount/2;
	private static int wait =10;
	private static String busName = "Rytham";
	private static int seat = 0;
	
	static ArrayList<Passenger> bkg = new ArrayList<>(); 
	static Queue<Passenger> wtl = new LinkedList<>();
	
	int booker(Passenger p)
	{
		if(seatcount > 0 && ((p.birthP.equals("L")||p.birthP.equals("l")) && lower >0))
		{
			p.allotment = "Alloted";
			p.seatNum = ++seat; 
			seatcount--;
			lower--;
			bkg.add(p);
			return 1;
		}
		if(seatcount > 0 && ((p.birthP.equals("U")||p.birthP.equals("u")) && upper >0))
		{
			p.allotment = "Alloted";
			p.seatNum = ++seat; 
			seatcount--;
			upper--;
			bkg.add(p);
			return 1;
		}
		if(seatcount<=0 && wait>0)
		{
			p.allotment ="Waiting List";
			p.seatNum = 0;
			wait--;
			wtl.add(p);
			return 2;
		}
		return 0;
	}
	boolean cancel()
	{
		if(bkg.size()<=0)
		{
			System.out.println("\nBus is Empty");
			return true;
		}
		else
			return false;
	}
	boolean cancel(int id)
	{
		Iterator<Passenger> itr1 = bkg.iterator(); 
		while(itr1.hasNext())
		{
			Passenger t = itr1.next();
			if(t.id == id)
			{
				itr1.remove();
				if(t.birthP.equals("L")||t.birthP.equals("l"))
				{
					seatcount++;
					lower++;
				}
				else
				{
					seatcount++;
					upper++;
				}
				if(wtl.size()>0)
				{
					bkg.add(wtl.peek());
					wtl.remove();
				}
				return true;
			}
		}
		
		return false;
	}
	void view()
	{
		if(bkg.size()<=0)
		{
			System.out.println("\nBus is Empty");
			return ;
		}
		System.out.print("\nID\tName\tBirth Type\tAge\tConfirmation\tSeat No");
		Iterator<Passenger> itr1 = bkg.iterator(); 
		while(itr1.hasNext())
			System.out.println(itr1.next());
	}
	void viewWait()
	{
		if(wtl.size()<=0)
		{
			System.out.println("\nWaiting List is empty");
			return ;
		}
		System.out.print("\nID\tName\tBirth Type\tAge\tConfirmation\tSeat No");
		Iterator<Passenger> itr1 = wtl.iterator(); 
		while(itr1.hasNext())
			System.out.println(itr1.next());
	}
	public String toString()
	{
		return "\n*Bus name : "+busName+"  *No of seats available : "+seatcount+
				"  *No of lower birth : " +lower+"  *No of Upper birth : "+upper;
	}
}