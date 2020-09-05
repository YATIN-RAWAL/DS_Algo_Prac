
public class QueueUsingLinkedList {

	private Node<Integer> front;
	private Node<Integer> rear;
	private int size;
	
	QueueUsingLinkedList(){
		front=null;
		rear=null;
		size=0;
	}
	
	public int getSize() {
		return size;
	}
	
	public int front() throws EmptyQueueException {
		if(front==null) {
			throw new EmptyQueueException();
		}
		return front.data;
	}
	
	
	public void enqueue(int element) {
		Node<Integer> newNode= new Node(element);
		if(size==0) {
			front=newNode;
			rear=newNode;
		}
		
		rear.next=newNode;
		rear=newNode;
		size++;
	}
	
	
	
	public int dequeue() throws EmptyQueueException {
		if(size==0) {
			throw new EmptyQueueException();
		}
		
		int temp=front.data;
		Node<Integer> tempfront=front.next;
		front.next=null;
		front=tempfront;
		size--;
		return temp;	
	}
	
	
	public boolean isEmpty() {
		return (size==0)?true:false;
	}
	
}
