package Practice6;

public class PersonViewerInstance extends PersonViewer {
	
	PersonViewerInstance(){
		
	}
	
	public void view(Person person) {
		
		Employee a;
		Student b;
		Lecturer c;
		
		if (person instanceof Employee) {
			a = (Employee) person;
			viewPerson(a);
		}
		
		else if (person instanceof Student) {
			b = (Student) person;
			viewPerson(b);
		}
		
		if (person instanceof Lecturer) {
			c = (Lecturer) person;
			viewPerson(c);
		}
		
	}
	
	public void viewPerson(Student x) {
		System.out.println("Person...");
		System.out.println("Name:\t\t"+x.GetName());
		System.out.println("Email:\t\t"+x.GetEmail());
		System.out.println("Grade:\t\t"+x.GetGrade());
	}
	
	public void viewPerson(Lecturer x) {
		System.out.println("Person...");
		System.out.println("Name:\t\t"+x.GetName());
		System.out.println("Email:\t\t"+x.GetEmail());
		System.out.println("Subject:\t\t"+x.GetSubject());
	}
	
	public void viewPerson(Employee x) {
		System.out.println("Person...");
		System.out.println("Name:\t\t"+x.GetName());
		System.out.println("Email:\t\t"+x.GetEmail());
		System.out.println("Department:\t\t"+x.GetDepartment());
	}

}
