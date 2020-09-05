
public class LinkedList<T> {
	private Node<T> head;
	private Node<T> tail;

	LinkedList() {
		head = null;
	}

	LinkedList(Node<T> head) {
		this.head = head;
	}

	public final void add(T data) {
		Node<T> tmp = new Node(data);
		if (head == null) {
			head = tmp;
			tail = tmp;
		} else {
			tail.setNext(tmp);
			tail = tail.getNext();
			;
		}
	}

	public final void add(int pos, T data) {
		Node<T> temp = head;
		Node<T> dataNode = new Node(data);
		int count = 0;
		if (pos == 0) {
			dataNode.setNext(head);
			head = dataNode;
		}
		while (temp != null && count != pos - 1) {
			temp = temp.getNext();
			count++;
		}
		if (temp != null) {
			Node<T> toNext = temp.getNext();
			temp.setNext(dataNode);
			dataNode.setNext(toNext);
		}
	}

	public final void print() {
		Node<T> tmp = head;
		while (tmp != null) {
			System.out.println(tmp.getData());
			tmp = tmp.getNext();
		}

	}

	public final int getLength() {
		int length = 0;
		Node<T> tmp = head;
		while (tmp != null) {
			length = length + 1;
			tmp = tmp.getNext();
		}

		return length;
	}

	public T get(int i) {
		Node<T> tmp = head;
		int count = 0;
		while (tmp != null && count != i) {
			tmp = tmp.getNext();
			count++;
		}
		if (tmp != null) {
			return tmp.getData();
		}
		return null;
	}

	public void removeNode(int pos) {
		if (pos == 0) {
			head = head.getNext();
		} else {
			int count = 0;
			Node<T> temp = head;
			Node<T> previous = head;
			while (temp != null && count != pos) {
				previous = temp;
				temp = temp.getNext();
				count++;
			}
			previous.setNext(temp.getNext());

		}
	}

	public int getPosition(T data) {
		Node<T> temp = head;
		int count = 0;
		while (temp != null && temp.getData() != data) {
			temp = temp.getNext();
			count++;
		}

		if (temp != null) {
			return count;
		}

		return -1;
	}

	public void appendlastNNodeToFirstNode(int n) {
		Node<T> temp = head;
		int count = 1;
		while (temp.getNext() != null) {
			temp = temp.getNext();
			count++;
		}
		System.out.println("length=" + count);
		if (n >= count) {
			return;
		}
		temp.setNext(head);
		temp = head;
		for (int i = 0; i < (count - n - 1); i++) {
			temp = temp.getNext();
		}

		head = temp.getNext();
		temp.setNext(null);
	}

	public void eleminateDuplicateForSortedLinkedList() {

		Node<T> temp = head;
		if (temp == null) {
			return;
		}
		while (temp != null && temp.getNext() != null) {
			if (temp.getData() == temp.getNext().getData()) {
				temp.setNext(temp.getNext().getNext());
			} else {
				temp = temp.getNext();
			}
		}

	}

	public void reverseALinkedList() {
		Node<T> temp = head;
		Node<T> previousNode = null;
		Node<T> nextNode = null;
		if (temp == null) {
			return;
		}
		while (temp != null && temp.getNext() != null) {
			nextNode = temp.getNext();
			temp.setNext(previousNode);
			previousNode = temp;
			temp = nextNode;
		}
		if (temp != null) {
			head = temp;
			temp.setNext(previousNode);
		}

	}

	public void printReverse() {
		Node<T> temp = head;
		printReverse(temp);
	}

	public void printReverse(Node<T> temp) {
		if (temp.getNext() == null) {
			System.out.println(temp.getData());
			return;
		}
		printReverse(temp.getNext());
		System.out.println(temp.getData());
		return;

	}

