package treesAndGraphs;

import java.util.Random;

class TreeNode {
	private int data;
	public TreeNode left;
	public TreeNode right;
	private int size = 0;

	public TreeNode(int d) {
		data = d;
		size = 1;
	}

	public TreeNode getRandomNode() {
		int leftSize = left == null ? 0 : left.size();
		Random random = new Random();
		int index = random.nextInt(size);
		if (index < leftSize) {
			return left.getRandomNode();
		} else if (index == leftSize) {
			return this;
		} else {
			return right.getRandomNode();
		}
	}

	public void insertInOrder(int d) {
		if (d <= data) {
			if (left == null) {
				left = new TreeNode(d);
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				right = new TreeNode(d);
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}

	public int size() {
		return size;
	}

	public int data() {
		return data;
	}

	public TreeNode find(int d) {
		if (d == data) {
			return this;
		} else if (d <= data) {
			return left != null ? left.find(d) : null;
		} else if (d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(8);
		treeNode.insertInOrder(4);
		treeNode.insertInOrder(12);
		treeNode.insertInOrder(1);
		treeNode.insertInOrder(13);
		treeNode.insertInOrder(5);
		treeNode.insertInOrder(14);
		TreeNode randomNode = treeNode.getRandomNode();
		System.out.println(randomNode.data);
	}
}
