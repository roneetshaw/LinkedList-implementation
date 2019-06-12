//Node of a linkedlist
class Node {

	int data;
	Node next;
	
	Node(int d) {
		data = d;
		next = null;
	}
}

public class LinkedList {
	// LinkedList head Node
	Node head = null;

	// print the LinkedList.
	public static void print(LinkedList list) {
		Node x = list.head;

		System.out.print("LinkedList: ");

		// Traverse through the LinkedList
		while (x != null) {
			// Print the data
			System.out.print(x.data + " ");

			// next node
			x = x.next;
		}
	}

	// add a new node
	public static LinkedList add(LinkedList list, int data) {
		Node n = new Node(data);
		n.next = null;

		// If the list is empty then make n the first Node
		if (list.head == null) {
			list.head = n;
		} else {
			// Traverse to the last node and then add n node at the end
			Node t = list.head;
			while (t.next != null) {
				t = t.next;
			}

			// Insert the t at last node
			t.next = n;
		}

		// Return the list by head
		return list;
	}

	public static void removeTail(LinkedList x) {

		// Traverse the list till the n-1 where n is the last
		Node t = x.head;
		while (t.next.next != null) {
			t = t.next;
		}

		// Point the Node before the last node to null to remove the last node
		t.next = null;
	}

	public static LinkedList removeKey(LinkedList l, int x) {

		Node t = l.head, prev = null; 
		  
        // If head node
        if (t != null && t.data == x) { 
            l.head = t.next; // Change the head 
            return l; 
        } 
  
        //If key is present at some place else
        while (t != null && t.data != x) { 
            prev = t; 
            t = t.next; 
        } 

        if (t != null) { 
            // Unlink t from linked list 
            prev.next = t.next; 
        } 

        return l; 
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list = add(list, 1);
		list = add(list, 2);
		list = add(list, 3);
		list = add(list, 2);
		list = add(list, 2);
		Node i=list.head;
		removeTail(list);
		int KEY = 2;
		for(;i!=null;i=i.next) {
			if(i.data == KEY)
				list = removeKey(list, KEY);
		}
		print(list);
	}
}
