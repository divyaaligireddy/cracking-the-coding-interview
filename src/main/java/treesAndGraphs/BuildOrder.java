package treesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class BuildOrder {

	public static void main(String[] args) {
		List<String> projects = Arrays.asList("a", "b", "c", "d", "e", "f");
		List<String> order = new ArrayList<>();
		Map<String, Node> nodes = new HashMap<>();
		Multimap<String, String> dependencies = ArrayListMultimap.create();
		dependencies.put("a", "d");
		dependencies.put("f", "b");
		dependencies.put("b", "d");
		dependencies.put("f", "a");
		dependencies.put("d", "c");

		// Node tree = new Node(value, children)
		for (String project : projects) {
			if (!dependencies.containsValue(project))
				order.add(project);
		}
		for (Entry<String, String> entry : dependencies.entries()) {
			Node node = nodes.get(entry.getKey());
			Node child = nodes.get(entry.getValue());
			if (node == null) {
				node = new Node(entry.getKey());
				nodes.put(entry.getKey(), node);
			}
			if (child == null) {
				child = new Node(entry.getValue());
				nodes.put(entry.getValue(), child);
			}
			node.addChild(child);
		}
		// System.out.println(order);
		// System.out.println(nodes);
		Iterator<String> iterator = order.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			Node node = nodes.get(next);
			if (node != null) {
				BfsAndDfs.breadthFirstSearch(node);
			} else
				System.out.print(next + " ");
		}
	}
}
