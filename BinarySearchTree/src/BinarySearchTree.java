import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

	BinaryTreeNode<Integer> root;

	BinarySearchTree(BinaryTreeNode<Integer> root) {
		this.root = root;
	}

	BinarySearchTree() {

	}

	public BinaryTreeNode<Integer> search(BinaryTreeNode<Integer> root, int k) {
		BinaryTreeNode<Integer> searched = null;
		if (root == null) {
			return searched;
		}
		if (root.data == k) {
			return root;
		}
		if (k > root.data) {
			searched = search(root.right, k);
		} else {
			searched = search(root.left, k);
		}

		return searched;
	}

	public void printNodeFromK1ToK2(BinaryTreeNode<Integer> root, int k1, int k2) {
		if (root == null) {
			return;
		}
		int greater = k1 >= k2 ? k1 : k2;
		int smaller = k1 < k2 ? k1 : k2;
		if (smaller <= root.data && root.data <= greater) {
			System.out.print(root.data + " ");
			printNodeFromK1ToK2(root.left, k1, k2);
			printNodeFromK1ToK2(root.right, k1, k2);
		}
		if (root.data > greater) {
			printNodeFromK1ToK2(root.left, k1, k2);
		}
		if (root.data < smaller) {
			printNodeFromK1ToK2(root.right, k1, k2);
		}
	}

	public boolean isBST(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return true;
		}
		BinaryTreeNode<Integer> minimumNodeRight = minimumValueNode(root.right);
		BinaryTreeNode<Integer> maximumNodeLeft = maxValueNode(root.left);
		if (root.data < maximumNodeLeft.data || root.data > minimumNodeRight.data) {
			return false;
		}

		return (isBST(root.left)) && (isBST(root.right));
	}

	public BinaryTreeNode<Integer> minimumValueNode(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> result = new BinaryTreeNode(Integer.MAX_VALUE);
		if (root == null) {
			return result;
		}
		result = root;
		BinaryTreeNode<Integer> childResult = minimumValueNode(root.left);
		result = result.data < childResult.data ? result : childResult;
		return result;
	}

	public BinaryTreeNode<Integer> maxValueNode(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> result = new BinaryTreeNode<Integer>(Integer.MIN_VALUE);
		if (root == null) {
			return result;
		}
		result = root;
		BinaryTreeNode<Integer> childResult = maxValueNode(root.right);
		result = result.data > childResult.data ? result : childResult;
		return result;
	}

	public MinMaxIsBst isBSTApproach2(BinaryTreeNode<Integer> root) {
		MinMaxIsBst result = new MinMaxIsBst();
		if (root == null) {
			result.minimumRightNode = new BinaryTreeNode<Integer>(Integer.MAX_VALUE);
			result.maximumLeftNode = new BinaryTreeNode<Integer>(Integer.MIN_VALUE);
			result.isBST = true;
			return result;
		}

		MinMaxIsBst leftChild = isBSTApproach2(root.left);
		MinMaxIsBst rightChild = isBSTApproach2(root.right);

		if (root.data < leftChild.maximumLeftNode.data || root.data > rightChild.minimumRightNode.data) {
			result.isBST = false;
		} else {
			result.isBST = leftChild.isBST && rightChild.isBST;
		}
		BinaryTreeNode<Integer> temp = (leftChild.minimumRightNode.data < rightChild.minimumRightNode.data
				? leftChild.minimumRightNode
				: rightChild.minimumRightNode);
		result.minimumRightNode = root.data < temp.data ? root : temp;
		BinaryTreeNode<Integer> tempM = leftChild.maximumLeftNode.data > rightChild.maximumLeftNode.data
				? leftChild.maximumLeftNode
				: rightChild.maximumLeftNode;
		result.maximumLeftNode = root.data > tempM.data ? root : tempM;
		return result;
	}

	public Pair<Boolean, Pair<Integer, Integer>> isBSTApproach2_Attempt2(BinaryTreeNode<Integer> root) {
		Pair<Boolean, Pair<Integer, Integer>> output = new Pair();
		output.second = new Pair();
		if (root == null) {
			output.first = true;
			output.second.first = Integer.MIN_VALUE;
			output.second.second = Integer.MAX_VALUE;
			return output;
		}
		Pair<Boolean, Pair<Integer, Integer>> leftChild = isBSTApproach2_Attempt2(root.left);
		Pair<Boolean, Pair<Integer, Integer>> rightChild = isBSTApproach2_Attempt2(root.right);
		output.second.first = Math.max(root.data, Math.max(leftChild.second.first, rightChild.second.first));
		output.second.second = Math.min(root.data, Math.min(leftChild.second.second, rightChild.second.second));
		if (root.data > rightChild.second.second || root.data < leftChild.second.first) {
			output.first = false;
		} else {
			output.first = leftChild.first && rightChild.first;
		}
		return output;
	}

	public boolean isBST_Approach3(BinaryTreeNode<Integer> root, int small, int great) {
		if (root == null) {
			return true;
		}
		if (root.data < small || root.data > great) {
			return false;
		}
		return isBST_Approach3(root.left, small, root.data - 1) && isBST_Approach3(root.right, root.data, great);
	}

	public BinaryTreeNode<Integer> SortedArrayToBST(int[] arr) {
		return SortedArrayToBST(arr, 0, arr.length - 1);
	}

	public BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int startIndex, int endIndex) {
		if (arr.length == 0 || startIndex > endIndex) {
			return null;
		}
		if (arr.length == 1 || startIndex == endIndex) {
			return new BinaryTreeNode(arr[startIndex]);
		}
		int mid = (startIndex + endIndex) / 2;
		BinaryTreeNode<Integer> tempRoot = new BinaryTreeNode<Integer>(arr[mid]);
		tempRoot.left = SortedArrayToBST(arr, startIndex, mid - 1);
		tempRoot.right = SortedArrayToBST(arr, mid + 1, endIndex);
		return tempRoot;
	}

	public Pair<Node<Integer>, Node<Integer>> BSTToSortedLinkedList(BinaryTreeNode<Integer> root) {
		Pair<Node<Integer>, Node<Integer>> output = new Pair();
		if (root == null) {
			return null;
		}
		Node<Integer> rootLL = new Node(root.data);
		Pair<Node<Integer>, Node<Integer>> leftChildLL = BSTToSortedLinkedList(root.left);
		Pair<Node<Integer>, Node<Integer>> rightChildLL = BSTToSortedLinkedList(root.right);
		if (leftChildLL != null) {
			leftChildLL.second.next = rootLL;
			output.first = leftChildLL.first;
		} else {
			output.first = rootLL;
		}
		if (rightChildLL != null) {
			rootLL.next = rightChildLL.first;
			output.second = rightChildLL.second;
		} else {
			output.second = rootLL;
		}
		return output;
	}

	public ArrayList<Integer> elementToRoot(BinaryTreeNode<Integer> root, int data) {
		ArrayList<Integer> output;
		if (root == null) {
			return null;
		}
		if (root.data == data) {
			output = new ArrayList<>();
			output.add(data);
			return output;
		}
		if (data > root.data) {
			output = elementToRoot(root.right, data);
		} else {
			output = elementToRoot(root.left, data);
		}
		if (output == null) {
			return output;
		} else {
			output.add(root.data);
		}
		return output;
	}

	public boolean isPresent(int data) {
		if (root == null) {
			return false;
		}
		return isPresentHelper(root, data);

	}

	public boolean isPresentHelper(BinaryTreeNode<Integer> root, int data) {
		if (root == null) {
			return false;
		}
		if (root.data == data) {
			return true;
		}
		if (data > root.data) {
			return isPresentHelper(root.right, data);
		}
		return isPresentHelper(root.left, data);
	}

	public BinaryTreeNode<Integer> insertElement(int data) {
		return insertElementHelper(root, data);
	}

	public BinaryTreeNode<Integer> insertElementHelper(BinaryTreeNode<Integer> root, int data) {
		if (root == null) {
			return new BinaryTreeNode<Integer>(data);
		}
		if (data >= root.data) {
			root.right = insertElementHelper(root.right, data);
		} else {
			root.left = insertElementHelper(root.left, data);
		}
		return root;
	}

	public void printTree() {
		printTree(root);
	}

	public void printTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		String p = root.data + ":";
		if (root.left != null) {
			p = p + "L" + root.left.data + ",";
		}
		if (root.right != null) {
			p = p + "R" + root.right.data;
		}
		System.out.println(p);
		if (root.left != null)
			printTree(root.left);
		if (root.right != null)
			printTree(root.right);
	}

	public BinaryTreeNode<Integer> deleteNode(int data) {
		return deleteNode(root, data);
	}

	public BinaryTreeNode deleteNode(BinaryTreeNode<Integer> root, int data) {
		if (root == null) {
			return null;
		}
		if (data > root.data) {
			root.right = deleteNode(root.right, data);
			return root;
		}
		if (data < root.data) {
			root.left = deleteNode(root.left, data);
			return root;
		}

		if (root.data == data && root.left == null && root.right == null) {
			return null;
		} else if (root.data == data && root.left == null && root.right != null) {
			return root.right;
		} else if (root.data == data && root.left != null && root.right == null) {
			return root.left;
		} else if (root.data == data && root.left != null && root.right != null) {
			BinaryTreeNode<Integer> minimumRightVaue = minimumValueNode(root.right);
			root.data = minimumRightVaue.data;
			root.right = deleteNode(root.right, minimumRightVaue.data);
		}
		return root;
	}

	public void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		root = insertDuplicateNodes(root);
	}

	public BinaryTreeNode<Integer> insertDuplicateNodes(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		BinaryTreeNode<Integer> leftNodetemp = null;
		BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<Integer>(root.data);
		leftNodetemp = root.left;
		root.left = leftNode;
		leftNode.left = insertDuplicateNodes(leftNodetemp);
		root.right = insertDuplicateNodes(root.right);
		return root;
	}

	public BinaryTreeNode<Integer> LCAOFBinaryTree(BinaryTreeNode<Integer> root, int n1, int n2) {
		if (root == null) {
			return null;
		}
		if (root.data == n1 || root.data == n2) {
			return root;
		}

		BinaryTreeNode<Integer> leftChild = LCAOFBinaryTree(root.left, n1, n2);
		BinaryTreeNode<Integer> rightChild = LCAOFBinaryTree(root.right, n1, n2);
		if (leftChild == null || rightChild == null) {
			return leftChild == null ? rightChild : leftChild;
		}
		return root;

	}

	public BinaryTreeNode<Integer> LCAOFBST(BinaryTreeNode<Integer> root, int n1, int n2) {
		if (root == null) {
			return null;
		}
		if (root.data == n1 || root.data == n2) {
			return root;
		}

		if (n1 < root.data && n2 < root.data) {
			return LCAOFBST(root.left, n1, n2);
		}
		if (n1 > root.data && n2 > root.data) {
			return LCAOFBST(root.right, n1, n2);
		}
		BinaryTreeNode<Integer> leftChild = LCAOFBST(root.left, n1, n2);
		BinaryTreeNode<Integer> rightChild = LCAOFBST(root.right, n1, n2);
		if (leftChild == null || rightChild == null) {
			return leftChild == null ? rightChild : leftChild;
		}
		return root;

	}

	public void pairSum(BinaryTreeNode<Integer> root, int sum) {
		Object[] arrayFromBST = binaryTreeNodeToArray(root).toArray();
		Arrays.sort(arrayFromBST);
		int startIndex = 0;
		int endIndex = arrayFromBST.length - 1;
		while (startIndex < arrayFromBST.length - 1) {
			if (endIndex > startIndex) {
				if ((Integer) arrayFromBST[startIndex] + (Integer) arrayFromBST[endIndex] > sum) {
					endIndex--;
				} else if ((Integer) arrayFromBST[startIndex] + (Integer) arrayFromBST[endIndex] < sum) {
					startIndex++;
					endIndex = arrayFromBST.length - 1;
				} else {
					System.out.println(
							"Pair: " + (Integer) arrayFromBST[startIndex] + " " + (Integer) arrayFromBST[endIndex]);
					endIndex--;
				}
			} else {
				endIndex = arrayFromBST.length - 1;
				startIndex = startIndex + 1;
			}
		}
	}

	public ArrayList<Integer> binaryTreeNodeToArray(BinaryTreeNode<Integer> root) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		if (root == null) {
			return null;
		}
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> nodeFront = queue.remove();
			output.add(nodeFront.data);
			if (nodeFront.left != null) {
				queue.add(nodeFront.left);
			}
			if (nodeFront.right != null) {
				queue.add(nodeFront.right);
			}
		}

		return output;
	}

	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		printIfSum(root, k, 0, "");
	}

	public static void printIfSum(BinaryTreeNode<Integer> root, int k, int sumTillNode, String tillNow) {
		if (root == null) {
			return;
		}
		sumTillNode = sumTillNode + root.data;
		tillNow = tillNow + " " + root.data;
		if (root.left == null && root.right == null && sumTillNode == k) {
			System.out.println(tillNow);
		}
		printIfSum(root.left, k, sumTillNode, tillNow);
		printIfSum(root.right, k, sumTillNode, tillNow);

	}

	public int heightOflargestBSTSubtreeOFBianryTree(BinaryTreeNode<Integer> root) {
		return heightLargestBST(root).first;
	}

	public Pair<Integer, Pair<Integer, Integer>> heightLargestBST(BinaryTreeNode<Integer> root) {
		Pair<Integer, Pair<Integer, Integer>> output = new Pair();
		output.second = new Pair();
		if (root == null) {
			output.first = 0;
			output.second.first = Integer.MIN_VALUE;
			output.second.second = Integer.MAX_VALUE;
			return output;
		}
		int height;
		Pair<Integer, Pair<Integer, Integer>> leftSubTree = heightLargestBST(root.left);
		Pair<Integer, Pair<Integer, Integer>> rightSubTree = heightLargestBST(root.right);
		height = Math.max(leftSubTree.first, rightSubTree.first);
		if (root.data > leftSubTree.second.first && root.data <= rightSubTree.second.second) {
			height = 1 + height;
			output.first = height;
			output.second.first = Math.max(root.data, Math.max(leftSubTree.second.first, rightSubTree.second.first));
			output.second.second = Math.min(root.data, Math.min(leftSubTree.second.second, rightSubTree.second.second));
			return output;
		}

		output.first = height;
		output.second.first = Math.max(leftSubTree.second.first, rightSubTree.second.first);
		output.second.second = Math.min(leftSubTree.second.second, rightSubTree.second.second);
		return output;
	}

	public void replaceWithSumOFGreaterNodes(BinaryTreeNode<Integer> root) {
		replaceWithSumOFGreaterNodes(root, 0);
	}

	public int replaceWithSumOFGreaterNodes(BinaryTreeNode<Integer> root, int currentSum) {
		if (root == null) {
			return currentSum;
		}
		int rightSum = replaceWithSumOFGreaterNodes(root, currentSum);
		currentSum = root.data + rightSum;
		root.data = currentSum;
		int leftSum = replaceWithSumOFGreaterNodes(root, currentSum);
		return leftSum;
	}

	public void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
		distanceFromRoot(root, node, k);
	}

	public int distanceFromRoot(BinaryTreeNode<Integer> root, int node, int k) {
		if (root == null) {
			return -1;
		}
		if (root.data == node) {
			printAllNodesAtDepth(root, k);
			return 0;
		}

		int leftDistance = distanceFromRoot(root.left, node, k);
		if (leftDistance != -1) {
			leftDistance = leftDistance + 1;
			if (leftDistance == k) {
				System.out.println(root.data);
			} else {
				printAllNodesAtDepth(root.right, k - leftDistance - 1);
				return leftDistance;
			}
		}
		int rightDistance = distanceFromRoot(root.right, node, k);
		if (rightDistance != -1) {
			rightDistance = rightDistance + 1;
			if (rightDistance == k) {
				System.out.println(root.data);
			} else {
				printAllNodesAtDepth(root.left, k - rightDistance - 1);
				return rightDistance;
			}
		}
		return -1;
	}

	public static void printAllNodesAtDepth(BinaryTreeNode<Integer> root, int k) {
		if (root == null) {
			return;
		}
		if (k == 0) {
			System.out.println(root.data);
		}
		printAllNodesAtDepth(root.left, k - 1);
		printAllNodesAtDepth(root.right, k - 1);
	}

	// space complexity log n
	public static void printNodesSumTOS(BinaryTreeNode<Integer> root, int sum) {
		if (root == null) {
			return;
		}
		int totalNodes = countNodes(root);
		int traversedNodes = 0;
		Stack<BinaryTreeNode<Integer>> stackInOrder = new Stack();
		Stack<BinaryTreeNode<Integer>> stackInOrderReverse = new Stack();
		BinaryTreeNode<Integer> temp = root;
		while (temp != null) {
			stackInOrder.push(temp);
			temp = temp.left;
		}
		temp = root;
		while (temp != null) {
			stackInOrderReverse.push(temp);
			temp = temp.right;
		}
		while (traversedNodes < totalNodes-1) {
			BinaryTreeNode<Integer> top1 = stackInOrder.peek();
			BinaryTreeNode<Integer> top2 = stackInOrderReverse.peek();
			if (top1.data + top2.data == sum) {
				System.out.println(top1.data + " " + top2.data);
				BinaryTreeNode<Integer> top = top1;
				stackInOrder.pop();
				traversedNodes++;
				top = top.right;
				while (top != null) {
					stackInOrder.push(top);
					top = top.left;
				}

				top = top2.left;
				stackInOrderReverse.pop();
				traversedNodes++;
				while(top!=null) {
					stackInOrderReverse.push(top);
					top=top.right;
				}
			}else if(top1.data+top2.data>sum) {
				BinaryTreeNode<Integer> top=top2;
				stackInOrderReverse.pop();
				traversedNodes++;
				top=top.left;
				while(top!=null) {
					stackInOrderReverse.push(top);
					top=top.right;
				}
			}else {
				BinaryTreeNode<Integer> top=top1;
				stackInOrder.pop();
				traversedNodes++;
				top=top.right;
				while(top!=null) {
					stackInOrder.push(top);
					top=top.left;
				}
			}
			

		}

	}

	public static int countNodes(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int count = 1;
		count = count + countNodes(root.right);
		count = count + countNodes(root.left);
		return count;
	}

	
	
	public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
		boolean isPFound;
		boolean isQFound;
		if(root==null) {
			return false;
		}
		
		Queue<BinaryTreeNode<Integer>> queue=new LinkedList();
		queue.add(root);
		while(!queue.isEmpty()) {
			isPFound=false;
			isQFound=false;

			BinaryTreeNode<Integer> nodeFront;
			int size=queue.size();
			for(int i=0;i<size;i++) {
				nodeFront=queue.remove();
				if(nodeFront.left!=null) {
					queue.add(nodeFront.left);
				}
				if(nodeFront.right!=null) {
					queue.add(nodeFront.right);
				}
				if(nodeFront.data==p) {
					isPFound=true;
				}
				if(nodeFront.data==q) {
					isQFound=true;
				}
			}
			
			if(isPFound==true && isQFound==true) {
				return true;
			}
			
					
		}
		
		return false;
	}
	
	
	
	public ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
		ArrayList<Integer> output=new ArrayList<Integer>();
		ArrayList<Integer> leftChildOutput=null;
		ArrayList<Integer> rightChildOutput=null;
		if(root==null) {
			return output;
		}
		
		if(root.left==null && root.right==null) {
			output.add(root.data);
			return output;
		}
		leftChildOutput=longestRootToLeafPath(root.left);
		rightChildOutput=longestRootToLeafPath(root.right);
		output=leftChildOutput.size()>rightChildOutput.size()?leftChildOutput:rightChildOutput;
		output.add(root.data);
		return output;
	}
	

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeNode.takeInputLevelWise();
		BinarySearchTree bst = new BinarySearchTree(root);

		/*
		 * int elemnetToBeSearched=2;
		 * System.out.print("elementToBe searched"+elemnetToBeSearched);
		 * System.out.println("*****Element Found******"+bst.search(root,
		 * elemnetToBeSearched).data);
		 * System.out.println("*****Elements in range**********");
		 * bst.printNodeFromK1ToK2(root, 6, 10); System.out.println();
		 * System.out.println(" Minimum: "+bst.minimumValueNode(root).data);
		 * System.out.println("Maximum value "+bst.maxValueNode(root).data); MinMaxIsBst
		 * result= bst.isBSTApproach2(root); System.out.println("Is BianrySearchTree" +
		 * result.isBST); Pair<Boolean,Pair<Integer,Integer>>
		 * result_approach2=bst.isBSTApproach2_Attempt2(root);
		 * System.out.println("Is BST : "+result_approach2.first + " min value "+
		 * result_approach2.second.second+" max_value "+result_approach2.second.first);
		 * System.out.println("Is BST :"+bst.isBST_Approach3(root, Integer.MIN_VALUE,
		 * Integer.MAX_VALUE));
		 */
		/*
		 * Scanner input= new Scanner (System.in); String inputString=input.nextLine();
		 * String[] stringArray=inputString.split(" "); int[] integerArray= new
		 * int[stringArray.length]; for(int i=0;i<stringArray.length;i++) {
		 * integerArray[i]=Integer.parseInt(stringArray[i]); } BinarySearchTree
		 * binarySearchTree= new BinarySearchTree(); BinaryTreeNode<Integer>
		 * binaryTreeRoot=binarySearchTree.SortedArrayToBST(integerArray);
		 * BinaryTreeNode.printLevelwise(binaryTreeRoot);
		 */
		/*
		 * Pair<Node<Integer>,Node<Integer>> output=bst.BSTToSortedLinkedList(root);
		 * Node<Integer> temp=output.first; while(temp!=null) {
		 * System.out.println(temp.data); temp=temp.next; }
		 */

		/*
		 * System.out.println("Path from node to root"); ArrayList<Integer>
		 * arrayList=bst.elementToRoot(root, 2);
		 * System.out.println(arrayList.toString());
		 */

