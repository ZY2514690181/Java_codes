// There are some assumptions by the end of the code.

package Final;

import java.util.Scanner;
import java.io.*;

import Midterm.CarEntry;

public class FinalApp {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Product[] products = new Product[6]; // cannot have length smaller than 6 by instruction
		for (int i = 0; i < products.length; i++) {
			products[i] = new Product(0,0,0);
			// Array is initially empty.
			// All the values are set to be 0.
			// Thus assume no id can take value of 0.
		}
		
		System.out.println("Welcome to the product management system!");
		int ans;
		
		while (true) {
			
			System.out.println();
			System.out.println("1. Add a product");
			System.out.println("2. Delete a product"); // by its id
			System.out.println("3. Display all products");
			System.out.println("4. Sell a product");
			System.out.println("5. Display the product(s) info, that has/have the minimum price");
			System.out.println("6. write to a text file all the products that are below a certain quantity");
			// below means smaller than
			System.out.println("7. MergeSort by quantity");
			System.out.println("8. Display 3 products that their prices sum to x");
			System.out.println("9. Quit"); // give user the choice to exit
			
			System.out.print("Enter your choice: ");
			ans = input.nextInt();
			
			// if, else if, and else
			if (ans == 1) {
				System.out.print("Enter the product ID: ");
				int id = input.nextInt();
				System.out.print("Enter the product price: ");
				float price = input.nextFloat();
				System.out.print("Enter the product quantity: ");
				int quantity = input.nextInt();
				addProduct(products, id, price, quantity);
			} else if (ans == 2) {
				System.out.print("Enter the product ID: ");
				int id = input.nextInt();
				deleteProduct(products, id);
			} else if (ans == 3) {
				System.out.print("Display starts.");
				printAll(products);
				System.out.print("Display ends.");
			} else if (ans == 4) {
				System.out.print("Enter the product ID: ");
				int id = input.nextInt();
				System.out.print("Enter the quantity sold: ");
				int num = input.nextInt();
				sellProduct(products, id, num);
			} else if (ans == 5) {
				findMin(products);
			} else if (ans == 6) {
				System.out.println("Enter the quantity: ");
				int QuantSup = input.nextInt();
				WriteFile(products, QuantSup);
			} else if (ans == 7) {
				Product[] productsSorted = new Product[products.length];
				for (int i = 0; i < productsSorted.length; i++) {
					productsSorted[i] = new Product(0,0,0);
				}
				mergeSort(products, productsSorted, 0, products.length - 1);
			} else if (ans == 8) {
				System.out.print("Enter your x: ");
				float x = input.nextFloat();
				checkX(products, x);
			} else if (ans == 9) {
				break;
			} else {
				System.out.println("Invalid input");
			}
		} // end of while true loop
		
