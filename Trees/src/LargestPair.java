
public class LargestPair<T> {

	TreeNode<T> largest;
	TreeNode<T> secondLargest;
	LargestPair(){
	largest=null;
	secondLargest=null;
	}
	
	LargestPair(TreeNode<T> largest,TreeNode<T> secondLargest){
		this.largest=largest;
		this.secondLargest=secondLargest;
	}
}
