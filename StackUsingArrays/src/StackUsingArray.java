
public class StackUsingArray {

	private int[] data;
	private int top;

	public StackUsingArray() {
		data = new int[10];
		top = -1;
	}

	public StackUsingArray(int capacity) {
		data = new int[capacity];
		top = -1;
	}

	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}

	public int top() throws EmptyStackException {
		if(top==-1) {
			throw new EmptyStackException();
		}
		return data[top];
	}
	
	
	public int getSize() {
		return top+1;
	}
	
	
	public void push(int element) {
		if(getSize()==data.length) {
			doubleCapacity();
		}
		top++;
		data[top]=element;
	}
	
	
	
	public int pop() throws EmptyStackException {
		if(top==-1) {
			throw new EmptyStackException();
		}
		
		int element=data[top];
		top--;
		return element;
	}
	
	
	
	
	
	public void doubleCapacity() {
		int[] temp=data;
		data=new int[data.length*2];
		for(int i=0;i<temp.length;i++) {
			data[i]=temp[i];
		}
	}
	





}
