package Practice6;

public class PersonViewer {
	
	PersonViewer(){
		
	}
	
	public void view(Person person) {
		
		System.out.println("Person...");
		System.out.println("Name:\t\t"+person.GetName());
		System.out.println("Email:\t\t"+person.GetEmail());
		System.out.println("Description:\t\t"+person.GetDescription());
		
		System.out.println("\n");
		
	}

}
