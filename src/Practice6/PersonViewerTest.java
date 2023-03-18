package Practice6;

public class PersonViewerTest {

	public static void main(String[] args) {
		
		PersonViewer test = new PersonViewer();
		
		Person student = new Student("Nick Cheung","nc1702@nyu.edu","A");
		Person lecturer = new Lecturer("Anasse Bari","ab1234@nyu.edu","Computer Science");
		Person employee = new Employee("Bob Dylan","bd1234@nyu.edu","Music");
		
		test.view(student);
		test.view(lecturer);
		test.view(employee);

	}

}
