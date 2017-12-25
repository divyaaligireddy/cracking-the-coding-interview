package treesAndGraphs;

import java.util.Random;

/*4.11 Random Node: You are implementing a binary tree class from scratch which, in addition to
insert, find, and delete, has a method getRandomNode() which returns a random node
from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
for getRandomNode, and explain how you would implement the rest of the methods.
Hints: #42, #54, #62, #75, #89, #99, #112, #119*/

class RandomTreeNode {
	private int data;
	public RandomTreeNode left;
	public RandomTreeNode right;
	private int size = 0;

	public RandomTreeNode(int d) {
		data = d;
		size = 1;
	}

	public RandomTreeNode getRandomNode() {
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
				left = new RandomTreeNode(d);
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				right = new RandomTreeNode(d);
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

	public RandomTreeNode find(int d) {
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
		RandomTreeNode treeNode = new RandomTreeNode(8);
		treeNode.insertInOrder(4);
		treeNode.insertInOrder(12);
		treeNode.insertInOrder(1);
		treeNode.insertInOrder(13);
		treeNode.insertInOrder(5);
		treeNode.insertInOrder(14);
		RandomTreeNode randomNode = treeNode.getRandomNode();
		System.out.println(randomNode.data);
	}
}
