package treesAndGraphs;

import java.util.LinkedList;
import java.util.List;

public class Node {

	public String node;

	public Node[] children;

	public Node(String node, Node[] children) {
		super();
		this.node = node;
		this.children = children;
	}

	public List<Node> getChildren(Node node) {
		List<Node> list = new LinkedList<>();
		if (node.children != null) {
			for (Node child : node.children) {
				list.add(child);
			}
		}
		return list;
	}

}
