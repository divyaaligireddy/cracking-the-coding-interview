package treesAndGraphs;

/*4.5 Validate BST: Implement a function to check if a binary tree is a binary search tree.
Hints: #35, #57, #86, #113, #128
*/

public class ValidateBST {

	public static void main(String[] args) {
		System.out.println("\nIs BST? " + isBST(BaseTrees.getBaseBST()));
		System.out.println("\nBST? " + isBST(BaseTrees.getBaseBinaryTree()));
	}

	private static boolean isBST(BinaryTreeNode node) {
		if (node == null)
			return true;
		if (node.left != null && node.value < node.left.value)
			return false;
		if (node.right != null && node.value > node.right.value)
			return false;
		return isBST(node.left) && isBST(node.right);

	}

}
