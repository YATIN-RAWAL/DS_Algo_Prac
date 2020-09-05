import java.util.Arrays;
import java.util.Scanner;

public class FindTriplets {

	public static void FindTriplet(int[] arr, int x) {
		Arrays.sort(arr);
		int i = 0;
		int j = arr.length - 1;
		int k = i + 1;
		while (i < arr.length - 2) {

			if (k < j) {
				int sum = arr[i] + arr[j] + arr[k];
				if (sum == x) {
					System.out.println(arr[i] + " " + arr[k] + " " + arr[j]);
					j--;
					continue;
				} else if (sum > x) {
					if (j > k) {
						j--;
					} else {
						j = arr.length - 1;
						k = i + 2;
						continue;
					}
				} else if (sum < x) {
					if (j > k) {
						j = arr.length - 1;
						k++;
					} else {
						j = arr.length - 1;
						i = i + 1;
						k = i + 1;

						continue;
					}
				}
			} else {
				i++;
				j = arr.length - 1;
				k = i + 1;

			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String[] stringArray = input.split(" ");
		int[] inputArray = new int[stringArray.length];
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = Integer.parseInt(stringArray[i]);
		}
		int sum = in.nextInt();
		FindTriplet_Attempt2(inputArray, sum);

	}

	private static void FindTriplet_Attempt2(int[] arr, int x) {
		Arrays.sort(arr);
		int i=0;
		int j=arr.length-1;
		while(i<arr.length-2) {
			int k=i+1;
			int sum=x-arr[i];
			while(k<arr.length-1) {
				if(k<j) {
				if(sum-arr[k]>arr[j]) {
					k++;
					j=arr.length-1;
				}else if(sum-arr[k]<arr[j]) {
					j--;
				}else if(sum-arr[k]==arr[j]) {
					System.out.println(arr[i]+" "+arr[k]+" "+arr[j]);
					j--;
				}
			}else {
				k++;
				j=arr.length-1;
			}
			}
		i++;
		j=arr.length-1;
		}
		
	}
}
