package LinkedList_A1;

/**
 * COMP 410
 *See online comment descriptions for methods not described in interface.
 *
*/

public class LinkedListImpl implements LIST_Interface {
  Node sentinel;
  Node temporary;
  Node current;
	 private int listSize; 		
  public LinkedListImpl(){
	  //this constructor is needed for testing purposes. Please don't modify!
    sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
  }
  
  //implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
    return sentinel;
  }

@Override
public boolean insert(double elt, int index) {
	if (index<0 || index >listSize) {
		return false;
	}
	  current = sentinel;
	Node newInsert = new Node(elt);
	//inserting first node and previos and next will just equal the other one. Increase size by one
	if(listSize==0) {
		newInsert.next = sentinel;
		newInsert.prev = sentinel;
		sentinel.next =newInsert;
		sentinel.prev = newInsert;
		listSize++;
		return true;
	}
		//adding at the end because it equals the listsize
	if (index== listSize ) {
		newInsert.prev = sentinel.getPrev();
		newInsert.next = sentinel;
		sentinel.getPrev().next = newInsert;
		sentinel.prev = newInsert;
		listSize++;
		return true;
	}
		
	else if (listSize> 0 && listSize!= index) {
		for(int i =0; i <=index; i++) {
			//new node value is saved as current. Temporary will become the one inserted
			current = current.next;;
		}
		//the new node is now inserted in between the currents previous and current is moved to next
		newInsert.prev = current.getPrev();
		newInsert.next = current;
		current.getPrev().next = newInsert;
		current.prev = newInsert;
		

		listSize++;
		return true;
	}
	else {
	return false;
	}
}

@Override
public boolean remove(int index) {
	if (listSize <0 || index >listSize) {
		return false;
	}
	else {
		Node temporaryNode = sentinel;
		if (listSize >0) {
			//iterate to node
		for  (int i = 0; i <=index; i++) {
			temporaryNode = temporaryNode.next;
			
			}
		}
		//initialize the previous and next nodes
		Node previousNode = temporaryNode.getPrev();
		Node nextNode = temporaryNode.getNext();
		//move the previous node down
		previousNode.next = nextNode;
		//move the next node back
		nextNode.prev = previousNode;
		
		//reduce listSize by one
		listSize--;
	
		return true;
	}
}

@Override
public double get(int index) {
	// if zero cant get anything from it
	if (index<0 || index >listSize||listSize ==0) {
		return Double.NaN;
	}
	Node current = sentinel;

	//iterates through list with next method and then gets data from it
	if (listSize >0 && listSize!= index) {
		for  (int i = 0; i <= index; i++) {
			current = current.next;
			}
		return current.getData();
	}
	else if (listSize == index) {
		current = sentinel.prev;
		return current.getData();
	}
		return Double.NaN;
}

@Override
public int size() {
	return listSize;
}

@Override
public boolean isEmpty() {
	if (listSize ==0) {
	return true;
	}
	else {
		return false;
	}
}

@Override
public void clear() {
	//previous and next are null so empty and reduce size to zero
	sentinel.prev = null;
	sentinel.next = null;
		listSize= 0;
	
	}
}