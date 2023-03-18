package Quiz2;

//Consider the following code of Singly LinkedList

import java.util.Scanner;

class Link
   {
   public int iData;              
   public double dData; // data item
   public Link next;              
   public Link(int id, double dd) 
      {
      iData = id;
      dData = dd;
      }
   public void displayLink()      
      {
      System.out.print("{" + iData + ", " + dData + "} ");
      }
   }  // end class Link
////////////////////////////////////////////////////////////////

class LinkList // initially called LinkListQuiz2, inconsistent with constructor name thus modified
   {
   private Link first;            // ref to first link on list

// -------------------------------------------------------------
   public LinkList()              // constructor
      {
      first = null;               // no links on list yet
      }
// -------------------------------------------------------------
   public void insertFirst(int id, double dd)
      {                           
      Link newLink = new Link(id, dd); // create a new Link
      newLink.next = first; // connect new Link to the "first" (will become second)
      first = newLink; // now the first is the new one
      }

// -------------------------------------------------------------
   public int displayidValueintheLastNode() //Retruns the iData of the last node.
      {      
	  if (first == null) {
		  System.out.println("Empty linklist, 0 returned");
	      return 0;
	  }
	  Link current = first; // start searching for the last node from first
      while (current.next != null) {
    	  current = current.next;
      }
      // Exit while loop when current is the last node
      // Now we can get iData
      System.out.println("iData of the last node: "+current.iData);
      return current.iData;
      }

// -------------------------------------------------------------
   public int displayidValueinthemiddleNode() //Retruns the iData of the node located in the middle of the linkedlist
      {                           
	  if (first == null) {
		  System.out.println("Empty linklist, 0 returned");
		  return 0;
	  }
	  // We need to get the size of LinkList first
	  int size = 1;
	  Link current = first;
	  while (current.next != null) {
		  current = current.next;
		  size++;
	  }
	  // Now we know the size. Do the search again.
	  int count = 0; // Treat count as the index. Index starts from 0: first is 0.
	  current = first;
	  while (count < (size-1)/2) {
		  current = current.next;
		  count++;
	  }
	  // Exit while loop when count reaches the middle index
	  System.out.println("iData of the middle node: "+current.iData);
	  return current.iData;
      }

// -------------------------------------------------------------
	  
public int count() //returns the number of nodes in a linkedlist     
      {
	  // Most of the codes are done in the method above.
	  if (first == null) {
		  System.out.println("Number of nodes: 0");
		  return 0;
	  }
	  int size = 1;
	  Link current = first;
	  while (current.next != null) {
		  current = current.next;
		  size++;
	  }
	  System.out.println("Number of nodes: "+size);
	  return size;
      }

// -------------------------------------------------------------
   public Link search(int key) //Searches by key (iData) & Retruns the Link, in case the node does not exist you return an empty link.    
      {
      // It is possible to have duplicates. Return the first one found only.
	  Link current = first;
	  while (current != null) {
		  if (current.iData == key) {
			  System.out.print("One node is found: ");
			  current.displayLink();
			  return current;
		  }
		  // if this one does not match, go to the next one
		  current = current.next;
	  }
	  // Exiting while loop means nodes does not exist
	  System.out.println("The node does not exist");
	  return null;
      }
// -------------------------------------------------------------
   public Link delete(int key)    // delete link with given key
      {                           // (assumes non-empty list)
	  Link current = first;
	  Link previous = first; // We need previous to connect the nodes before and after the deleted one
	  while (current != null) {
		  if (current.iData == key) {
			  if (current == first) {
				  first = first.next;
			  } else {
				  previous.next = current.next;
			  }
			  System.out.print("The following node is deleted: ");
			  current.displayLink();
			  return current;
		  }
		  // if this one does not match, go to the next one
		  previous = current;
		  current = current.next;
	  }
	  // Exiting while loop means nodes does not exist
	  System.out.println("The node does not exist");
	  return null;
      }
// -------------------------------------------------------------
   public int displayList()      // display the list to the SCREEN and return the count of nodes.
      {
		  // Most of the codes are done in the count method.
		  if (first == null) {
			  System.out.println("Empty linklist.");
			  System.out.println("Count of nodes: 0");
			  return 0;
		  }
		  int count = 0;
		  Link current = first;
		  System.out.println("Display linklist.");
		  while (current != null) {
			  current.displayLink();
			  current = current.next;
			  count++;
		  }
		  System.out.println("Count of nodes: "+count);
		  return count;
      }
// -------------------------------------------------------------
public int Duplicates()      // returns 1 or 0, if duplicates exist
      {
	  if (first == null) {
		  System.out.println("Empty linklist, return 0.");
		  return 0; // no duplicate in empty linklist
	  }
	  Link current1 = first;
	  Link current2 = first.next;
	  while (current1.next != null) {
		  while(current2 != null) {
			  if (current1.iData == current2.iData) {
				  System.out.println("Duplicate found, return 1.");
				  return 1;
			  }
			  current2 = current2.next;
		  }
		  current1 = current1.next;
		  current2 = current1.next;
	  } // end of outer while loop
	  System.out.println("No duplicate found, return 0.");
	  return 0;
      }
// -------------------------------------------------------------
   public void deleteDuplicateNodes()      // displays the list with no duplicate. 
      {
	  // if duplicate is found, only the node that appears the first is kept
		  if (first == null) {
			  System.out.println("Empty linklist");
			  return; // no duplicate in empty linklist
		  }
		  Link current1 = first;
		  Link current2 = first.next;
		  Link previous = first; // the previous node of current2
		  while (current1.next != null) {
			  while(current2 != null) {
				  if (current1.iData == current2.iData) {
					  // Duplicate found
					  previous.next = current2.next;
					  // duplicate deleted
				  }
				  previous = previous.next;
				  current2 = current2.next;
			  }
			  current1 = current1.next;
			  current2 = current1.next;
			  previous = current1;
		  } // end of outer while loop
		  System.out.println("All the duplicates are deleted. Display the list.");
		  if (first == null) {
			  System.out.println("Empty linklist.");
		  }
		  Link current = first;
		  while (current != null) {
			  current.displayLink();
			  current = current.next;
		  }
      }
// -------------------------------------------------------------


   }  // end class LinkList
