package treesAndGraphs;

/*
 * 4.12 Paths with Sum: You are given a binary tree in which each node contains an integer value (which
might be positive or negative). Design an algorithm to count the number of paths that sum to a
given value. The path does not need to start or end at the root or a leaf, but it must go downwards
(traveling only from parent nodes to child nodes).
*/
public class PathsWithSum {

	public static void main(String[] args) {
		BinaryTreeNode node3 = new BinaryTreeNode(3, new BinaryTreeNode(3), new BinaryTreeNode(-2));
		BinaryTreeNode node2 = new BinaryTreeNode(2, null, new BinaryTreeNode(1));
		BinaryTreeNode lnode = new BinaryTreeNode(5, node3, node2);
		BinaryTreeNode rnode = new BinaryTreeNode(-3, null, new BinaryTreeNode(11));
		BinaryTreeNode root = new BinaryTreeNode(10, lnode, rnode);
		int totalPaths = countPathsWithSum(root, 8);
		System.out.println("Number of paths with sum 8 are " + totalPaths);
	}

	private static int countPathsWithSum(BinaryTreeNode root, int targetSum) {
		if (root == null)
			return 0;

		// Count paths from root
		int pathsFromRoot = countPathsFromNode(root, targetSum, 0);

		// Count paths from left subtree
		int pathsFromLeft = countPathsWithSum(root.left, targetSum);

		// Count paths from right subtree
		int pathsFromRight = countPathsWithSum(root.right, targetSum);

		return pathsFromRoot + pathsFromLeft + pathsFromRight;
	}

	private static int countPathsFromNode(BinaryTreeNode root, int targetSum, int currentSum) {
		if (root == null)
			return 0;
		currentSum += root.value;
		int paths = 0;

		if (currentSum == targetSum)
			paths++;
		paths += countPathsFromNode(root.left, targetSum, currentSum);
		paths += countPathsFromNode(root.right, targetSum, currentSum);
		return paths;
	}

}
