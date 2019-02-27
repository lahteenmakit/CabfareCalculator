import java.util.Scanner;
import java.util.ArrayList;

class Passenger {
	private String name;
	private double distanceOnboard; //kilometers
	private double timeOnboard; //minutes
	private double share; 

	public String getName() {
		return this.name;
	}

	public double getDistanceOnboard() {
		return this.distanceOnboard;
	}

	public double getTimeOnboard() {
		return this.timeOnboard;
	}

	public double getShare() {
		return this.share;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDistanceOnBoard(double km) {
		this.distanceOnboard = km;
	}

	public void setTimeOnBoard(double time) {
		this.timeOnboard = time;
	}

	public void setShare(double share) {
		this.share = share;
	}

}

public class CabfareCalculator {

	public static void menu() {
		System.out.println("\n---Welcome to Fair Cabfare Calculator!---\n");
		Scanner scanner = new Scanner(System.in);
		char selection = 'x';
		int passengerCount = 0;
		double totalDistance = 0;
		ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
		do {
			System.out.println("What do you want to do?\nn: Enter new passenger (max 4)\nq: Calculate cabfares and quit");
			selection = scanner.next().charAt(0);
			switch(Character.toLowerCase(selection)) {
				case 'n':
					passengerCount++;
					System.out.println("Input the distance travelled in kilometers for passenger" + passengerCount + ":");
					double distance = scanner.nextDouble();
					totalDistance += distance;
					Passenger p = new Passenger();
					p.setName("Passenger" + passengerCount);
					p.setDistanceOnBoard(distance);
					passengerList.add(p);
					System.out.println("\nPassenger" + passengerCount + ":\nDistance: " + distance + " km");
					System.out.println("\nPress Enter to continue ...");
					try {
						System.in.read();
					}
					catch(Exception e) {

					}  
					if(passengerCount == 4) {
						selection = 'q';
					}
					break;
				case 'q':
					break;
				default:
					System.out.println("Invalid selection. Try again!");
			}			
		} while (selection != 'q');

		for(Passenger p: passengerList) {
			double share = p.getDistanceOnboard() / totalDistance;
			p.setShare(share);
		}		

		System.out.println("\nEnter total fare of the ride in euros");
		double totalDue = scanner.nextDouble();

		for(Passenger p: passengerList) {
			double due = totalDue * p.getShare();
			System.out.print(p.getName() + "'s share: ");
			System.out.printf("%.1f", due);
			System.out.println(" €");
		}
	}
	public static void main(String[] args) {
		menu();
	}
}