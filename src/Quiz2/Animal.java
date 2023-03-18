package Quiz2;

public class Animal {
	
	protected int limb; // the protected modifier
	
	public Animal(int limb) {
		this.limb = limb;
	}
	
	public void move() {
		System.out.println("The animal is moving.");
	}
	
	public void countLimb () {
		System.out.println("The animal has "+limb+" limbs.");
	}
	
	public void eat() {
		System.out.println("The animal is eating food.");
	}

}
