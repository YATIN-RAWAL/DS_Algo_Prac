
public class Node <T>{

	Node<T> next;
	T data;
	public Node() {
		
	}
	public Node(Node<T> next,T data) {
		this.next=next;
		this.data=data;
	}
}
