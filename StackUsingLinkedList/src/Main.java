
public class Main {

	public static void main(String[] args) {
		StackUsingLinkedList<Integer> stackusingLL= new StackUsingLinkedList<>();
		System.out.println("Size "+stackusingLL.size());
		int i=0;
		while(i<10) {
			stackusingLL.push(i+1);
			i++;
		}
		System.out.println("size"+stackusingLL.size());
		
		while(!stackusingLL.isEmpty()) {
			System.out.println(stackusingLL.pop());
		}
		
		System.out.println("Size "+stackusingLL.size());
	}
}
