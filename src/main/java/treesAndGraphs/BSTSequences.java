package treesAndGraphs;

import java.util.List;

/*4.9 BST Sequences: A binary search tree was created by traversing through an array from left to right
and inserting each element. Given a binary search tree with distinct elements, print all possible
arrays that could have led to this tree.
EXAMPLE
Input:
Output: {2, 1, 3}, {2, 3, 1}
Hints: #39, #48, #66, #82*/

public class BSTSequences {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(2, new BinaryTreeNode(1), new BinaryTreeNode(3));
		List<List<BinaryTreeNode>> listOfDepthsBST = ListOfDepths.findListOfDepthsBST(root);
		for (int i = 0; i < listOfDepthsBST.size(); i++) {

		}
		for (List<BinaryTreeNode> level : listOfDepthsBST) {
			permute(level, 0, level.size() - 1);
		}
	}

	private static void permute(List<BinaryTreeNode> level, int l, int r) {
		if (l == r)
			print(level);
		else {
			for (int i = l; i <= r; i++) {
				level = swap(level, l, i);
				permute(level, l + 1, r);
				level = swap(level, l, i);
			}
		}
	}

	private static void print(List<BinaryTreeNode> level) {
		for (BinaryTreeNode node : level) {
			System.out.print(node.value + " ");
		}
		System.out.println();
	}

	public static List<BinaryTreeNode> swap(List<BinaryTreeNode> level, int i, int j) {
		BinaryTreeNode temp;
		temp = level.get(i);
		level.set(i, level.get(j));
		level.set(j, temp);
		return level;
	}
}
