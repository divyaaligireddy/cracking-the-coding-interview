package treesAndGraphs;

public class validateBST {

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
