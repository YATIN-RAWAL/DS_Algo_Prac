
public class MainForQueue {

	public static void main(String[] args) throws EmptyQueueException {
		QueueUsingLinkedList queue=new QueueUsingLinkedList();
		int i=0;
		while(i<3) {
			queue.enqueue(1+i);
			i++;
		}
		
		while(!queue.isEmpty()) {
			System.out.println("front----"+ queue.front()+"dequeue------"+queue.dequeue());
		}
		
	}
}
