package treesAndGraphs;

/*4.8 First Common Ancestor: Design an algorithm and write code to find the first common ancestor
of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.
Hints: #70, #76, #28, #36, #46, #70, #80, #96
*/
public class FirstCommonAncestor {

	public static void main(String[] args) {
		BinaryTreeNode node8 = new BinaryTreeNode(8);
		BinaryTreeNode node9 = new BinaryTreeNode(9);
		BinaryTreeNode node4 = new BinaryTreeNode(4, node8, node9);
		BinaryTreeNode node10 = new BinaryTreeNode(10);
		BinaryTreeNode node5 = new BinaryTreeNode(5, node10, new BinaryTreeNode(11));
		BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
		BinaryTreeNode node6 = new BinaryTreeNode(6, new BinaryTreeNode(12), new BinaryTreeNode(13));
		BinaryTreeNode node7 = new BinaryTreeNode(7, new BinaryTreeNode(14), new BinaryTreeNode(15));
		BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
		BinaryTreeNode root = new BinaryTreeNode(1, node2, node3);
		BinaryTreeNode commonAncestor = findCommonAncestor(node10, node9);
		if (commonAncestor == null)
			System.out.println("There no common ancestor.");
		else {
			System.out.println("Common anscestor: " + commonAncestor.value);
		}

	}

	private static BinaryTreeNode findCommonAncestor(BinaryTreeNode node1, BinaryTreeNode node2) {
		if (node1.parent == node2.parent)
			return node1.parent;
		else if (node1.parent == null || node2.parent == null)
			return null;
		else {
			return commonAncestor(findRoot(node1), node1, node2);
		}
	}

	private static BinaryTreeNode commonAncestor(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
		if (root != null) {
			if (RouteBetweenNodes.findRouteWithDFS(root.left, node1)
					&& RouteBetweenNodes.findRouteWithDFS(root.left, node2))
				return commonAncestor(root.left, node1, node2);
			else if (RouteBetweenNodes.findRouteWithDFS(root.right, node1)
					&& RouteBetweenNodes.findRouteWithDFS(root.right, node2))
				return commonAncestor(root.right, node1, node2);
			else
				return root;
		} else
			return null;
	}

	private static BinaryTreeNode findRoot(BinaryTreeNode node1) {
		while (node1.parent != null)
			node1 = node1.parent;
		System.out.println("Root of the tree: " + node1.value);
		return node1;
	}
}