	public boolean palindromincString() {
		Node<T> temp = head;
		Node<T> head2;

		if (head == null) {
			return true;
		}
		int length = getLength();
		int posOfBreak;
		int count = 0;
		if (length % 2 == 0) {
			posOfBreak = (length / 2) - 1;
		} else {
			posOfBreak = length / 2;
		}
		while (count != posOfBreak) {
			temp = temp.getNext();
			count++;
		}
		head2 = temp.getNext();
		temp.setNext(null);
		Node<T> head3 = reverseALinkedList(head2);
		Node<T> temptraverseAgain = head;
		while (temptraverseAgain != temp.getNext() && head3 != null) {
			if (temptraverseAgain.getData() == head3.getData()) {
				temptraverseAgain = temptraverseAgain.getNext();
				head3 = head3.getNext();
				continue;
			} else {
				return false;
			}
		}

		return true;
	}

	public Node<T> reverseALinkedList(Node<T> tempHead) {
		if (tempHead == null) {
			return tempHead;
		}
		Node<T> temp = tempHead;
		Node<T> prev = null;
		Node<T> next;
		Node<T> newHead;
		while (temp.getNext() != null) {
			next = temp.getNext();
			temp.setNext(prev);
			prev = temp;
			temp = next;
		}
		newHead = temp;
		temp.setNext(prev);
		return newHead;
	}

	public T getMidPointOfLinkedList() {
		Node<T> slow = head;
		Node<T> fast = head;

		while (fast.getNext() != null && fast.getNext().getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}

		return slow.getData();

	}

	public Node<T> getHead() {
		return this.head;
	}

	public Node<Integer> merge2SortedList(Node<Integer> head1, Node<Integer> head2) {
		Node<Integer> headMergedList = null;
		Node<Integer> tailMergedList = null;

		if (head1 != null && head2 == null) {
			headMergedList = head1;
			return headMergedList;
		} else if (head1 == null && head2 != null) {
			return head1;
		} else if (head != null && head2 != null) {
			if (head1.getData().compareTo(head2.getData()) < 0) {
				headMergedList = head1;
				tailMergedList = head1;
				head1 = head1.getNext();

			} else {
				headMergedList = head2;
				tailMergedList = head2;
				head2 = head2.getNext();
			}
		}
		while (head1 != null && head2 != null) {
			if (head1.getData().compareTo(head2.getData()) < 0) {
				tailMergedList.setNext(head1);
				tailMergedList = tailMergedList.getNext();
				head1 = head1.getNext();
			} else {
				tailMergedList.setNext(head2);
				tailMergedList = tailMergedList.getNext();
				head2 = head2.getNext();
			}

		}

		if (head2 != null) {
			tailMergedList.setNext(head2);
		}
		if (head1 != null) {
			tailMergedList.setNext(head1);
		}

		return headMergedList;
	}

