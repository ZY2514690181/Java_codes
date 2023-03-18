package Practice7;

public class Problem2 {

	public static void main(String[] args) {
		
		Car MyCar = new Car("My car",2016,"UFO","gray");
		
		MyCar.printinfo();
		MyCar.sell(2017);
		MyCar.printinfo();
		MyCar.sell(2018,"blue");
		MyCar.printinfo();

	}

}