		input.close();

	}
	
	// Method 1
	public static void addProduct(Product[] products, int id, float price, int quantity) {
		boolean found = false; // empty space not found initially
		for (int i = 0; i < products.length; i++) {
			if (products[i].getID() == id) {
				// That means the product already exists.
				products[i].setPrice(price);
				System.out.println("Price is updated."); // The price is set to the value which the method takes.
				products[i].setQuant(products[i].getQuant()+quantity);
				// Additional products added to the existing ones.
				found = true;
				break;
			} else if (products[i].getID() == 0) {
				// That means the product does not exist. Have to add.
				products[i].setID(id);
				products[i].setPrice(price);
				products[i].setQuant(quantity);
				found = true;
				break;
			}
		}
		if (! found) {
			System.out.println("You have no more space for this product.");
		}
	}
	
	// Method 2
	public static void deleteProduct(Product[] products, int id) {
		boolean found = false; // product to delete not found initially
		int deleteAt = -1;
		for (int i = 0; i < products.length; i++) {
			if (products[i].getID() == id) {
				products[i].setID(0);
				products[i].setPrice(0);
				products[i].setQuant(0);
				found = true;
				deleteAt = i;
				break;
			}
		}
		if (! found) {
			System.out.println("You don't have this product.");
		} else { // else is executed if a product is found and deleted
			// Need to move up every item after the deleted one
			if (deleteAt < products.length - 1) { // No worries if the last block is deleted
				for (int i = (deleteAt+1); i < products.length; i++) {
					products[i-1].setID(products[i].getID());
					products[i-1].setPrice(products[i].getPrice());
					products[i-1].setQuant(products[i].getQuant());
				} // end of for loop
				products[products.length - 1].setID(0);
				products[products.length - 1].setPrice(0);
				products[products.length - 1].setQuant(0);
			}
		} // end of else
	}
	
	// Method 3
	public static void printAll(Product[] products) {
		if (products[0].getID() == 0) {
			System.out.println("You have no product now.");
		}
		for (int i = 0; i < products.length; i++) {
			if (products[i].getID() != 0) {
				// no need to display the empty product
				products[i].printproduct();
			}
		} // end of for loop
	}
	
	// Method 4
	public static void sellProduct(Product[] products, int id, int num) {
		boolean found = false;
		for (int i = 0; i < products.length; i++) {
			if (products[i].getID() == id) {
				if (num > products[i].getQuant()) {
					System.out.println("You don't have that many. Deal fails.");
				} else if (num > products[i].getQuant()) {
					// Since quantity is assumed positive, this deal is also rejected.
					// The user should delete the item instead.
					System.out.println("Selling all is same as deleting. Deal to fails. Try deleting instead.");
				} else {
					products[i].setQuant(products[i].getQuant() - num);
				}
				found = true;
				break;
			}
		} // for loop
		if (! found) {
			System.out.println("You don't have this product.");
		}
	}
	
	// Method 5
	public static void findMin(Product[] products) {
		if (products[0].getID() == 0) {
			System.out.println("You have no products.");
		} else {
			float priceMin = products[0].getPrice();
			for (int i = 1; i < products.length; i++) {
				if (products[i].getPrice() < priceMin && products[i].getPrice() != 0) {
					priceMin = products[i].getPrice();
				}
			}
			System.out.print("Display starts.");
			for (int i = 0; i < products.length; i++) {
				if (products[i].getPrice() == priceMin) {
					products[i].printproduct();
				}
			}
			System.out.print("Display ends.");
		} // end of else
	}
	
	// Method 6
	public static void WriteFile(Product[] products, int QuantSup) {
		// Use absolute path like the example below to ensure it works.
		String fileName = "/Users/zhangyuan/eclipse-workspace/Program1/src/Final/p.txt";
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int i = 0; i < products.length; i++) {
				if (products[i].getQuant() < QuantSup && products[i].getQuant() != 0) {
					bufferedWriter.write("ID: "+products[i].getID()+", ");
					bufferedWriter.write("Price: "+products[i].getPrice()+", ");
					bufferedWriter.write("Quantity: "+products[i].getQuant());
					bufferedWriter.newLine();
				}
			}
			bufferedWriter.close();
		}
		catch(IOException e) {
			System.out.println("There is an error!");
			e.printStackTrace();
		}
	}
	
	// Method 7, ascending order
	public static void merge(Product[] products1, int left1, int right1, Product[] products2, int left2, int right2, Product[] products, int left) {
		int i1 = left1;
		int i2 = left2;
		int i = left;
		while (i1 <= right1 && i2 <= right2) {
			if (products1[i1].getQuant() <= products2[i2].getQuant()) {
				products[i].setID(products[i1].getID());
				products[i].setPrice(products[i1].getPrice());
				products[i].setQuant(products[i1].getQuant());
				i1++;
				i++;
			} else {
				products[i].setID(products[i2].getID());
				products[i].setPrice(products[i2].getPrice());
				products[i].setQuant(products[i2].getQuant());
				i2++;
				i++;
			}
		} // end of while loop
		if (i1 < right1) {
			while (i1 <= right1) {
				products[i].setID(products[i1].getID());
				products[i].setPrice(products[i1].getPrice());
				products[i].setQuant(products[i1].getQuant());
				i1++;
				i++;
			}
		}
		if (i2 < right2) {
			while (i2 <= right2) {
				products[i].setID(products[i2].getID());
				products[i].setPrice(products[i2].getPrice());
				products[i].setQuant(products[i2].getQuant());
				i2++;
				i++;
			}
		}
	}
	public static void mergeSort(Product[] productsA, Product[] productsB, int left, int right) {
		if (left == right) {
			productsB[left].setID(productsA[left].getID());
			productsB[left].setPrice(productsA[left].getPrice());
			productsB[left].setQuant(productsA[left].getQuant());
			return;
		}
		int mid = (left+right)/2;
		Product[] productsC = new Product[right+1];
		mergeSort(productsA, productsC, left, mid);
		mergeSort(productsA, productsC, mid+1, right);
		merge(productsC, left, mid, productsC, mid+1, right, productsB, left);
		System.out.println("Sorting starts.");
		for (int i = 0; i < productsB.length; i++) {
			productsB[i].printproduct();
		}
		System.out.println("Sorting ends.");
	}
	
	// Method 8
	// Assume that the three products need to have different IDs.
	public static void checkX(Product[] products, float x) {
		boolean found = false;
		boolean differentID = true; // 3 products need to have different IDs.
		boolean defined = true; // None of the 3 products can be empty (ID is 0).
		float sum;
		for (int i = 0; i < products.length; i++) {
			if (found) {
				break;
			}
			for (int j = 0; j < products.length; j++) {
				if (found) {
					break;
				}
				for (int k = 0; k < products.length; k++) {
					if (found) {
						break;
					}
					if (i==j || i==k || j==k) {
						differentID = false;
					}
					if (products[i].getID()==0||products[j].getID()==0||products[k].getID()==0) {
						defined = false;
					}
					sum = products[i].getPrice()+products[j].getPrice()+products[k].getPrice();
					if (sum == x && differentID && defined) {
						found = true;
						System.out.println("One possible combination: ");
						products[i].printproduct();
						products[j].printproduct();
						products[k].printproduct();
						break;
					}
					differentID = true;
					defined = true;
				} // for loop k
			} // for loop j
		} // for loop i
		if (! found) {
			System.out.println("Such products do not exist.");
		}
	}

}

// Assume the correct data type is entered.
// Assume all the prices and quantities entered by the user are positive.
// For writing in a file, it works well on my computer already.
// To make sure the writing file code works, change the location of the file to fit its location on grader's computer.