//		System.out.println("Is present "+bst.isPresent(10));
		/*
		 * BinaryTreeNode<Integer> newRoot=bst.insertElement(12);
		 * BinaryTreeNode.printLevelwise(newRoot);
		 */
		/*
		 * BinaryTreeNode<Integer> newRoot2=bst.deleteNode(5);
		 * BinaryTreeNode.printLevelwise(newRoot2); BinarySearchTree bst2=new
		 * BinarySearchTree(newRoot2); bst2.printTree();
		 */
		/*
		 * bst.insertDuplicateNode(root); bst.printTree();
		 */
		/*
		 * BinaryTreeNode<Integer> ancestor=bst.LCAOFBinaryTree(root, 2, 6);
		 * System.out.println("Ancestor nOde: "+ancestor.data);
		 */
//		bst.pairSum(root, 4);
		// bst.rootToLeafPathsSumToK(root, 13);

//		System.out.println("heightOfLargestBST "+bst.heightOflargestBSTSubtreeOFBianryTree(root));

//		bst.printAllNodesAtDepth(root, 2);

//		bst.distanceFromRoot(root, 3, 1);
//		bst.printNodesSumTOS(root, 12);
		
		
//		System.out.println(bst.isCousin(root, 2, 9));

		System.out.println(Arrays.toString(bst.longestRootToLeafPath(root).toArray()));
	}

}
