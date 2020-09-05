import java.util.Scanner;

public class CheckArrayRotation {
	
	
	public static int arrayRotateCheck(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]>arr[i+1]) {
				return i+1;
			}
		}
	
		return 0;
	
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		String[] stringArray = inputString.split(" ");
		int[] intArray = new int[stringArray.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(stringArray[i]);
		}
		System.out.println(arrayRotateCheck(intArray));
	}
}
