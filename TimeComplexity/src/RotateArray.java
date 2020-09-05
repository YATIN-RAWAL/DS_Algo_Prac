import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {

	public static void rotate(int[] arr, int d) {
		int byHowMuch=d;
		if(d>=arr.length) {
			int a=d/arr.length;
			byHowMuch=d-(a*arr.length);
			d=byHowMuch;
		}
			reverseAnArray(arr,0,arr.length-1);
			reverseAnArray(arr,0,(arr.length-1)-d);
			reverseAnArray(arr,arr.length-d,arr.length-1);
			System.out.println(Arrays.toString(arr));
	}
	
	
	
	
	private static final void reverseAnArray(int[] arr,int fromWhere,int toWhere) {
		int j=0;
		for(int i=fromWhere;i<=(fromWhere+toWhere)/2;i++) {
			int temp=arr[i];
			arr[i]=arr[toWhere-j];
			arr[toWhere-j]=temp;
			j++;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sizeOfArray=in.nextInt();
		in.nextLine();
		String stringInput=in.nextLine();
		String[] stringArray=stringInput.split(" ");
		int[] intArray=new int[stringArray.length];
		for(int i=0;i<stringArray.length;i++) {
			intArray[i]=Integer.parseInt(stringArray[i]);
		}
		int rotateBy=in.nextInt();
		rotate(intArray,rotateBy);
		
	}
}
