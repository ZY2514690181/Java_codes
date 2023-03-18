package ObjectOrientedProgram;

public class PhoneBookApp {

	public static void main(String[] args) {
		
		PhoneBookEntry FirstEntry = new PhoneBookEntry("Anasse","Bari",917);
		
		PhoneBookEntry SecondEntry = new PhoneBookEntry("John","Smith",202);
		
		String FN = SecondEntry.getfirstName();
		
		System.out.println("First Name of Second Entry is " + FN);
		
		SecondEntry.setFirstName("Jennifer");
		
		System.out.println("First Name of Second Entry is " + SecondEntry.getfirstName());
	
	//
	
	int[] myarray = new int[70];
	
	PhoneBookEntry[] myiphone = new PhoneBookEntry[10];
	
	myiphone[0].setFirstName("Emma");
	myiphone[0].setNumber(999);

	}
	
}
