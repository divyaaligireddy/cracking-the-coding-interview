package treesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

/*4.1 Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes.
Hints:#127*/

public class RouteBetweenNodes {

	public static void main(String[] args) {

		Node node13 = new Node("21", null);
		Node node11 = new Node("3", new Node[] { node13 });
		Node node14 = new Node("15", null);
		Node node12 = new Node("24", new Node[] { node14 });
		Node node21 = new Node("28", null);
		Node node23 = new Node("10", null);
		Node node24 = new Node("14", null);
		Node node22 = new Node("22", new Node[] { node23, node24 });
		Node node32 = new Node("44", null);
		Node node31 = new Node("34", new Node[] { node32 });
		Node node1 = new Node("16", new Node[] { node11, node12 });
		Node node2 = new Node("19", new Node[] { node21, node22 });
		Node node3 = new Node("13", new Node[] { node31 });
		Node[] children = new Node[] { node1, node2, node3 };
		Node root = new Node("7", children);

		System.out.println("Using BFS: ");
		System.out.println("Is there a route between nodes " + root.value + ", " + node14.value + "? "
				+ findRouteWithBFS(root, node14));

		System.out.println("Is there a route between nodes " + node1.value + ", " + node23.value + "? "
				+ findRouteWithBFS(node1, node23));

		System.out.println("\nUsing DFS: ");
		System.out.println("Is there a route between nodes " + root.value + ", " + node14.value + "? "
				+ findRouteWithDFS(root, node14));

		System.out.println("Is there a route between nodes " + node1.value + ", " + node23.value + "? "
				+ findRouteWithDFS(node1, node23));
	}

	private static boolean findRouteWithDFS(Node start, Node end) {
		boolean route = false;
		if (start == null)
			return false;
		else {
			start.state = State.visited;
			for (Node child : start.getChildren()) {
				if (child.state == State.unvisited) {
					if (child == end)
						route = true;
					else {
						route = findRouteWithDFS(child, end);
					}
					if (route)
						return true;
				}
			}
			return route;
		}
	}

	private static boolean findRouteWithBFS(Node start, Node end) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			node.state = State.visited;
			for (Node child : node.getChildren()) {
				if (child.state == State.unvisited) {
					if (child == end)
						return true;
					else
						queue.add(child);
				}
			}
		}
		return false;
	}

}
