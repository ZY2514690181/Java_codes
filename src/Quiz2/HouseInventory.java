package Quiz2;

// There are assumptions listed by the end of the program.

import java.util.ArrayList;
import java.util.Scanner;

public class HouseInventory implements InventoryMng {
	
	ArrayList<House> houseList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		// Assume the user always inputs the right type
		InventoryMng obj = new HouseInventory();
		int ans;
		
		while (true) {
			System.out.println();
			System.out.println("1. Add a house");
			System.out.println("2. Edit a house");
			System.out.println("3. Delete a house");
			System.out.println("4. Display all houses below a certain price"); // below means smaller than
			System.out.println("5. Display the house with min price");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			ans = input.nextInt();
			if (ans == 1) {
				System.out.print("Enter the house ID: ");
				int id = input.nextInt();
				System.out.print("Enter the house price: ");
				double price = input.nextDouble();
				System.out.print("Enter the house status: ");
				boolean status = input.nextBoolean();
				House h = new House(id, price, status);
				obj.add(h);
			} else if (ans == 2) {
				System.out.print("Enter the house ID: ");
				int id = input.nextInt();
				System.out.print("Enter the house price: ");
				double price = input.nextDouble();
				obj.Edit(id, price);
			} else if (ans == 3) {
				System.out.print("Enter the house ID: ");
				int id = input.nextInt();
				obj.Delete(id);
			} else if (ans == 4) {
				System.out.print("Enter a price ceiling: ");
				double p = input.nextDouble();
				obj.HousesBelowPrice(p);
			} else if (ans == 5) {
				obj.findMin();
			} else if (ans == 6) {
				break;
			} else {
				System.out.println("Invalid input");
			}
		} // end of while loop
		
		input.close();
	} // end of main
	
	public void add(House h) {
		houseList.add(h);
	}

	public void Edit(int id, double price) {
		boolean found = false;
		for (int i = 0; i < houseList.size(); i++) {
			if (houseList.get(i).getid() == id) {
				//House h = new House(id, price, houseList.get(i).getstatus());
				//houseList.set(i, h);
				houseList.get(i).setprice(price);
				Scanner input0 = new Scanner(System.in);
				System.out.println("What is the updated status of this house?");
				boolean ans0 = input0.nextBoolean();
				houseList.get(i).setstatus(ans0);
				found = true;
				break;
			}
		}
		if (! found) {
			System.out.println("You don't have this house.");
		}
	}
	
	public int Delete(int id) {
		boolean found = false;
		for (int i = 0; i < houseList.size(); i++) {
			if (houseList.get(i).getid() == id) {
				houseList.remove(i);
				found = true;
				break;
			}
		}
		if (! found) {
			System.out.println("You don't have this house.");
			return 0;
		} else {
			System.out.println("The house has been deleted.");
			return 1;
		}
	}
	
	public House[] HousesBelowPrice(double p) {
		int count = 0;
		House[] housesBelowDraft = new House[houseList.size()];
		for (int i = 0; i < houseList.size(); i++) {
			if (houseList.get(i).getprice() < p) {
				housesBelowDraft[count] = houseList.get(i);
				count += 1;
				houseList.get(i).printAll();
			}
		} // end of for loop
		House[] housesBelow = new House[count];
		if (count == 0) {
			System.out.println("No house below this price, empty array returned");
		} else {
			for (int i = 0; i < count; i++) {
				housesBelow[i] = housesBelowDraft[i];
			} // end of for loop
		} // end of else
		return housesBelow;
	}
	
	public int findMin() {
		if (houseList.size() == 0) {
			System.out.println("You have no houses.");
			return 0; // return 0 when no house is present. Assume a house ID cannot be 0.
		} else {
			double priceMin = houseList.get(0).getprice();
			int idMinPrice = houseList.get(0).getid();
			for (int i = 1; i < houseList.size(); i++) {
				if (houseList.get(i).getprice() < priceMin) {
					priceMin = houseList.get(i).getprice();
					idMinPrice = houseList.get(i).getid();
				} // if there are more than one houses with minimum price, only one is displayed.
			} // end of for loop
			System.out.println(idMinPrice);
			return idMinPrice;
		} // end of else
	}

}

// Assumptions made besides those mentioned in the instructions
// The user enters a positive value for each house price.
// The house price entered is limited to two decimal places.
// When displaying all houses below a price, below means smaller than.
// Assume the user enters a positive price ceiling.