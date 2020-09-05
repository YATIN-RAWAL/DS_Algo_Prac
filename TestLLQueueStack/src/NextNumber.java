import java.util.Scanner;

public class NextNumber {

	private static Node head;
	private static Node tail;
	public static Node<Integer> nextLargeNumber(Node<Integer> head) {
		Node<Integer> newHead=reverseList(head);
		Node<Integer> temp=newHead;
		while(temp!=null) {
			temp.data=temp.data+1;
			if(temp.data==10) {
				temp.data=0;
				if(temp.next==null) {
					Node newNode= new Node(1);
					temp.next=newNode;
					temp=temp.next;
					break;
				}
				temp=temp.next;
			}else {
				break;
			}
		}
		return reverseList(newHead);
	}

	
	public static Node reverseList(Node tempHead) {
		Node temp=tempHead;
		Node prev=null;
		Node next;
		while(temp.next!=null) {
			next=temp.next;
			temp.next=prev;
			prev=temp;
			temp=next;
		}
		temp.next=prev;
		return temp;
	}
	
	
	public static void add(int data) {
		Node<Integer> node= new Node(data);
		if(head == null) {
			head=node;
			tail=node;
		}else {
			tail.next=node;
			tail=tail.next;
		}
	}
	
	
	public static void print() {
		Node temp=head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	
	public static void print(Node newNode) {
		Node temp=newNode;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	
	
	
	public static void main (String[] args) {
		Scanner input= new Scanner(System.in);
		int number=input.nextInt();
		while(number!=-1) {
			add(number);
			number=input.nextInt();
		}
		//print(reverseList(head));
		print(nextLargeNumber(head));
		
	}
	
}
