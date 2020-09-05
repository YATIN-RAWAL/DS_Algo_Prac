import java.util.EmptyStackException;

public class StackUsingLinkedList<T> {

	Node<T> head;
	int size;

	public StackUsingLinkedList() {
		head = null;
		size = 0;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}

		return false;
	}
	
	public int size() {
		return size;
	}

	public T top() {
		if (head == null) {
			throw new EmptyStackException();
		}
		return head.data;
	}

	public void push(T element) {
		Node<T> newNode= new Node(null,element);
		if(head==null) {
			head=newNode;
		}else {
			newNode.next=head;
			head=newNode;
		}
		size++;
	}

	public T pop() {
		T element;
		if(size==0) {
			throw new EmptyStackException();
		}
		element=head.data;
		Node<T> temp=head.next;
		head.next=null;
		head=temp;
		size--;
		return element;
	}

}
