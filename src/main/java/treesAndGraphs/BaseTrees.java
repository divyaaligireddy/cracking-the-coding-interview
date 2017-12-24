package treesAndGraphs;

public class BaseTrees {

	public static Node getBaseTree() {
		Node node13 = new Node("21", null);
		Node node11 = new Node("3", new Node[] { node13 });
		Node node14 = new Node("15", null);
		Node node12 = new Node("24", new Node[] { node14 });
		Node node21 = new Node("28", null);
		Node node23 = new Node("10", null);
		Node node24 = new Node("14", null);
		Node node22 = new Node("22", new Node[] { node23, node24 });
		Node node32 = new Node("44", null);
		Node node31 = new Node("34", new Node[] { node32 });
		Node node1 = new Node("16", new Node[] { node11, node12 });
		Node node2 = new Node("19", new Node[] { node21, node22 });
		Node node3 = new Node("13", new Node[] { node31 });
		Node[] children = new Node[] { node1, node2, node3 };
		Node root = new Node("7", children);

		/*
		 * Structure of the Base Tree 
		 *             7
		 *        /    |    \ 
		 *      16     19   13
		 *    /   \   /  \   | 
		 *   3   24  28 22   34 
		 *   |    |    /  \  | 
		 *  21   15   10 14  44
		 */
		return root;
	}

	public static BinaryTreeNode getBaseBinaryTree() {
		BinaryTreeNode node4 = new BinaryTreeNode(4, new BinaryTreeNode(8), new BinaryTreeNode(9));
		BinaryTreeNode node5 = new BinaryTreeNode(5, new BinaryTreeNode(10), new BinaryTreeNode(11));
		BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
		BinaryTreeNode node6 = new BinaryTreeNode(6, new BinaryTreeNode(12), new BinaryTreeNode(13));
		BinaryTreeNode node7 = new BinaryTreeNode(7, new BinaryTreeNode(14), new BinaryTreeNode(15));
		BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
		BinaryTreeNode root = new BinaryTreeNode(1, node2, node3);
		System.out.println("Inorder traversal of Binary Tree: ");
		printInOrderTree(root);
		return root;
	}

	public static BinaryTreeNode getBaseBST() {
		BinaryTreeNode node4 = new BinaryTreeNode(2, new BinaryTreeNode(1), new BinaryTreeNode(3));
		BinaryTreeNode node5 = new BinaryTreeNode(6, new BinaryTreeNode(5), new BinaryTreeNode(7));
		BinaryTreeNode node2 = new BinaryTreeNode(4, node4, node5);
		BinaryTreeNode node6 = new BinaryTreeNode(10, new BinaryTreeNode(9), new BinaryTreeNode(11));
		BinaryTreeNode node7 = new BinaryTreeNode(14, new BinaryTreeNode(13), new BinaryTreeNode(15));
		BinaryTreeNode node3 = new BinaryTreeNode(12, node6, node7);
		BinaryTreeNode root = new BinaryTreeNode(8, node2, node3);
		System.out.println("Inorder traversal of BST: ");
		printInOrderTree(root);
		return root;
	}

	public static void printInOrderTree(BinaryTreeNode root) {
		if (root == null)
			return;
		printInOrderTree(root.left);
		System.out.print(root.value + " ");
		printInOrderTree(root.right);

	}

	public static void main(String[] args) {
		System.out.println("\nIs BST?  " + checkIfBST(getBaseBinaryTree()));
		System.out.println();
		System.out.println("\nIs BST?  " + checkIfBST(getBaseBST()));
	}

	private static boolean checkIfBST(BinaryTreeNode node) {
		if (node != null) {
			if ((node.left != null && node.left.value > node.value)
					|| (node.right != null && node.value > node.right.value))
				return false;
			if (!checkIfBST(node.left) || !checkIfBST(node.right))
				return false;
		}
		return true;
	}
}
