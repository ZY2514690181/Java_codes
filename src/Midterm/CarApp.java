package Midterm;

// All the assumptions are listed by the end of the program.

import java.util.Scanner;

public class CarApp {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		CarEntry[] cars = new CarEntry[10];
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new CarEntry("",0);
		}
		
		String ans = "";
		
		System.out.println("Welcome to the car dealership management system!");
		
		while (true) {
			/*for (int i = 0; i < 10; i++) {
				cars[i].printcar();
			}*/
			System.out.println();
			System.out.println("A. Add a car to the inventory");
			System.out.println("B. Search for a car"); // by car's brand name
			System.out.println("C. Delete a car"); // by car's brand name
			System.out.println("D. Display all cars below a certain price"); // below means smaller than
			System.out.println("E. Edit a car's name");
			System.out.println("F. Sort the cars by price and display them");
			System.out.println("G. Display the average price of cars");
			System.out.println("H. Quit");
			System.out.print("Enter your choice: ");
			ans = input.next();
			if (ans.equals("A")) {
				System.out.print("Enter the car name: ");
				input.nextLine();
				String n = input.nextLine();
				System.out.print("Enter the car price: ");
				double p = input.nextDouble();
				addCar(cars, n, p);
			} else if (ans.equals("B")) {
				System.out.print("Enter the car name: ");
				input.nextLine();
				String n = input.nextLine();
				searchCar(cars, n);
			} else if (ans.equals("C")) {
				System.out.print("Enter the car name: ");
				input.nextLine();
				String n = input.nextLine();
				deleteCar(cars, n);
			} else if (ans.equals("D")) {
				System.out.print("Enter a price ceiling: ");
				//input.nextLine();
				double priceceiling = input.nextDouble();
				printAllBelow(cars, priceceiling);				
			} else if (ans.equals("E")) {
				System.out.print("Enter the car's initial name: ");
				input.nextLine();
				String n = input.nextLine();
				System.out.print("Enter the car's new name: ");
				String n0 = input.nextLine();
				renameCar(cars, n, n0);
			} else if (ans.equals("F")) {
				sortCar(cars);
			} else if (ans.equals("G")) {
				System.out.println(avgCar(cars));
			} else if (ans.equals("H")) {
				break;
			} else {
				System.out.println("Invalid input");
			}

		} // end of while
		
		input.close();
		
	}
	
	// method for A
	public static void addCar(CarEntry[] cars, String n, double p) {
		boolean found = false; // empty space not found initially
		for (int i = 0; i < cars.length; i++) {
			if (cars[i].getname().equals("")) {
				cars[i].setname(n);
				cars[i].setprice(p);
				found = true;
				break;
			}
		}
		if (! found) {
			System.out.println("You have no more space for this car.");
		}
	}
	
	// method for B
	public static void searchCar(CarEntry[] cars, String n) {
		boolean found = false;
		for (int i = 0; i < cars.length; i++) {
			if (cars[i].getname().equals(n)) {
				System.out.println("This car has a price of "+cars[i].getprice());
				found = true;
				break;
			}
		}
		if (! found) {
			System.out.println("You don't have this car.");
		}
	}
	
	// method for C
	public static void deleteCar(CarEntry[] cars, String n) {
		boolean found = false; // car to delete not found initially
		int deleteAt = -1;
		for (int i = 0; i < cars.length; i++) {
			if (cars[i].getname().equals(n)) {
				cars[i].setname("");
				cars[i].setprice(0);
				found = true;
				deleteAt = i;
				break;
			}
		}
		if (! found) {
			System.out.println("You don't have this car.");
		} else { // else is executed if a car is found and deleted
			for (int i = (deleteAt+1); i < cars.length; i++) {
				if (cars[i].getname().equals("")) { // fill the blank
					cars[deleteAt].setname(cars[i-1].getname());
					cars[deleteAt].setprice(cars[i-1].getprice());
					cars[i-1].setname("");
					cars[i-1].setprice(0);
					break;
				}
			} // end of for loop
		} // end of else
	}
	
	// method for D
	public static String[] printAllBelow(CarEntry[] cars, double priceceiling) {
		int count = 0;
		String[] carsBelowDraft = new String[cars.length];
		for (int i = 0; i < cars.length; i++) {
			if (cars[i].getprice() > 0 && cars[i].getprice() < priceceiling) {
				carsBelowDraft[count] = cars[i].getname();
				count += 1;
				cars[i].printcar();
			}
		} // end of for loop
		String[] carsBelow = new String[count];
		if (count == 0) {
			System.out.println("No car below this price");
			return carsBelow;
		} else {
			for (int i = 0; i < count; i++) {
				carsBelow[i] = carsBelowDraft[i];
			}
			return carsBelow;
		} // end of else
		
	}
	
	// method for E
	public static void renameCar(CarEntry[] cars, String n, String n0) {
		boolean found = false;
		for (int i = 0; i < cars.length; i++) {
			if (cars[i].getname().equals(n)) {
				cars[i].setname(n0);
				found = true;
				break;
			}
		}
		if (! found) {
			System.out.println("You don't have this car.");
		}
	}

	// method for F
	public static void sortCar(CarEntry[] cars) {
		int count = 0;
		for (int i = 0; i < cars.length; i++) {
			if (! cars[i].getname().equals("")) {
				count += 1;
			}
		} // end of for loop
		// The count is the number of cars we have.
		if (count == 0) {
			System.out.println("You have no cars.");
		} else {
			CarEntry[] carsSortDraft = new CarEntry[count];
			for (int i = 0; i < count; i++) {
				if (! cars[i].getname().equals("")) {
					carsSortDraft[i] = new CarEntry(cars[i].getname(),cars[i].getprice());
				}
			} // end of for loop
			CarEntry[] carsSort = new CarEntry[count];
			int maxIndex;
			for (int i = 0; i < count; i++) {
				maxIndex = 0;
				for (int j = 0; j < count; j++) {
					if (carsSortDraft[j].getprice() > carsSortDraft[maxIndex].getprice()) {
						maxIndex = j;
					}
				}
				carsSort[i] = new CarEntry(carsSortDraft[maxIndex].getname(),carsSortDraft[maxIndex].getprice());
				//carsSort[i].setname(carsSortDraft[maxIndex].getname());
				//carsSort[i].setprice(carsSortDraft[maxIndex].getprice());
				carsSortDraft[maxIndex].setprice(0);
			}
			for (int i = 0; i < count; i++) {
				carsSort[i].printcar();
			}
		}
	}
	
	// method for G
	public static double avgCar(CarEntry[] cars) {
		double sum = 0;
		int count = 0;
		for (int i = 0; i < cars.length; i++) {
			if (cars[i].getprice() == 0) {
				break;
			} // end of if
			count += 1;
			sum += cars[i].getprice();
		} // end of for loop
		if (count == 0) {
			System.out.print("You have no cars so average price is set to ");
			return 0;
		} else {
			System.out.print("For your "+count+" cars, average price is ");
			return sum/count;
		}
	}

}

// Assumptions made besides those mentioned in the instructions
// The user enters a positive value for each car price.
// The car price entered is limited to two decimal places.
// Once a car is deleted, the last car information moves to the space of the deleted car.
/* When displaying all cars below a price, below means smaller than.
 * Assume the user enters a positive price ceiling.
 * Here a new carEntry is not created to avoid confusion when programming,
 * but the rules are followed as written in the instruction,
 * and the program works well.
*/
// When sorting cars, sort from the most expensive car to the cheapest.
// The average price can exceed two decimal places to reflect precision.
