import java.util.Arrays;
import java.util.Scanner;

public class RatInAMaze {

	
	
	
	public static boolean checkPath(int[][] maze) {
		int[][] ratsMov=new int[maze.length][];
		for(int i=0;i<maze.length;i++) {
			ratsMov[i]=new int[maze[i].length];
		}
		return checkPath(maze,ratsMov,0,0);
	}
	
	
	public static boolean checkPath(int[][] maze,int[][] ratsMov,int row,int col) {
		if(row<0 || col<0 || row>=maze.length || col>=maze[row].length ) {
			return false;
		}
		
		if(row==maze.length-1 && col== maze[row].length-1) {
			ratsMov[row][col]=1;
			System.out.println(Arrays.deepToString(ratsMov));
			return true;
		}
		
		if(maze[row][col]!=1 || ratsMov[row][col]==1) {
			return false;
		}
		ratsMov[row][col]=1;
		
		//check rat's mov
		//move right
		if(checkPath(maze,ratsMov,row,col+1)) {
			return true;
		}
		//move left
		if(checkPath(maze,ratsMov,row,col-1)){
			return true;
		}
		
		if(checkPath(maze,ratsMov,row-1,col)) {
			return true;
		}
		
		if(checkPath(maze,ratsMov,row+1,col)) {
			return true;
		}
		
		ratsMov[row][col]=0;
		return false;		
	}
	
	
	public static void main(String[] args) {
		int[][] maze= {{1,1,0},{1,0,0},{1,1,1}};
		System.out.println(checkPath(maze));
	}
}
