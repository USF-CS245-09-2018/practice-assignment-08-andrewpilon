// Andrew Pilon

public class LinkedList implements List {

	int size = 0;
	Node head;

	// initiate LinkedList
	public LinkedList() {
	}

	public LinkedList(Object obj) {
		head = new Node(obj);
		size++;
	}


	// define Node class
	public class Node {

		Node next;
		Object data;

		public Node(Object obj) {
			data = obj;
			next = null;
		}
		
		public Object data() {
			return data;
		}

		public void data(Object obj) {
			data = obj;
		}

		public Node next() {
			return next;
		}

		public void next(Node next_node) {
			next = next_node;
		}

		public void next(Object next_obj) {
			next = new Node(next_obj);
		}
	}

	// add data to end of list
	public void add(Object obj) throws Exception {
		Node add = new Node(obj);
		Node current = head;

		if(current == null) {
			head = add;
		} else if(current.next() == null) {
			head.next(add);
		} else {
			while(current.next() != null) { // gets to node right before last one
				current = current.next();
			}
			current.next(add); // adds object to 'next' of last node in list
		}
		size++;
	}

	// add data to specified index
	public void add(int pos, Object obj) throws Exception {

		if(pos > size || pos < 0) {
			throw new Exception ("index out of bounds");
		}
		Node add = new Node(obj);
		Node current;

		if(head == null) { // check for empty list
			head = add;
			size++;
			return;
		} else {
			current = head;
			for(int i = 0; i < pos && current.next() != null; i++) { // move along list until node at index pos-1
				current = current.next();
			}
		}
		current.next(add);
		size++;
	}

	public Object get(int pos) throws Exception {
		if(pos > size || pos < 0) { // check for invalid position entry
			throw new Exception ("index out of bounds");
		}
		Node current = head;
		if(current != null) {
			for(int i = 0; i < pos; i++) { // iterate to node at index pos
				current = current.next();
			}
			return current.data(); // return data contained in specified node
		}
		throw new Exception ("null node? don't think this'll happen though");
	}

	public Object remove(int pos) throws Exception {
		if(pos < 0 | pos > size) {
			throw new Exception ("index out of bounds");
		}
		Node current = head;
		if(current != null) {
			for(int i = 0; i < pos; i++) { // iterate to node at index pos
				current = current.next();
			}
			Object ret_data = current.data(); // save data from removed object to return
			current = current.next(); // overwrite removed node with its 'next' node
			size--;
			return ret_data;
		}
		return null;
	}

	public int size() {
		return size;
	}

}