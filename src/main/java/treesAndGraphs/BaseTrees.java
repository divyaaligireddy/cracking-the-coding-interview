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
		Node node1 = new Node("16", new Node[] { node11, node12, node13, node14 });
		Node node2 = new Node("19", new Node[] { node21, node22, node23, node24 });
		Node node3 = new Node("13", new Node[] { node31, node32 });
		Node[] children = new Node[] { node1, node2, node3 };
		Node root = new Node("7", children);

					/*
					 * Structure of the Base Tree
					 * 		  7
						/	  |		\
					   16    19		13
					 /  \	 /  \    |
					3	24  28  22   34
					|   |      / \   |
					21  15    10 14  44
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
		System.out.println("Inorder traversal");
		printInOrderTree(root);
		return root;
	}

	private static void printInOrderTree(BinaryTreeNode root) {
		if (root == null)
			return;
		printInOrderTree(root.left);
		System.out.print(root.value + " ");
		printInOrderTree(root.right);

	}
}
