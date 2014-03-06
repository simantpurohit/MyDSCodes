package sim.linkedList;

public class Node {
	private Node next;
	private int data;
	
	public Node() {
		//this.data = data;
		next = null;
	}
	
	public Node(int data) {
		this.data = data;
		next = null;
	}
	
	public Node getNext(){
		if(this.next == null){
			return null;
		}
		
		else{
			return this.next;
		}
	}
	
	public void setNext(Node a){
		this.next = a;
	}
	
	public int getData(){
		return this.data;
	}
	
	public void setData(int data){
		this.data = data;
	}
}
