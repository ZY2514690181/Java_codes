package Quiz2;

public class Rat extends Animal {
	
	public Rat(int limb) {
		super(limb); // "super" for constructors
	}
	
	public void move() {
		System.out.println("The rat is crawling.");
	}
	
	public void countLimb () {
		System.out.println("The rat has "+limb+" feet.");
	}

	public void eat() {
		System.out.println("The rat is eating cheese.");
	} // method overriding

}
