import java.util.Arrays;
import java.util.Scanner;

public class AppWithMaxProfit {

	public static int maximumProfit(int budget[]) {
		Arrays.sort(budget);
		int maxProfit=0;
		for(int i=0;i<budget.length;i++) {
			int profit=budget[i]*(budget.length-i);
			if(maxProfit>=profit) {
				continue;
			}else {
				maxProfit=profit;
			}
		}
		return maxProfit;
	}
	
	public static void main(String [] args) {
		Scanner input= new Scanner(System.in);
		String inputString=input.nextLine();
		String[] stringArray=inputString.split(" ");
		int[] budgetArray= new int[inputString.length()];
		for(int i=0;i<budgetArray.length;i++) {
			budgetArray[i]=Integer.parseInt(stringArray[i]);
		}
		System.out.println(maximumProfit(budgetArray));
			
	}
}