	public Node<T> splitAcrossMidPoint() {
		Node<T> temp = head;
		Node<T> slow = head;
		Node<T> fast = head;
		if (head == null || head.getNext() == null) {
			return head;
		}

		while (fast.getNext() != null && fast.getNext().getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		Node<T> splittedHead = slow.getNext();
		slow.setNext(null);
		return splittedHead;
	}

	public Node<Integer> splitAcrossMidPoint(Node<Integer> node) {
		Node<Integer> temp = node;
		Node<Integer> slow = node;
		Node<Integer> fast = node;

		if (node == null || node.getNext() == null) {
			return node;
		}

		while (fast.getNext() != null && fast.getNext().getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		Node<Integer> splittedHead = slow.getNext();
		slow.setNext(null);
		return splittedHead;
	}

	public Node<Integer> mergeSort(Node<Integer> head) {
		if (head.getNext() == null || head == null) {
			return head;
		}
		Node<Integer> mergeSortedList = null;
		Node<Integer> originalListHead = head;
		Node<Integer> splitListHead = (Node<Integer>) splitAcrossMidPoint(originalListHead);
		Node<Integer> sortedListHead1 = mergeSort(originalListHead);
		Node<Integer> sortedListHead2 = mergeSort(splitListHead);

		mergeSortedList = merge2SortedList(sortedListHead1, sortedListHead2);
		return mergeSortedList;
	}

	public Node<T> reverseALinkedListRecursion(Node<T> head) {
		Node<T> headOfReversedList = null;
		if (head.getNext() == null) {
			headOfReversedList = head;
			return headOfReversedList;

		}
		Node<T> next = head.getNext();
		Node<T> prev = head;
		headOfReversedList = reverseALinkedListRecursion(head.getNext());
		prev.setNext(null);
		next.setNext(prev);
		return headOfReversedList;
	}

	public Node<Integer> insertRecursively(Node<Integer> tempHead, Integer data, int pos) {
		Node<Integer> temp = tempHead;
		if (pos == 0) {
			Node<Integer> newNode = new Node(data);
			newNode.setNext(temp);
			tempHead = newNode;
			return tempHead;
		}

		if (tempHead == null) {
			return null;
		}
		temp.setNext(insertRecursively(temp.getNext(), data, pos - 1));
		return temp;

	}

	public Node<Integer> deleteRecursively(Node<Integer> nodeHead, int pos) {
		Node<Integer> temp; 
	
		if(pos==0) {
			temp=nodeHead.getNext();
			nodeHead.setNext(null);
			return temp;
		}
		
		if (nodeHead == null || (nodeHead.getNext() == null && pos != 0)) {
			return nodeHead;
		}
		nodeHead.setNext(deleteRecursively(nodeHead.getNext(), pos-1));
		return nodeHead;
	}
	
	
	public int returnIndexOfElement(Node<Integer> temp,int element,int pos) {
		if(temp==null) {
			return -1;
		}

		if(temp.getData().equals(element)) {
			return pos;
		}
		
		return returnIndexOfElement(temp.getNext(), element, pos+1);
	}

	
	public Node<Integer> eventAfterOdd(Node<Integer> tempHead){
		if(tempHead.getNext()==null || tempHead==null) {
			return tempHead;
		}
		
		if(tempHead.getData()%2==0) {
			Node<Integer> temp=eventAfterOdd(tempHead.getNext());
			Node<Integer> returnedHead=temp;
			while(temp.getNext()!=null&&temp.getNext().getData()%2!=0) {
				temp=temp.getNext();
			}
			tempHead.setNext(temp.getNext());
			temp.setNext(tempHead);
			tempHead=returnedHead;
		}else {
			tempHead.setNext(eventAfterOdd(tempHead.getNext()));
		}
		
		return tempHead;
	}
	
	
	public Node<Integer> everyNNodesAfterEveryMNodes(Node<Integer> head, int M, int N ){
		Node<Integer> mTail=head;
		Node<Integer> temp=head;
		int count=0;
		if(M==0) {
			return null;
		}if(N==0) {
			return head;
		}
		if(head==null) {
			return null;
		}
		
		while(temp!=null) {
			if(count>=M-1) {
				if(count==N+M-1) {
					count=0;
					mTail.setNext(temp.getNext());
					temp.setNext(null);
					temp=mTail.getNext();
					mTail=mTail.getNext();
					continue;
				}
				
				temp=temp.getNext();
				count++;
				continue;
			}
			
			mTail=mTail.getNext();
			temp=temp.getNext();
			count++;
		}
		if(mTail!=null)
		mTail.setNext(null);
		return head;
	}
	
	
	
	public Node<Integer> swap_nodes(Node<Integer> headtemp,int i,int j){
		Node<Integer> iNode=headtemp;
		Node<Integer> jNode=headtemp;
		Node<Integer> jprev=null;
		Node<Integer> iprev=null;
		Node<Integer> jNext;
		Node<Integer> iNext;
		Node<Integer> temp=headtemp;
		int count=0;
		int greater=i>j?i:j;
		int smaller=i<j?i:j;
		if(i==j) {
			return headtemp;
		}
		
		while(count!=smaller && temp.getNext()!=null) {
			iprev=temp;
			temp=temp.getNext();
			count++;
		}
		
		if(temp.getNext()==null) {
			return headtemp;
		}
		
		iNode=temp;
		iNext=temp.getNext();
		if(iprev!=null) {
			iprev.setNext(null);
		}
		
		while(count!=greater&& temp.getNext()!=null) {
			jprev=temp;
			temp=temp.getNext();
			count++;
		}
		
		if(count!=greater) {
			return headtemp;
		}
		jNode=temp;
		jNext=temp.getNext();
		
		iNode.setNext(jNode.getNext());
		jNode.setNext(iNext);
		jprev.setNext(iNode);
		if(iprev!=null) {
		iprev.setNext(jNode);
		}
		if(smaller ==0) {
			head=(Node<T>) jNode;
		}
		
		return (Node<Integer>) head;
		
	}
	
	
	public Node<Integer> splitKterms(Node<Integer> tempHead,int k){
		Node<Integer> temp=tempHead;
		Node<Integer> splitHead;
		while(k-1!=0 && temp!=null) {
			temp=temp.getNext();
			k--;
		}
		splitHead=temp.getNext();
		temp.setNext(null);
		return splitHead;
	}
	
	//	private Node<T> rever
	
	
	public Node<Integer> kreverseLinkedList(Node<Integer> tempHead, int k){
		Node<Integer> temp=tempHead;
		if(temp==null || temp.getNext()==null) {
			return tempHead;
		}
		int count=0;
		while(temp!=null) {
			temp=temp.getNext();
			count++;
		}
		if(count>=k) {
			Node<Integer> splitHead=splitKterms(tempHead, k);
		//return Pair head and Tail
			Pair reverseHead= reverseReturnHeadTail((Node<T>)tempHead);
			Node<Integer> splitReverseHead=kreverseLinkedList(splitHead, k);
			reverseHead.getTailReverse().setNext(splitReverseHead);
			return reverseHead.getHeadReverse();
		}
		
		Pair reverseHead=reverseReturnHeadTail((Node<T>)tempHead);
		
		return reverseHead.getHeadReverse();
	}
	
	
	public Pair<T> reverseReturnHeadTail(Node<T> temphead){
		Node<T> temp=temphead;
		Node<T> prev=null;
		Pair<T> pair=new Pair<>();
		Node<T> next;
		pair.setTailReverse(temphead);
		while(temp.getNext()!=null) {
			next=temp.getNext();
			temp.setNext(prev);
			prev=temp;
			temp=next;
		}
		temp.setNext(prev);
		pair.setHeadReverse(temp);
		return pair;
	}

	public Node<Integer> bubbleSort(Node<Integer> tempHead){
		int count=0;
		Node<Integer> temp=tempHead;
		while(temp!=null) {
			temp=temp.getNext();
			count++;
		}
		if(tempHead==null || tempHead.getNext()==null) {
			return tempHead;
		}
		Node<Integer> iNode;
		Node<Integer> jNode;
		Node<Integer> newHead=tempHead;
		Node<Integer> prev=null;
		for(int i=0;i<count-1;i++) {
			temp=newHead;
			prev=null;
			for(int j=0;j<count-1-i;j++) {
				if(temp.getNext()!=null && temp.getData()>temp.getNext().getData()) {
					iNode=temp;
					jNode=temp.getNext();
					iNode.setNext(jNode.getNext());
					jNode.setNext(iNode);
					if(prev!=null)
					prev.setNext(jNode);
					if(j==0) {
						newHead=jNode;
					}
					prev=jNode;
					continue;
				}
				prev=temp;
				temp=temp.getNext();
			}
		}
		return newHead;
	}

    public static void deleteAlternateNodes(Node<Integer> head) {
    	Node<Integer> temp=head;
    	if(temp==null || temp.getNext()==null) {
    		return;
    	}
    	
    	while(temp.getNext()!=null && temp.getNext().getNext()!=null) {
    		temp.setNext(temp.getNext().getNext());
    		temp=temp.getNext();
    	}
    	temp.setNext(null);
    }


}
