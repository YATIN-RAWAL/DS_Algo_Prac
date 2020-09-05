
public class MainForDynamic {

	public static void main(String[] args) throws EmptyQueueException {
		DynamicQueueUsingArray dynamic=new DynamicQueueUsingArray(3);
		int i=0;
		while(i<3) {
			dynamic.enqueue(i+1);
			i++;
		}
		
		while(!dynamic.isEmpty()) {
			System.out.println(" Front " +dynamic.front()+" dequeue "+ dynamic.dequeue() );
		}
		
		
		
		System.out.println("____________________________________________________________________");
		i=0;
		while(i<6) {
			dynamic.enqueue(i+1);
			i++;
		}

		while(!dynamic.isEmpty()) {
			System.out.println(" Front " +dynamic.front()+" dequeue "+ dynamic.dequeue() );
		}
		
		
	}
}
