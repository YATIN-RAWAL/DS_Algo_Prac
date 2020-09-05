import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {

	public static TreeNode<Integer> takeInput() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter root : ");
		TreeNode<Integer> root = new TreeNode(input.nextInt());

		System.out.println("Enter number Of childern for this : ");
		int nChild = input.nextInt();
		for (int i = 0; i < nChild; i++) {
			TreeNode<Integer> child = takeInput();
			root.children.add(child);
		}
		return root;
	}

	public static void print(TreeNode<Integer> root) {
		String p = root.data + ": ";
		for (int i = 0; i < root.children.size(); i++) {
			p = p + root.children.get(i).data + ",";
		}

		System.out.println(p);
		for (int i = 0; i < root.children.size(); i++) {
			print(root.children.get(i));
		}

	}

	public static TreeNode<Integer> inputLevelWise() {
		Scanner input = new Scanner(System.in);
		Queue<TreeNode<Integer>> queue = new LinkedList();
		System.out.println("Enter root: ");
		int data = input.nextInt();
		TreeNode<Integer> root = new TreeNode(data);
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode nodeFront = queue.remove();
			System.out.println("Enter number of children for : " + nodeFront.data);
			int nChild = input.nextInt();
			for (int i = 0; i < nChild; i++) {
				System.out.println("Enter " + (i + 1) + " child : ");
				int nChildData = input.nextInt();
				TreeNode<Integer> child = new TreeNode(nChildData);
				nodeFront.children.add(child);
				queue.add(child);
			}
		}
		return root;
	}

	public static int noOfNodes(TreeNode<Integer> root) {
		int count = 1;
		if (root == null) {
			return 0;
		}
		for (int i = 0; i < root.children.size(); i++) {
			count = count + noOfNodes(root.children.get(i));
		}

		return count;

	}

	public static void printLevelWise(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> queue = new LinkedList();
		queue.add(root);
		int size;
		while (!queue.isEmpty()) {
			size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode<Integer> nodeFront = queue.remove();
				System.out.print(nodeFront.data + " ");
				for (int j = 0; j < nodeFront.children.size(); j++) {
					queue.add(nodeFront.children.get(j));
				}
			}
			System.out.println();

		}
	}

	public static int sumOfNodes(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int sum = root.data;
		for (int i = 0; i < root.children.size(); i++) {
			sum = sum + sumOfNodes(root.children.get(i));
		}

		return sum;
	}

	public static int NodeWithTheLargestData(TreeNode<Integer> root) {
		int largest = root.data;
		for (int i = 0; i < root.children.size(); i++) {
			int a = NodeWithTheLargestData(root.children.get(i));
			largest = largest > a ? largest : a;
		}
		return largest;
	}

	public static int NoOfNodesGreaterThanX(TreeNode<Integer> root, int x) {
		int count = 0;
		if (root == null) {
			return count;
		}
		if (root.data > x) {
			count++;
		}
		for (int i = 0; i < root.children.size(); i++) {
			count = count + NoOfNodesGreaterThanX(root.children.get(i), x);
		}

		return count;

	}

	public static int height(TreeNode<Integer> root) {
		int height = 0;
		int childHeight = 0;
		if (root == null) {
			return height;
		}
		height++;
		for (int i = 0; i < root.children.size(); i++) {
			int tempChildHeight = height(root.children.get(i));
			childHeight = tempChildHeight > childHeight ? tempChildHeight : childHeight;
		}
		height = height + childHeight;

		return height;

	}

	public static int depthOfANode(TreeNode<Integer> root, int nodeDataToBeFound) {
		int depth = -1;
		if (root == null) {
			return depth;
		} else if (root.data == nodeDataToBeFound) {
			depth = 0;
			return depth;
		} else {
			int depthFromChild;
			for (int i = 0; i < root.children.size(); i++) {
				depthFromChild = depthOfANode(root.children.get(i), nodeDataToBeFound);
				if (depthFromChild != -1) {
					depth = 1 + depthFromChild;
					break;
				}
			}
		}
		return depth;
	}

	public static void printAtKDepth(TreeNode<Integer> root, int k) {
		if (root == null) {
			System.out.println("Null root");
			return;
		}
		if (k == 0) {
			System.out.print(root.data + " ");
			return;
		}
		for (int i = 0; i < root.children.size(); i++) {
			printAtKDepth(root.children.get(i), k - 1);
		}
	}

	public static int countLeafNodes(TreeNode<Integer> root) {
		int leafNode = 0;
		if (root == null) {
			return leafNode;
		}
		if (root.children.size() == 0) {
			leafNode++;
			return leafNode;
		}
		for (int i = 0; i < root.children.size(); i++) {
			leafNode = leafNode + countLeafNodes(root.children.get(i));
		}
		return leafNode;
	}

	public static void printPreOrder(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		for (int i = 0; i < root.children.size(); i++) {
			printPreOrder(root.children.get(i));
		}
	}

	public static void printPostOrder(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		if (root.children.size() == 0) {
			System.out.print(root.data + " ");
			return;
		} else {
			for (int i = 0; i < root.children.size(); i++) {
				printPostOrder(root.children.get(i));
			}
			System.out.print(root.data + " ");
		}

	}

	public static boolean isPresent(TreeNode<Integer> root, int x) {
		boolean result = false;
		boolean childResult = false;
		if (root == null) {
			return result;
		}
		if (root.data == x) {
			return true;
		} else {
			for (int i = 0; i < root.children.size(); i++) {
				childResult = isPresent(root.children.get(i), x);
				if (childResult == true) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static Pair<Integer> maxSumChildPlusParent(TreeNode<Integer> root) {
		int maxSum = 0;
		Pair<Integer> pair = new Pair();
		if (root == null) {
			return pair;
		}
		maxSum = root.data;
		for (int i = 0; i < root.children.size(); i++) {
			maxSum = maxSum + root.children.get(i).data;
		}
		pair.NodeWithMax = root;
		pair.sum = maxSum;
		for (int i = 0; i < root.children.size(); i++) {
			Pair<Integer> childPair = maxSumChildPlusParent(root.children.get(i));
			if (pair.sum < childPair.sum) {
				pair.NodeWithMax = childPair.NodeWithMax;
				pair.sum = childPair.sum;
			}
		}
		return pair;
	}

	public static boolean structurallyIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
		boolean result = false;
		if (root1 == null && root2 == null) {
			return true;
		} else if ((root1 != null && root2 == null) || (root1 == null && root2 != null)) {
			return false;
		}
		if (root1.data != root2.data || root1.children.size() != root2.children.size()) {
			return result;
		} else {
			result = true;
			for (int i = 0; i < root1.children.size(); i++) {
				result = result && structurallyIdentical(root1.children.get(i), root2.children.get(i));
			}
		}
		return result;
	}

	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {
		TreeNode<Integer> result = null;
		TreeNode<Integer> childResult = null;
		if (root == null) {
			return result;
		}
		if (root.data > n) {
			result = root;
		}
		for (int i = 0; i < root.children.size(); i++) {
			childResult = findNextLargerNode(root.children.get(i), n);
			if (childResult != null && result != null) {
				result = (result.data < childResult.data) ? result : childResult;
			} else if (childResult != null) {
				result = childResult;
			}
		}
		return result;
	}

	public static LargestPair<Integer> findSecondLargestNode(TreeNode<Integer> root) {
		LargestPair<Integer> largestPair = null;
		LargestPair<Integer> childPair = null;
		if (root == null) {
			return null;
		}
		if (root.children.size() == 0) {
			return new LargestPair(root, null);
		}

		largestPair = new LargestPair(root, null);

		for (int i = 0; i < root.children.size(); i++) {
			childPair = findSecondLargestNode(root.children.get(i));
			if (childPair != null) {
				if (largestPair.largest.data > childPair.largest.data) {
					if (largestPair.secondLargest != null && largestPair.secondLargest.data > childPair.largest.data) {
						continue;
					} else {
						largestPair.secondLargest = childPair.largest;
					}
				} else if (largestPair.largest.data < childPair.largest.data) {
					if(childPair.secondLargest!=null){
						if (largestPair.largest.data < childPair.secondLargest.data) {

							largestPair.secondLargest = childPair.secondLargest;
							largestPair.largest = childPair.largest;
						}else {
							largestPair.secondLargest=largestPair.largest;
							largestPair.largest=childPair.largest;
								
						}
					}else {
						largestPair.secondLargest=largestPair.largest;
						largestPair.largest=childPair.largest;
					}

				}else if(largestPair.largest.data==childPair.largest.data) {
					if(childPair.secondLargest!=null && largestPair.secondLargest!=null) {
						largestPair.secondLargest=largestPair.secondLargest.data>childPair.secondLargest.data?largestPair.secondLargest:childPair.secondLargest;
					}else {
						if(largestPair.secondLargest==null) {
							largestPair.secondLargest=childPair.secondLargest;
						}
					}
				}
			}
		}
		return largestPair;

	}
	
	
	
	public static void replaceWithDepthValue(TreeNode<Integer> root){
		if(root==null) {
			return;
		}
		replaceWithDepthValues(root,0);
	}
	
	
	public static void replaceWithDepthValues(TreeNode<Integer>root,int k) {
		root.data=k;
		for(int i=0;i<root.children.size();i++) {
			replaceWithDepthValues(root.children.get(i),k+1);
		}
		return;
	}
	
	
	public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root){
		if(root==null || root.children.size()==0) {
			return null;
		}
		
		for(int i=0;i<root.children.size();i++) {
			TreeNode<Integer> childRootNode=removeLeafNodes(root.children.get(i));
			if(childRootNode==null) {
				root.children.remove(i);
				i--;
			}else {
			root.children.set(i, childRootNode);	
			}
		}

		return root;
	}


	public static void main(String[] args) {
		TreeNode<Integer> root = inputLevelWise();
		System.out.println("*****************************");
		// TreeNode<Integer> root2 = inputLevelWise();
		printLevelWise(root);
/*		System.out.println("No Of Nodes " + noOfNodes(root));
		System.out.println("sum of nodes " + sumOfNodes(root));
		System.out.println("Largestelement " + NodeWithTheLargestData(root));
		System.out.println("No of elements greater than 6" + NoOfNodesGreaterThanX(root, 6));
		System.out.println("Height of Tree " + height(root));
		System.out.println("Depth of a node " + depthOfANode(root, 12));
		System.out.println("**********Print all elements at depth*************");
		printAtKDepth(root, 3);
		System.out.println();
		System.out.println("No of leaf Nodes" + countLeafNodes(root));
		System.out.println("********PrintPreOrder**********");
		printPreOrder(root);
		System.out.println();
		System.out.println("***********PostOrder***************");
		printPostOrder(root);
		System.out.println();
		System.out.println("**********isPresent***********");
		System.out.println(isPresent(root, 55));

		System.out.println("Node with max sum" + maxSumChildPlusParent(root).NodeWithMax.data);

*/		// System.out.println(structurallyIdentical(root,root2));

		// System.out.println("Next larger node "+findNextLargerNode(root,21).data);

/*		System.out.println("Second largest Node " + findSecondLargestNode(root).secondLargest.data);
		
		System.out.println("******* replace with depth value*******");
		replaceWithDepthValue(root);
		printLevelWise(root);
*/		
		TreeNode<Integer> rootNew= removeLeafNodes(root);

		printLevelWise(rootNew);
	}

}
