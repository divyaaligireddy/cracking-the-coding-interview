package treesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

import org.apache.commons.collections4.CollectionUtils;

public class CheckSubtree {

	public static void main(String[] args) {
		BinaryTreeNode node6 = new BinaryTreeNode(6, new BinaryTreeNode(12), new BinaryTreeNode(13));
		BinaryTreeNode node7 = new BinaryTreeNode(7, new BinaryTreeNode(14), new BinaryTreeNode(15));
		BinaryTreeNode tree2 = new BinaryTreeNode(3, node6, node7);
		BinaryTreeNode tree1 = BaseTrees.getBaseBinaryTree();
		BinaryTreeNode rootOfT2 = findRootOfT2(tree1, tree2.value);
		if (rootOfT2 != null && checkIfSubtree(rootOfT2, tree2))
			System.out.println("\nT2 is a subtree of T1");
		else {
			System.out.println("\nT2 is not a subtree of T1");
		}

	}

	private static boolean checkIfSubtree(BinaryTreeNode rootOfT2, BinaryTreeNode tree2) {
		Queue<BinaryTreeNode> queue = getBFT(rootOfT2);
		Queue<BinaryTreeNode> tempQueue = new LinkedList<>();
		tempQueue.add(tree2);
		System.out.println("T2 traversal: ");
		while (!tempQueue.isEmpty()) {
			BinaryTreeNode item = tempQueue.poll();
			if (item.value != queue.poll().value) {
				return false;
			}
			if (item.state == State.unvisited) {
				item.state = State.visited;
				System.out.print(item.value + " ");
				if (!CollectionUtils.isEmpty(item.getChildren())) {
					for (BinaryTreeNode child : item.getChildren()) {
						tempQueue.add(child);
					}
				}
			}
		}
		if (queue.isEmpty())
			return true;
		else
			return false;
	}

	private static Queue<BinaryTreeNode> getBFT(BinaryTreeNode rootOfT2) {
		System.out.println("T1 traversal: ");
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		Queue<BinaryTreeNode> tempQueue = new LinkedList<>();
		tempQueue.add(rootOfT2);
		queue.add(rootOfT2);
		while (!tempQueue.isEmpty()) {
			BinaryTreeNode item = tempQueue.poll();
			if (item.state == State.unvisited) {
				item.state = State.visited;
				System.out.print(item.value + " ");
				if (!CollectionUtils.isEmpty(item.getChildren())) {
					for (BinaryTreeNode child : item.getChildren()) {
						tempQueue.add(child);
						queue.add(child);
					}
				}
			}
		}
		System.out.println();
		return queue;
	}

	private static BinaryTreeNode findRootOfT2(BinaryTreeNode tree1, int tree2) {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(tree1);
		while (!queue.isEmpty()) {
			BinaryTreeNode item = queue.poll();
			if (item.state == State.unvisited) {
				if (item.value == tree2) {
					return item;
				}
				if (!CollectionUtils.isEmpty(item.getChildren())) {
					for (BinaryTreeNode child : item.getChildren()) {
						queue.add(child);
					}
				}
			}
		}
		return null;
	}
}
