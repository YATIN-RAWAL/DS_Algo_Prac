import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTreeUse {

	public static BinaryTreeNode<Integer> takeInput() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter root data");
		int n = input.nextInt();
		if (n == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(n);
		root.left = takeInput();
		root.right = takeInput();

		return root;

	}

	public static void printZigZagUsing2Stacks(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		Stack<BinaryTreeNode<Integer>> zig= new Stack();
		Stack<BinaryTreeNode<Integer>> zag=new Stack();
		zig.push(root);
		
		while( (!zig.isEmpty()) || (!zag.isEmpty())) {
			String zigString="";
			while(!zig.isEmpty()) {
				BinaryTreeNode<Integer> zigTop=zig.pop();
				if(zigTop==null) {
					continue;
				}
				zigString=zigString+zigTop.data+" ";
				if(zigTop.left!=null)
				zag.push(zigTop.left);
				if(zigTop.right!=null)
				zag.push(zigTop.right);
			}
			System.out.println(zigString);
			String zagString="";
			while(!zag.isEmpty()) {
				BinaryTreeNode<Integer> zagTop=zag.pop();
				if(zagTop==null) {
					continue;
				}
				zagString=zagString+zagTop.data+" ";
				if(zagTop.right!=null);
				zig.push(zagTop.right);
				if(zagTop.left!=null)
				zig.push(zagTop.left);
			}
			System.out.println(zagString);
		}
	}
	public static void print(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		String p = root.data + ": ";
		if (root.left != null) {
			p = p + "L" + root.left.data + ", ";
		}
		if (root.right != null) {
			p = p + "R" + root.right.data;
		}
		System.out.println(p);
		print(root.left);
		print(root.right);
	}

	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = input.nextInt();
		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = queue.remove();
			System.out.println("Enter left root data for " + frontNode.data);
			int left = input.nextInt();
			if (left != -1) {
				BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<Integer>(left);
				frontNode.left = leftNode;
				queue.add(leftNode);
			}
			System.out.println("Enter right Node for " + frontNode.data);
			int right = input.nextInt();
			if (right != -1) {
				BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<Integer>(right);
				frontNode.right = rightNode;
				queue.add(rightNode);
			}
		}
		return root;
	}

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> nodeFront = queue.remove();
			String p = nodeFront.data + ":";
			if (nodeFront.left != null) {
				p = p + "L:" + nodeFront.left.data + ",";
				queue.add(nodeFront.left);
			} else {
				p = p + "L:" + "-1,";
			}
			if (nodeFront.right != null) {
				p = p + "R:" + nodeFront.right.data;
				queue.add(nodeFront.right);
			} else {
				p = p + "R:" + "-1";
			}
			System.out.println(p);
		}
	}

	public static int countNodes(BinaryTreeNode<Integer> root) {
		int count = 0;
		if (root == null) {
			return count;
		}
		count++;
		count = count + countNodes(root.left);
		count = count + countNodes(root.right);
		return count;
	}

	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
		Boolean result = false;
		if (root == null) {
			return result;
		}
		if (root.data == x) {
			return true;
		}

		result = result || isNodePresent(root.left, x);
		if (result == true) {
			return result;
		}

		return result || isNodePresent(root.right, x);

	}

	public static int heightOfTree(BinaryTreeNode<Integer> root) {
		int height = 0;
		if (root == null) {
			return height;
		}
		height++;
		int leftChildHeight = 0;
		int rightChildHeight = 0;
		leftChildHeight = heightOfTree(root.left);
		rightChildHeight = heightOfTree(root.right);
		if (leftChildHeight > rightChildHeight) {
			height = height + leftChildHeight;
		} else {
			height = height + rightChildHeight;
		}
		return height;
	}

	public static void mirrorABinaryTree(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		BinaryTreeNode<Integer> tmp=root.left;
		root.left=root.right;
		root.right=tmp;
		mirrorABinaryTree(root.left);
		mirrorABinaryTree(root.right);
		return;
	}
	public static BinaryTreeNode<Integer> findNode(BinaryTreeNode<Integer> root, int x) {
		if (root == null) {
			return root;
		}
		if (root.data == x) {
			return root;
		}
		BinaryTreeNode<Integer> left = findNode(root.left, x);
		if (left != null) {
			return left;
		}
		return findNode(root.right, x);

	}
	
	/* complexity is O(n*h) */
	public static int DiameterOfBinaryTreeApprocach1(BinaryTreeNode<Integer> root) {
		int leftHeight=0;
		int rightHeight=0;
		int diameter=0;
		int op1=0;
		int op2=0;
		int op3=0;
		if(root==null) {
			return diameter;
		}
		
		op1=heightOfTree(root.left)+heightOfTree(root.right);
		op2=DiameterOfBinaryTreeApprocach1(root.left);
		op3=DiameterOfBinaryTreeApprocach1(root.right);
		diameter=op2>op3?op2:op3;
		diameter=diameter>op1?diameter:op1;
		
		
		return diameter;
	}
	
	/* Improved Approach */
	
	public static HeightAndDiameter<Integer,Integer> diameterOfTree(BinaryTreeNode<Integer> root){
		HeightAndDiameter<Integer,Integer> output=new HeightAndDiameter();
		if(root==null) {
			output.height=0;
			output.diameter=0;
			return output;
		}
		HeightAndDiameter<Integer,Integer> leftOutput=diameterOfTree(root.left);
		HeightAndDiameter<Integer,Integer> rightOutput=diameterOfTree(root.right);
		int height=1+(leftOutput.height>rightOutput.height?leftOutput.height:rightOutput.height);
		int option1=leftOutput.height+rightOutput.height;
		int option2=leftOutput.diameter;
		int option3=rightOutput.diameter;
		output.diameter=option1>option2?option1:option2;
		output.diameter=output.diameter>option3?output.diameter:option3;
		output.height=height;

		return output;
	}
	
	
	
	
	public static void preOrderTraversal(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	
	public static void postOrderTraversal(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data+" ");
	}
	
	
	public static void inOrderTraversal(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.data+" ");
		inOrderTraversal(root.right);
	}

	public static BinaryTreeNode<Integer> constructFromPreOrderAndInorder(int[] pre,int[] in){
		return constructFromPreOrderAndInorder(pre,in,0,pre.length-1,0,in.length-1);
	}
	
	public static BinaryTreeNode<Integer> constructFromPreOrderAndInorder(int[] pre, int[] in, int preS,int preE,int inS,int inE){
		if(preS>preE) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(pre[preS]);
		if(preS==preE) {
			return root;
		}
		int count=0,i=inS;
		while(in[i]!=pre[preS]) {
			count++;
			i++;
		}
		int leftNodePreS=preS+1;
		int leftNodePreE=preS+count;
		int rightNodePreS=leftNodePreE+1;
		int rightNodePreE=preE;
		int leftNodeinS=inS;
		int leftNodeinE=i-1;
		int rightNodeinS=i+1;
		int rightNodeinE=inE;
		BinaryTreeNode<Integer> leftNode=constructFromPreOrderAndInorder(pre,in,leftNodePreS,leftNodePreE,leftNodeinS,leftNodeinE);
		BinaryTreeNode<Integer> rightNode=constructFromPreOrderAndInorder(pre,in,rightNodePreS,rightNodePreE,rightNodeinS,rightNodeinE);
		
		root.left=leftNode;
		root.right=rightNode;
		return root;
	}
	
	public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post,
			int[] in){
		return constructTreeFromPostAndInOrder(post,in,0,post.length-1,0,in.length-1);
	}
	
	public static BinaryTreeNode<Integer> constructTreeFromPostAndInOrder(int[] post,int[] in,int postS,int postE,int inS,int inE){
		if(postS>postE) {
			return null;
		}
		BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(post[postE]);
		if(postS==postE) {
			return root;
		}
		int count=0,i=inS;
		while(in[i]!=post[postE]) {
			count++;
			i++;
		}
		
		int leftStartNodePost=postS;
		int leftEndNodePost=postS+count-1;
		int rightStartNodePost=leftEndNodePost+1;
		int rightEndNodePost=postE-1;
		int leftStartNodeIn=inS;
		int leftEndNodeIn=i-1;
		int rightStartNodeIn=i+1;
		int rightEndNodeIn=inE;
		BinaryTreeNode<Integer> leftNode=constructTreeFromPostAndInOrder(post,in,leftStartNodePost,leftEndNodePost,leftStartNodeIn,leftEndNodeIn);
		BinaryTreeNode<Integer> rightNode=constructTreeFromPostAndInOrder(post,in,rightStartNodePost,rightEndNodePost,rightStartNodeIn,rightEndNodeIn);
		root.left=leftNode;
		root.right=rightNode;
		return root;
	}

	public static int sumOfNodes(BinaryTreeNode<Integer> root) {
		int sum=0;
		if(root==null) {
			return sum;
		}
		sum=root.data;
		sum+=sumOfNodes(root.left);
		sum+=sumOfNodes(root.right);
		return sum;
	}
	
	public static boolean checkBalanced(BinaryTreeNode<Integer> root){
		boolean result=false;
		int heightLeftSubTree;
		int rightSubTree;
		if(root==null) {
			return true;
		}
		heightLeftSubTree=heightOfTree(root.left);
		rightSubTree=heightOfTree(root.right);
		if(Math.abs(heightLeftSubTree-rightSubTree)<2) {
			checkBalanced(root.left);
			checkBalanced(root.right);
			return checkBalanced(root.left)&&checkBalanced(root.right);
		}
		
		return result;
	}
	

	public static void printLevelWise2(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		Queue<BinaryTreeNode<Integer>> queue=new LinkedList<BinaryTreeNode<Integer>>();
		queue.add(root);
		String p;
		while(!queue.isEmpty()) {
			p="";
			int size=queue.size();
			for(int i=0;i<size;i++) {
				BinaryTreeNode<Integer> nodeFront=queue.remove();
				p=p+nodeFront.data+" ";
				if(nodeFront.left!=null)
				queue.add(nodeFront.left);
				if(nodeFront.right!=null)
				queue.add(nodeFront.right);
			}
			System.out.println(p);	
		}
		
	}
	
	
	public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root){
		if(root==null||(root.left==null&&root.right==null)) {
			return null;
		}
		root.left=removeLeafNodes(root.left);
		root.right=removeLeafNodes(root.right);
		return root;
	}

	
	public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root){
		ArrayList<Node<BinaryTreeNode<Integer>>> arrayList= new ArrayList();
		if(root==null) {
			return arrayList;
		}
		Queue<BinaryTreeNode<Integer>> queue=new LinkedList();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size=queue.size();
			Node<BinaryTreeNode<Integer>> head=null;
			Node<BinaryTreeNode<Integer>> rear=null;
			for(int i=0;i<size;i++) {
				BinaryTreeNode<Integer> nodeFront=queue.remove();
				if(head==null) {
				head=new Node(nodeFront);
				rear=head;
				}else {
				rear.next=new Node(nodeFront);
				rear=rear.next;
			}
				if(nodeFront.left!=null)
				queue.add(nodeFront.left);
				if(nodeFront.right!=null)
				queue.add(nodeFront.right);
		}
			arrayList.add(head);
	}	
		return arrayList;		
	}
	
	
	public static void printZigZag(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		Queue<BinaryTreeNode<Integer>> queue=new LinkedList();
		queue.add(root);
		int count=0;
		while(!queue.isEmpty()) {
			int size=queue.size();
			String p="";
			for(int i=0;i<size;i++) {
				BinaryTreeNode<Integer> frontNode=queue.remove();
				if(count%2==0)
				p=p+frontNode.data+" ";
				if(count%2!=0)
					p=frontNode.data+" "+p;
				if(frontNode.left!=null)
					queue.add(frontNode.left);
				if(frontNode.right!=null){
					queue.add(frontNode.right);
				}
				
			}
			System.out.println(p);
			count++;
		}
		
	}
	
	
	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		if(root.left==null && root.right!=null ) {
			System.out.println(root.right.data);
			printNodesWithoutSibling(root.right);
		}else if(root.left!=null && root.right==null) {
			System.out.println(root.left.data);
			printNodesWithoutSibling(root.left);
		}
	}
	
	public static void main(String[] args) {
		// BinaryTreeNode<Integer> root=takeInput();
		// print(root);
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		printLevelWise2(root);
		System.out.println("No of Nodes " + countNodes(root));
		//System.out.println("Is Node present :" + isNodePresent(root, 9));
		System.out.println(findNode(root, 8).toString());
		System.out.println("Height of tree"+heightOfTree(root));
		System.out.println("*************printLevelWise************");
		printLevelWise(root);
		//System.out.println("************Mirror**********");
		//mirrorABinaryTree(root);
		printLevelWise(root);
		
		System.out.println("Diameter of Tree approach old"+DiameterOfBinaryTreeApprocach1(root));
		
		System.out.println("Diameter of tree new"+diameterOfTree(root).diameter);
		
		System.out.println("***********PreOrder**************");
		preOrderTraversal(root);
		System.out.println();
		System.out.println("***********PostOrder**************");
		postOrderTraversal(root);
		System.out.println();
		System.out.println("********InOrder*******");
		inOrderTraversal(root);

		int[] preOrder= {1,2,4,8,9,5,3,6,7};
		int[] inOrder= {8,4,9,2,5,1,6,3,7};
		int[] postOrder= {8,9,4,5,2,6,7,3,1};
		//BinaryTreeNode<Integer> newRoot=constructFromPreOrderAndInorder(preOrder, inOrder);
		//System.out.println();
		//System.out.println("*************printLevelWise************");
		//printLevelWise(newRoot);

		System.out.println();
		System.out.println("*************printLevelWise************");
		BinaryTreeNode<Integer> newRoot=getTreeFromPostorderAndInorder(postOrder, inOrder);
		printLevelWise(newRoot);
		System.out.println("SumOFNodes " +sumOfNodes(root) );
		System.out.println("Is the tree balanced "+checkBalanced(root));
	
	//	System.out.println("****Remove leaf Nodes*****");
	//	printLevelWise(removeLeafNodes(root));
		
/*		System.out.println("**LinkedList From Tree**");
		ArrayList<Node<BinaryTreeNode<Integer>>> arrayList =LLForEachLevel(root);
		for(Node<BinaryTreeNode<Integer>> node:arrayList) {
			Node<BinaryTreeNode<Integer>> temp=node;
			while(temp!=null) {
				System.out.print(temp.data.data);
				temp=temp.next;
			}
			System.out.println();
		}
*/		
		
		System.out.println("*******ZigZag traversal********");
		printZigZag(root);
		
		System.out.println("*******ZigZagTraversalUsing2Stack**********");
		printZigZagUsing2Stacks(root);
	
	}
}
