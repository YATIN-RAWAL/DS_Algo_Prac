import java.util.Scanner;

public class Patterns {

	public static void triangleOfANumber(int numberOfElement) {
		int i;
		int j;
		int k;
		for (i = 1; i <= numberOfElement; i++) {
			for (j = 0; j < numberOfElement - i; j++) {
				System.out.print("*");
			}
			int row = i;
			for (k = 0; k < i; k++) {
				System.out.print(row);
				row++;
			}
			row = row - 2;
			for (k = 0; k < i - 1; k++) {
				System.out.print(row);
				row--;
			}

			System.out.println();
		}

	}

	public static void numberPatter(int numberOFRows) {
		for (int i = 1; i <= numberOFRows; i++) {
			for (int j = 0; j < numberOFRows - i; j++) {
				System.out.print("*");
			}
			int row=i;
			for(int k=0;k<i;k++) {
				System.out.print(row);
				row++;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfElement = input.nextInt();
		// System.out.println("*********Triangle Of Number*********");
		// triangleOfANumber(numberOfElement);
		// System.out.println("*********Number Pattern*********");
		numberPatter(numberOfElement);

	}

}
