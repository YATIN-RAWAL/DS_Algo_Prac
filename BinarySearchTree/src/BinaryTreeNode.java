import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeNode<T> {

	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	
	BinaryTreeNode(T data){
		this.data=data;
	}
	
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Scanner input= new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData=input.nextInt();
		BinaryTreeNode<Integer> root=null;
		if(rootData==-1) {
			return root;
		}
		root=new BinaryTreeNode<Integer>(rootData);		
		Queue<BinaryTreeNode<Integer>> queue= new LinkedList();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> nodeFront=queue.remove();
			System.out.println("Enter left child for "+nodeFront.data);
			int leftData=input.nextInt();
			if(leftData!=-1) {
				BinaryTreeNode<Integer> leftChild=new BinaryTreeNode<Integer>(leftData);
				nodeFront.left=leftChild;
				queue.add(leftChild);
			}
			System.out.println("Enter rightChild for "+nodeFront.data);
			int rightData=input.nextInt();
			if(rightData!=-1) {
				BinaryTreeNode<Integer> rightChild= new BinaryTreeNode<Integer>(rightData);
				nodeFront.right=rightChild;
				queue.add(rightChild);
			}
		}
		input.close();
		return root;
	}
	
	public static void printLevelwise(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return ;
		}
		Queue<BinaryTreeNode<Integer>> queue= new LinkedList();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size=queue.size();
			String p="";
			for(int i=0;i<size;i++) {
				BinaryTreeNode<Integer> nodeFront=queue.remove();
				p=p+nodeFront.data+" ";
				if(nodeFront.left!=null) {
					queue.add(nodeFront.left);
				}
				if(nodeFront.right!=null) {
					queue.add(nodeFront.right);
				}
			}
			System.out.println(p);
		}
	}
	

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=takeInputLevelWise();
		System.out.println("*****PrintLevelWise*******");
		printLevelwise(root);
	}
	
}
