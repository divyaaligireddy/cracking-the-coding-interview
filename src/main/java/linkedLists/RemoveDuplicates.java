package linkedLists;

import java.util.Hashtable;

/*2.1 Remove Dups: Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?*/
public class RemoveDuplicates {

	public static void main(String[] args) {
		Node node7 = new Node(5, null);
		Node node6 = new Node(4, node7);
		Node node8 = new Node(1, node6);
		Node node5 = new Node(4, node8);
		Node node4 = new Node(1, node5);
		Node node3 = new Node(3, node4);
		Node node2 = new Node(2, node3);
		Node node1 = new Node(1, node2);
		printList(node1);
		// removeDuplicatesWithHashTable(node1);
		removeDuplicatesWithoutHashTable(node1);
		printList(node1);
	}

	// Code runs in O(1) space, but O(NxN) time
	private static void removeDuplicatesWithoutHashTable(Node node) {
		while (node != null) {
			Node runner = node;
			while (runner.next != null) {
				if (node.data == runner.next.data) {
					runner.next = runner.next.next;
				} else
					runner = runner.next;
			}
			node = node.next;
		}
	}

	// Code takes O(N) time, where N is number of elements in linked list
	private static void removeDuplicatesWithHashTable(Node node) {
		Hashtable<Integer, Boolean> hashTable = new Hashtable<>();
		Node previous = null;
		while (node != null) {
			if (hashTable.containsKey(node.data))
				previous.next = node.next;
			else {
				hashTable.put(node.data, Boolean.TRUE);
				previous = node;
			}
			node = node.next;
		}
	}

	private static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println("null");
	}
}
