package treesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class BfsAndDfs {

	public static void main(String[] args) {
		System.out.println("Breadth First Traversal:");
		breadthFirstSearch(BaseTrees.getBaseTree());
		System.out.println("\n\nDepth First Traversal:");
		depthFirstSearch(BaseTrees.getBaseTree());
	}

	private static void depthFirstSearch(Node node) {
		if (node != null) {
			System.out.print(node.value + " ");
			node.state = State.visited;
			for (Node child : node.getChildren()) {
				depthFirstSearch(child);
			}
		}
	}

	private static void breadthFirstSearch(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node item = queue.poll();
			item.state = State.visited;
			System.out.print(item.value + " ");
			for (Node child : item.getChildren()) {
				queue.add(child);
			}
		}
	}
}