////////////////////////////////////////////////////////////////
class LinkedlistQ2
   {
   public static void main(String[] args)
      {
      LinkList theList = new LinkList();  // make list

      //You have to call all the method and test them here.
   
      //Create a menu that will allow the user to choose from to call the method you implmented above
      
      Scanner input = new Scanner(System.in);
      System.out.println("Program starts running.");
      int ans;
      
      while (true) {
    	  System.out.println();
    	  System.out.println("Menu");
    	  System.out.println("1. Insert first node");
    	  System.out.println("2. Display id value in the last node");
    	  System.out.println("3. Display id value in the middle node");
    	  System.out.println("4. Count the number of nodes");
    	  System.out.println("5. Search by key");
    	  System.out.println("6. Delete link with given key");
    	  System.out.println("7. Display the list");
    	  System.out.println("8. Check the duplicate");
    	  System.out.println("9. Delete the duplicate nodes and display the list");
    	  System.out.println("10. Exit");
    	  
    	  System.out.println("Enter your choice:"); // Assume a number is entered
    	  ans = input.nextInt();
    	  if (ans == 1) {
    		  System.out.println("Enter an integer:"); // Assume a number is entered
        	  int ans1 = input.nextInt();
    		  System.out.println("Enter a double:"); // Assume a number is entered
        	  double ans2 = input.nextDouble();
    		  theList.insertFirst(ans1, ans2);
    	  } else if (ans == 2) {
    		  theList.displayidValueintheLastNode();
    	  } else if (ans == 3) {
    		  theList.displayidValueinthemiddleNode();
    	  } else if (ans == 4) {
    		  theList.count();
    	  } else if (ans == 5) {
    		  System.out.println("Enter the key:"); // Assume a number is entered
        	  int ans3 = input.nextInt();
    		  theList.search(ans3);
    	  } else if (ans == 6) {
    		  System.out.println("Enter the key:"); // Assume a number is entered
        	  int ans4 = input.nextInt();
    		  theList.delete(ans4);
    	  } else if (ans == 7) {
    		  theList.displayList();
    	  } else if (ans == 8) {
    		  theList.Duplicates();
    	  } else if (ans == 9) {
    		  theList.deleteDuplicateNodes();
    	  } else if (ans == 10) {
    		  break;
    	  } else {
    		  System.out.println("Invalid input");
    	  }
      } // end of while
      input.close();
      System.out.println("Program ends");
      
      } // end of main
     
   } 
////////////////////////////////////////////////////////////////
