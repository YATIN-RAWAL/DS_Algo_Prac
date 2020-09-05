import java.util.Arrays;
import java.util.Scanner;

public class NQueen {
	
	
	
	private static boolean placeNQueen(int[][] board,int n,int col) {
	
		if(n==0) {
			System.out.println(Arrays.deepToString(board));
			return true;
		}
		
		for(int i=0;i<board.length;i++) {
			if(isSafe(board,i,col)) {
				board[i][col]=1;
				if(placeNQueen(board,n-1,col+1)) {
					return true;
				}
			}
			board[i][col]=0;
		}
		
		
		return false;
	}
	
	
	
	
	private static boolean isSafe(int[][] board, int row , int col) {
		
		//check row
		for(int i=0;i<col;i++) {
			if(board[row][i]==1) {
				return false;
			}
		}
		
		
		//check lower leftDiagonal
		
		for(int i=row, j=col;i>=0 &&j>=0;i--,j--) {
			if(board[i][j]==1) {
				return false;
			}
		}
		
		// check upperColumn
		
		for(int i=row,j=col;i<board.length && j>=0;i++,j--) {
			if(board[i][j]==1) {
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean placeNQueen(int[][] board,int n) {
		return placeNQueen(board,n,0);
	}
	
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noQueensToBePlaced=in.nextInt();
		int[][] board=new int[noQueensToBePlaced][noQueensToBePlaced];
		System.out.println(placeNQueen(board,noQueensToBePlaced));
		
	}

}
