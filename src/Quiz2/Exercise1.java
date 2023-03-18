package Quiz2;

public class Exercise1 {

	public static void main(String[] args) {
		
		Animal animal = new Animal(4);
		Rat kangaroo_rat = new Rat(4);
		// A wounded rat may have fewer than 4 feet.
		// In this case, wounded_rat = new Rat(3)
		animal.move();
		animal.countLimb();
		animal.eat();
		kangaroo_rat.move();
		kangaroo_rat.countLimb();
		kangaroo_rat.eat();

	}

}

// two classes with "is-a" relationship:
// Rat is animal.
// The concepts are demonstrated in class Animal and class Rat.
// See the comments in these classes.