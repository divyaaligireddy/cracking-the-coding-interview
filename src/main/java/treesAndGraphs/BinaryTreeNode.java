package treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeNode {

	public int value;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	public State state;
	public BinaryTreeNode parent;

	public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
		this.state = State.unvisited;
		if (this.left != null)
			this.left.parent = this;
		if (this.right != null)
			this.right.parent = this;
	}

	public BinaryTreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.state = State.unvisited;
	}

	public List<BinaryTreeNode> getChildren() {
		List<BinaryTreeNode> children = new ArrayList<>();
		if (this.left != null)
			children.add(this.left);
		if (this.right != null)
			children.add(this.right);
		return children;
	}

}
