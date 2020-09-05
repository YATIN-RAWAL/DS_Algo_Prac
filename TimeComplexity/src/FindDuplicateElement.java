import java.util.Arrays;
import java.util.Scanner;

public class FindDuplicateElement {

	public static int duplicate(int[] arr){  
		Arrays.sort(arr);
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]==arr[i+1]) {
				return arr[i];
			}
		}
		
		return arr[arr.length-1];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arrSize=in.nextInt();
		in.nextLine();
		String inString=in.nextLine();
		String[] arrString=inString.split(" ");
		int[] arrInput=new int[arrString.length];
		for(int i=0;i<arrInput.length;i++) {
			arrInput[i]=Integer.parseInt(arrString[i]);
		}
		
		System.out.println(duplicate(arrInput));
	}
}
