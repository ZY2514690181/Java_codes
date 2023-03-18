package Quiz1;

public class Q1 {

	public static void main(String[] args) {
		
		Animal animal1 = new Animal("shark", 2);
		animal1.describe();
		animal1.eat("fish");
		animal1.eat("fish", "shrimp");
		
		Mammal animal2 = new Mammal("cow", 2);
		animal2.describe();
		animal2.eat("grass");
		
	}

}
