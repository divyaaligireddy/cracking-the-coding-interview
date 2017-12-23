package treesAndGraphs;

import java.util.LinkedList;
import java.util.List;

public class Node {

	public String value;

	public Node[] children;

	public State state;

	public Node(String value, Node[] children) {
		super();
		this.value = value;
		this.children = children;
		this.state = State.unvisited;
	}

	public List<Node> getChildren() {
		List<Node> list = new LinkedList<>();
		if (this.children != null) {
			for (Node child : this.children) {
				list.add(child);
			}
		}
		return list;
	}

}
