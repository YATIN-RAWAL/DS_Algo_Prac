
public class Node<T> {
	Node<T> next;
	T data;
	Node(T data){
		this.data= data;
	}
	Node(){
		next=null;
		data=null;
	}
}
