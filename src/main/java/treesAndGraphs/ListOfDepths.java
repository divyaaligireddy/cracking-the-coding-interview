package treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepths {

	public static void main(String[] args) {
		Node tree = BaseTrees.getBaseTree();
		List<List<Node>> levels = new ArrayList<>();
		List<Node> root = new LinkedList<Node>();
		root.add(tree);
		levels.add(root);
		displayLevel(root, levels);
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

	private static void displayLevel(List<Node> queue, List<List<Node>> levels) {
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
			displayLevel(newLevel, levels);
		}
	}
}
