import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList= new LinkedList();
		Scanner input=new Scanner(System.in);
		int data=input.nextInt();
		while(data!=-1) {
			linkedList.add(data);
			data=input.nextInt();
		}
		
		input.nextLine();
		//int dataForNewNode=input.nextInt();
		//input.nextLine();
		//int moveLastNNodes=input.nextInt();
		//LinkedList<Integer> linkedList2=new LinkedList<Integer>(linkedList.reverseALinkedList(linkedList.getHead()));
		
		//linkedList.printReverse();
		
		//linkedList2.print();
		
		//System.out.println(linkedList.palindromincString());
	
		//LinkedList<Integer> linkedList2=new LinkedList();
		//data=input.nextInt();
		//while(data!=-1) {
		//	linkedList2.add(data);
		//	data=input.nextInt();
		//}
		
		//Node<Integer> headMerged=linkedList.merge2SortedList(linkedList.getHead(), linkedList2.getHead());
		
	//	Node<Integer> mergeSort=linkedList.mergeSort(linkedList.getHead());
	//	LinkedList<Integer> linkedList3=new LinkedList(mergeSort);
	//	linkedList3.print();
			//	System.out.println(linkedList.getMidPointOfLinkedList());
	//	Node<Integer> reversedList=linkedList.reverseALinkedList(linkedList.getHead());
	//	LinkedList<Integer> linkedList3=new LinkedList<>(reversedList);
	//	linkedList3.print();
	//LinkedList<Integer> linkedList2=new LinkedList(	linkedList.everyNNodesAfterEveryMNodes(linkedList.getHead(), 5, 3));
	//linkedList2.print();
	
		linkedList.deleteAlternateNodes(linkedList.getHead());
		//LinkedList linkedList2=new LinkedList(headNew);
		linkedList.print();
	
	}
}
