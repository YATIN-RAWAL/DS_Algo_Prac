
public class Main {
	
	public static void main(String[] args) throws EmptyStackException {
		StackUsingArray stackUsingArray=new StackUsingArray();
		int i=0;
		while(i<10){
			stackUsingArray.push(i+1);
			i++;
		}
		
		System.out.println(stackUsingArray.getSize());
		stackUsingArray.push(24);
		System.out.println(stackUsingArray.getSize());
		while(!stackUsingArray.isEmpty()) {
			System.out.println(stackUsingArray.pop());
		}
		
	}

}
