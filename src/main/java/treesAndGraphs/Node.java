package treesAndGraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node {

	public String value;

	public List<Node> children;

	public Node parent;

	public State state;

	public Node(String value, List<Node> children) {
		super();
		this.value = value;
		this.children = children;
		this.state = State.unvisited;
		if (this.children != null) {
			for (Node child : this.children) {
				child.parent = this;
			}
		}
	}

	public Node(String value) {
		super();
		this.value = value;
		this.state = State.unvisited;
	}

	public void addChild(Node child) {
		if (this.children == null) {
			this.children = new ArrayList<>();
		}
		child.parent = this;
		this.children.add(child);
	}

	public List<Node> getChildren() {
		if (this.children != null)
			return this.children;
		else
			return Collections.emptyList();
	}

}
