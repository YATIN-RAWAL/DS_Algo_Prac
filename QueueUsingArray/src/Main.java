
public class Main {

	public static void main(String[] args) throws QueueOverflowException, EmptyQueueException {
		QueueUsingArray queue=new QueueUsingArray(3);
		int i=0;
		while(i<3) {
			queue.enqueue(i+1);
			i++;
		}
		
		int element=queue.dequeue();
		System.out.println(element);
		queue.enqueue(1);
		while(!queue.isEmpty()) {
			System.out.println("front + "+queue.front() +" pop "+queue.dequeue());
		}
		System.out.println("--------------------------------------------------");
		queue.enqueue(22);
		System.out.println(queue.dequeue());
		
		System.out.println(queue.front()); 
		
	}
}
