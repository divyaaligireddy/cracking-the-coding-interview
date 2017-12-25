package treesAndGraphs;

/*4.4 Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
node never differ by more than one.
Hints:#27, #33, #49, #705, #724*/

public class CheckBalanced {

	public static void main(String[] args) {
		System.out.println("\nIs Balanced? " + isBalanced(BaseTrees.getBaseBinaryTree()));
		System.out.println("\nIs Balanced? " + isBalanced(getUnBalancedBinaryTree()));
	}

	public static BinaryTreeNode getUnBalancedBinaryTree() {
		BinaryTreeNode node8 = new BinaryTreeNode(8, new BinaryTreeNode(14), new BinaryTreeNode(15));
		BinaryTreeNode node4 = new BinaryTreeNode(4, node8, new BinaryTreeNode(9));
		BinaryTreeNode node5 = new BinaryTreeNode(5, new BinaryTreeNode(10), new BinaryTreeNode(11));
		BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
		BinaryTreeNode node6 = new BinaryTreeNode(6, new BinaryTreeNode(12), new BinaryTreeNode(13));
		BinaryTreeNode node3 = new BinaryTreeNode(3, node6, null);
		BinaryTreeNode root = new BinaryTreeNode(1, node2, node3);
		System.out.println("Inorder traversal of Binary Tree: ");
		BaseTrees.printInOrderTree(root);
		return root;
	}

	private static boolean isBalanced(BinaryTreeNode tree) {
		if (tree == null)
			return true;
		if (Math.abs(getHeight(tree.left) - getHeight(tree.right)) > 1)
			return false;
		else {
			return isBalanced(tree.left) && isBalanced(tree.right);
		}
	}

	private static int getHeight(BinaryTreeNode node) {
		if (node == null)
			return -1;
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}
}
