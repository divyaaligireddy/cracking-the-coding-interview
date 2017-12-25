package treesAndGraphs;

public class FirstCommonAncestor {

	public static void main(String[] args) {
		BinaryTreeNode node8 = new BinaryTreeNode(8);
		BinaryTreeNode node9 = new BinaryTreeNode(9);
		BinaryTreeNode node4 = new BinaryTreeNode(4, node8, node9);
		BinaryTreeNode node5 = new BinaryTreeNode(5, new BinaryTreeNode(10), new BinaryTreeNode(11));
		BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
		BinaryTreeNode node6 = new BinaryTreeNode(6, new BinaryTreeNode(12), new BinaryTreeNode(13));
		BinaryTreeNode node7 = new BinaryTreeNode(7, new BinaryTreeNode(14), new BinaryTreeNode(15));
		BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
		BinaryTreeNode root = new BinaryTreeNode(1, node2, node3);

		BinaryTreeNode commonAncestor = commonAncestor(node4, node9);
		if (commonAncestor == null)
			System.out.println("There no common ancestor.");
		else {
			System.out.println("Common anscestor: " + commonAncestor.value);
		}

	}

	private static BinaryTreeNode commonAncestor(BinaryTreeNode node1, BinaryTreeNode node2) {
		String subtree1, subtree2;
		BinaryTreeNode commonAncestor = null;
		if (node1.parent == node2.parent)
			return node1.parent;
		else if (node1.parent == null || node2.parent == null)
			return null;
		else {
			BinaryTreeNode root = findRoot(node1);
			System.out.println(root.value);
			System.out.println(node1.value);
			while (commonAncestor == null) {
				subtree1 = findNode(root, node1);
				subtree2 = findNode(root, node2);
				if (subtree1 == subtree2)
					commonAncestor = root;
			}

			return commonAncestor;
		}

	}

	private static String findNode(BinaryTreeNode root, BinaryTreeNode node) {
		return "";
	}

	private static BinaryTreeNode findRoot(BinaryTreeNode node1) {
		while (node1.parent != null)
			node1 = node1.parent;
		return node1;
	}
}
