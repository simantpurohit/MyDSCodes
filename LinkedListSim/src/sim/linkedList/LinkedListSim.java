package sim.linkedList;

public class LinkedListSim {
	
	Node head = null;
	public LinkedListSim() {
		head = new Node();
	}
	
	public void addLast(int data){
		Node temp = new Node(data);
		Node current = head;
		while(current.getNext()!=null){
			current = current.getNext();
		}
		current.setNext(temp);
	}
	
	public void addFirst(int data){
		if(head.getNext() == null){
			head.setData(data);
		}
		
		else{
			Node temp = head;
			Node newNode = new Node(data);
			head=newNode;
			head.setNext(temp);
		}
	}
	
	public void addAt(int index, int data){
		
		Node current = head;
		Node previous = null;
		int count=0;
		
		if(index == 0){
			addFirst(data);
			return;
		}
		
		if(index == getSize()-1){
			addLast(data);
			return;
		}
		
		if((index>getSize()-1) || index < 0){
			System.out.println("Node does not exist");
			return;
		}
		
		while(count<index-1){
			current = current.getNext();
			count++;
		}
		previous = current;
		current = current.getNext();
		
		System.out.println("Previous: "+previous.getData());
		System.out.println("Current: "+current.getData());
		
		Node newNode = new Node(data);
		previous.setNext(newNode);
		newNode.setNext(current);
		
	}
	
	public void setDataAt(int index, int data){
		Node current = head;
		int count=0;
		
		if(index == 0){
			head.setData(data);
			return;
		}
		
		if((index>getSize()-1) || index < 0){
			System.out.println("Node does not exist");
			return;
		}
		
		while(count<index-1){
			current = current.getNext();
			count++;
		}
		current = current.getNext();
		
		System.out.println("Current: "+current.getData());
		current.setData(data);
		
	}
	
	public void printData(){
		System.out.println("---------------------------------------------------");
		Node current = head;
		int index = 0;
		System.out.println(index+"---> "+current.getData());
		while(current.getNext()!=null){
			index++;
			current = current.getNext();
			System.out.println(index+"---> "+current.getData());
		}
		System.out.println("---------------------------------------------------");
	}
	
	public void deleteFirst(){
		Node temp = head.getNext();
		head = temp;
	}
	
	public void deleteLast(){
		deleteNode(getSize()-1);
	}
	
	public void deleteNode(int index){
		Node current = head;
		Node previous = null;
		int count=0;
		
		if((index>getSize()-1) || index < 0){
			System.out.println("Cannot delete:-Node does not exist");
			return;
		}
		
		if(index == 0){
			deleteFirst();
			return;
		}
		
		while(count<index-1){
			current = current.getNext();
			count++;
		}
		previous = current;
		current = current.getNext();
		
		System.out.println("Previous: "+previous.getData());
		System.out.println("Current: "+current.getData());
		
		previous.setNext(current.getNext());
		current.setNext(null);
	}
	
	public int getSize(){
		int count=0;
		Node current = head;
		if(head == null)
			return count;
		while(current.getNext()!=null){
			count++;
			current = current.getNext();
		}
		count++;
		return count;
	}
	
	public static void main(String args[]){
		LinkedListSim listOne = new LinkedListSim();
		listOne.printData();
		
		for(int i=11;i<=20;i++){
			listOne.addLast(i);
		}
		listOne.printData();
		
		listOne.addFirst(200);
		listOne.printData();
		
		listOne.addLast(100);
		listOne.printData();
		
		listOne.addAt(5, 500);
		listOne.printData();
		
		listOne.deleteFirst();
		listOne.printData();
		
		listOne.deleteLast();
		listOne.printData();
		
		listOne.deleteNode(5);
		listOne.printData();
		
		listOne.setDataAt(5, 400);
		listOne.printData();
		
	}
}

