package Quiz1;

public class Animal {
	
	protected String name;
	protected int age;
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void describe() {
		System.out.println("You have a "+name+" of age "+age+".");
	}
	
	public void eat(String food) {
		System.out.println("The "+name+" is eating "+food+".");
	}
	
	public void eat(String food1,String food2) {
		System.out.println("The "+name+" is eating "+food1+" and "+food2+".");
	}

}
