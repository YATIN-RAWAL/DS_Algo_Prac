
public class DynamicQueueUsingArray {

	private int[] data;
	private int size;
	private int front;
	private int rear;
	
	DynamicQueueUsingArray(){
		data=new int[10];
		size=0;
		front=-1;
		rear=-1;
	}
	DynamicQueueUsingArray(int capacity){
		data= new int[capacity];
		size=0;
		front=-1;
		rear=-1;
	}
	
	public int size() {
		return size;
	}
	
	public int front() throws EmptyQueueException {
		if(size==0) {
			throw new EmptyQueueException(); 
		}
		return data[front];
	}
	
	public boolean isEmpty() {
		return (size==0)?true:false;
	}
	
	public void enqueue(int element){
		if(size==data.length) {
			doubleCapacity();
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
		if (size==0) {
			throw new EmptyQueueException();
		}
		int temp=data[front];
		front=(front+1)%data.length;
		size--;
		return temp;
	}
	
	
	public void doubleCapacity() {
		int[] temp=data;
		data= new int[2*temp.length] ;
		int index=0;
		for(int i=front;i<temp.length;i++) {
			data[index]=temp[i];
			index++;
		}
		for(int i=0;i<=rear;i++) {
			data[index]=temp[i];
			index++;
		}
		
	}
	
	
}
