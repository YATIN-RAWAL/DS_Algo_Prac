import java.util.Arrays;
import java.util.Scanner;

public class FindUniqueElements {

	public static int findUnique(int[] arr){
		Arrays.sort(arr);
		for(int i=0;i<arr.length-1;i++) {
			
			if(arr[i+1]>arr[i]) {
				return arr[i];
			}else {
				i=i+1;
				continue;
			}
		}
		
		return arr[arr.length-1];
	}
	
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int inputSize=input.nextInt();
		input.nextLine();
		String inputString=input.nextLine();
		String[] inputStringArr=inputString.split(" ");
		int[] inputArr=new int[inputStringArr.length];
		for(int i=0;i<inputArr.length;i++) {
			inputArr[i]=Integer.parseInt(inputStringArr[i]);
		}
		System.out.println(findUnique(inputArr));
	}
}
