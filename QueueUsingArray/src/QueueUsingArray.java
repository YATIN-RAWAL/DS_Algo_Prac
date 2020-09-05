
public class QueueUsingArray {

	private int[] data;
	private int front;
	private int rear;
	private int size=0;
	
	QueueUsingArray(){
		data= new int[10];
		front=-1;
		rear=-1;
		size=0;				
	}
	
	QueueUsingArray(int capacity){
		data=new int[capacity];
		size=0;
		front=-1;
		rear=-1;
	}
	
	public int size() {
		return size;
	}
	
	public int front() throws EmptyQueueException {
		if(size()==0) {
			throw new EmptyQueueException();
		}
		return data[front];
	}
	
	
	public boolean isEmpty() {
		return (size==0)?true:false;
	}
	
	
	public void enqueue(int element) throws QueueOverflowException {
		if(size==data.length) {
			throw new QueueOverflowException();
		}
		if(size==0) {
			front=0;
			rear=-1;
		}
		rear=(rear+1)%data.length;
		data[rear]=element;
		size++;
	}
	
	
	public int dequeue() throws EmptyQueueException {
		if(size==0) {
			throw new EmptyQueueException();
		}
		int temp=data[front];
		front=(front+1)%data.length;
		size--;
		return temp;
	}
	
	
	
	
}
