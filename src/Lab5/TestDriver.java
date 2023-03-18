package Lab5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestDriver {

	public static void main(String[] args) throws Exception{
		
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		
		for(int i = 0; i <= 5; i++)
			stack1.push(i);
		stack2.push("zero");
		stack2.push("one");
		stack2.push("two");
		stack2.push("three");
		stack2.push("four");
		stack2.push("five");
		
		System.out.println("Popped " + stack1.pop());
		System.out.println("Popped " + stack2.pop());
		
		stack1.display();
		stack2.display();
		
		stack1.display(1, 3);
		stack2.display(1, 3);
		
		stack1.search(3);
		stack2.search("three");

		Stack check1 = new Stack();
		Stack check2 = new Stack();
		for(int i = 0; i < 2; i++)
			check1.push(i);
		check2.push("zero");
		check2.push("one");
		
		System.out.println(stack1.compareTo(check1));
		System.out.println(stack2.compareTo(check2));
		
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("temp"));
		
		out.writeObject(stack1);
		out.writeObject(stack2);
		
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("temp"));
		
		Stack read = (Stack) in.readObject();
		
		read.display();
		
		System.out.println("Admin: " + read.admin);
		
		in.close();
	}

}
