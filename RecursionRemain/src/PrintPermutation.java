import java.util.Scanner;

public class PrintPermutation {

	public static void permutations(String input){
		permutations(input,"");
		
	}
	
	
	public static void permutations(String input,String output) {
		if(input.length()==1) {
			System.out.println(output+input);
			return;
		}
		
		for(int i=0;i<input.length();i++) {
			permutations(input.substring(0,i)+input.substring(i+1),output+Character.toString(input.charAt(i)));
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		String inputString=in.next();
		permutations(inputString);
	}
}
