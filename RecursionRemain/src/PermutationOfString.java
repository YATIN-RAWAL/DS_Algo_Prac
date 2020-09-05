import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PermutationOfString {

	public static String[] permutationOfString(String input) {
		String[] outputStringArray;
		ArrayList<String> outputString=new ArrayList<String>();
		if(input.length()==1) {
			return new String[] {input};
		}
		
		for(int i=0;i<input.length();i++) {
			Character chOut= input.charAt(i);
			String[] retrievedArray=permutationOfString(input.substring(0,i)+input.substring(i+1));
			for(int j=0;j<retrievedArray.length;j++) {
				retrievedArray[j]=chOut+retrievedArray[j];
				outputString.add(retrievedArray[j]);
			}
			
		}	
		
	Object[] outputObjectArray=outputString.toArray();
	outputStringArray=Arrays.copyOf(outputObjectArray, outputObjectArray.length, String[].class);
	return outputStringArray;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String inputString = in.next();
		System.out.println(Arrays.deepToString(permutationOfString(inputString)));
	}

}
