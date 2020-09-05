
public class Node<T> {

	 private T data;
	 private Node<T> next;
	
	 Node(T data){
		 this.data=data;
	 }
	 
	 Node(){
		 
	 }
	 
	 
	 public T getData() {
		 return data;
	 }
	 
	 public Node<T> getNext(){
		 return next;
	 }
	 
	 public void setData(T data) {
		 this.data=data;
	 }
	 
	 public void setNext(Node<T> next) {
		 this.next=next;
	 }
	 
}
