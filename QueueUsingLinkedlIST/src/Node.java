
public class Node <T> {

	Node<T> next;
	T data;
	Node(Node<T> next,T data){
		this.next=next;
		this.data=data;
	}
	
	Node(T data){
		this.data=data;
	}
}
