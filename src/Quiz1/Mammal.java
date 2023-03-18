package Quiz1;

public class Mammal extends Animal {
	
	public Mammal(String name, int age){
		super(name, age);
	}
	
	public void describe() {
		System.out.println("You have a "+name+" of age "+age+". "+"It has hair or fur. It is a warm-blooded vertebrate animal.");
	}
	
}
