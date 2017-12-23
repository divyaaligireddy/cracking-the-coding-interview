package treesAndGraphs;

public class BinaryTreeNode {

	public int value;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	public State state = State.unvisited;

	public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public BinaryTreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;

	}

}
