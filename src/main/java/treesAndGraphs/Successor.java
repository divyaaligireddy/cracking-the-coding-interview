package treesAndGraphs;

public class Successor {

	public static void main(String[] args) {
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		BinaryTreeNode node2 = new BinaryTreeNode(2, new BinaryTreeNode(1), node3);
		BinaryTreeNode node7 = new BinaryTreeNode(7);
		BinaryTreeNode node5 = new BinaryTreeNode(6, new BinaryTreeNode(5), node7);
		BinaryTreeNode node4 = new BinaryTreeNode(4, node2, node5);
		BinaryTreeNode node10 = new BinaryTreeNode(10, new BinaryTreeNode(9), new BinaryTreeNode(11));
		BinaryTreeNode node15 = new BinaryTreeNode(15);
		BinaryTreeNode node14 = new BinaryTreeNode(14, new BinaryTreeNode(13), node15);
		BinaryTreeNode node12 = new BinaryTreeNode(12, node10, node14);
		BinaryTreeNode root = new BinaryTreeNode(8, node4, node12);
		System.out.println("Inorder traversal of BST: ");
		BaseTrees.printInOrderTree(root);
		BinaryTreeNode successor = findSuccessor(node15);
		if (successor != null)
			System.out.println("\nNext node is " + successor.value);
		else
			System.out.println("\nThere is no successor.");
	}

	private static BinaryTreeNode findSuccessor(BinaryTreeNode node) {
		BinaryTreeNode parent = node.parent;
		BinaryTreeNode next = null;
		if (parent == null) {
			if (node.right != null) {
				if (node.right.left != null) {
					next = node.right.left;
					while (next.left != null) {
						next = next.left;
					}
				} else
					next = node.right;

			}
		} else if (parent.left == node) {
			next = parent;
		} else if (parent.right == node) {
			if (node.right != null)
				next = node.right;
			else {
				next = parent;
				while (next != null && next.value < node.value) {
					next = next.parent;
				}
			}
		}
		return next;

	}
}
