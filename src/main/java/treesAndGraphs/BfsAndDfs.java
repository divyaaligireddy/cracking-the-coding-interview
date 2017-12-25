package treesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

import org.apache.commons.collections4.CollectionUtils;

public class BfsAndDfs {

	public static void main(String[] args) {
		System.out.println("Breadth First Traversal:");
		breadthFirstSearch(BaseTrees.getBaseTree());
		System.out.println("\n\nDepth First Traversal:");
		depthFirstSearch(BaseTrees.getBaseTree());
	}

	public static void depthFirstSearch(Node node) {
		if (node != null) {
			System.out.print(node.value + " ");
			node.state = State.visited;
			for (Node child : node.getChildren()) {
				depthFirstSearch(child);
			}
		}
	}

	public static void breadthFirstSearch(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node item = queue.poll();
			if (item.state == State.unvisited) {
				item.state = State.visited;
				System.out.print(item.value + " ");
				if (!CollectionUtils.isEmpty(item.getChildren())) {
					for (Node child : item.getChildren()) {
						queue.add(child);
					}
				}
			}
		}
	}
}
