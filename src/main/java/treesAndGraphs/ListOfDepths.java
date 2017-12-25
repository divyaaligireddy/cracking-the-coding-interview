package treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepths {

	public static void main(String[] args) {
		Node tree = BaseTrees.getBaseTree();
		findListOfDepths(tree);
		printBSTLevels(findListOfDepthsBST(BaseTrees.getBaseBST()));
	}

	public static void findListOfDepths(Node tree) {
		List<List<Node>> levels = new ArrayList<>();
		List<Node> root = new LinkedList<Node>();
		root.add(tree);
		levels.add(root);
		addLevel(root, levels);
		int i = 0;
		for (List<Node> level : levels) {
			System.out.print("Level: " + i + " Size: " + level.size() + "; Elements -> ");
			for (Node node : level) {
				System.out.print(node.value + " ");
			}
			System.out.println();
			i++;
		}
	}

	private static void addLevel(List<Node> queue, List<List<Node>> levels) {
		List<Node> newLevel = new LinkedList<Node>();
		for (Node node : queue) {
			if (node != null && node.state == State.unvisited) {
				node.state = State.visited;
				for (Node child : node.getChildren()) {
					newLevel.add(child);
				}
			}
		}
		if (!newLevel.isEmpty()) {
			levels.add(newLevel);
			addLevel(newLevel, levels);
		}
	}

	public static List<List<BinaryTreeNode>> findListOfDepthsBST(BinaryTreeNode tree) {
		List<List<BinaryTreeNode>> levels = new ArrayList<>();
		List<BinaryTreeNode> root = new LinkedList<BinaryTreeNode>();
		root.add(tree);
		levels.add(root);
		addLevelBST(root, levels);
		return levels;
	}

	private static void printBSTLevels(List<List<BinaryTreeNode>> levels) {
		int i = 0;
		for (List<BinaryTreeNode> level : levels) {
			System.out.print("Level: " + i + " Size: " + level.size() + "; Elements -> ");
			for (BinaryTreeNode node : level) {
				System.out.print(node.value + " ");
			}
			System.out.println();
			i++;
		}
	}

	private static void addLevelBST(List<BinaryTreeNode> queue, List<List<BinaryTreeNode>> levels) {
		List<BinaryTreeNode> newLevel = new LinkedList<BinaryTreeNode>();
		for (BinaryTreeNode node : queue) {
			if (node != null && node.state == State.unvisited) {
				node.state = State.visited;
				for (BinaryTreeNode child : node.getChildren()) {
					newLevel.add(child);
				}
			}
		}
		if (!newLevel.isEmpty()) {
			levels.add(newLevel);
			addLevelBST(newLevel, levels);
		}
	}
}
