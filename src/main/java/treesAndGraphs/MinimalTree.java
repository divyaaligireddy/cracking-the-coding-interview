package treesAndGraphs;

/*4.2 Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
to create a binary search tree with minimal height.
Hints: #19, #73, #116
*/
public class MinimalTree {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		BinaryTreeNode binarySearchTree = formBinarySearchTree(arr, 0, arr.length - 1);
		System.out.println("\n\nInorder traversal of BST: ");
		BaseTrees.printInOrderTree(binarySearchTree);
	}

	private static BinaryTreeNode formBinarySearchTree(Integer[] arr, int startPosition, int endPosition) {
		if (endPosition < startPosition)
			return null;
		int rootValue = (startPosition + endPosition) / 2;
		System.out.print(arr[rootValue] + " ");
		BinaryTreeNode node = new BinaryTreeNode(arr[rootValue]);
		node.left = formBinarySearchTree(arr, startPosition, rootValue - 1);
		node.right = formBinarySearchTree(arr, rootValue + 1, endPosition);
		return node;
	}

}
