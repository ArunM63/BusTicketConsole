package BusTicket;
import java.util.Scanner;
public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		boolean stop = true;
		int id=0;
		while(stop)
		{
			
			BusTicket bt = new BusTicket();
			System.out.print(bt);
			System.out.println("\n\n1 : Book tickets ");
			System.out.println("2 : Cancel tickets ");
			System.out.println("3 : View tickets ");
			System.out.println("4 : View Waiting List ");
			System.out.println("0 : To Exit ");
			System.out.print("Enter Your Choice :");
			int choice = sc1.nextInt();
			switch(choice)
			{
				case 1:
					System.out.print("Enter Your Name :");
					String name = sc2.nextLine();
					System.out.print("Enter Your Age :");
					int age = sc1.nextInt();
					System.out.print("Enter Your Birth Prefference :");
					String birthP = sc2.nextLine();
					Passenger p =  new Passenger(++id,name,age,birthP);
					
					int ans = bt.booker(p);
					System.out.println("-------------------------------------------------------");
					if(ans ==1 )	System.out.println("Your ticket is Booked And your ID id : "+id);
					else if(ans==2) System.out.println("Your ticket is in waiting list");
					else System.out.println("No ticket Available");
					System.out.println("-------------------------------------------------------");	
					break;
					
				case 2:
					if(bt.cancel())
						break;
					else
					{	
						System.out.print("\nEnter your ID to be canceled : ");
						int idn = sc1.nextInt();
						if(idn==id)
							id--;
						boolean out = bt.cancel(idn);
						if(out) System.out.println("Your Ticket Canceled");
						else System.out.println("Your ID not found");
						break;
					}
					
				case 3:
					System.out.print("---------------------------------------------------------------");
					bt.view();
					System.out.println("---------------------------------------------------------------");
					break;
					
				case 4:
					System.out.print("---------------------------------------------------------------");
					bt.viewWait();
					System.out.println("---------------------------------------------------------------");
					break;
					
				case 0:
					stop = false;
					break;
			}
		}

	}

}
