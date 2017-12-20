package linkedLists;
/*2.2 Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
Hints:#8, #25, #41, #67, #126*/
public class ReturnKthToLast {
	public static void main(String[] args) {
		Node node7 = new Node(7, null);
		Node node6 = new Node(6, node7);
		Node node5 = new Node(5, node6);
		Node node4 = new Node(4, node5);
		Node node3 = new Node(3, node4);
		Node node2 = new Node(2, node3);
		Node node1 = new Node(1, node2);
		printList(node1);
		Node node = findListLength(node1, 4);
		if(node != null)
			System.out.println("4th element from the last is " + node.data);
		else
			System.out.println("Index out of bounds");
	}
	
	private static Node findListLength(Node node, int k) {
		Node runner = node;
		for (int i=0; i < k; i++) {
			if (runner == null)
				return null;
			runner = runner.next;
		}
		while(runner != null) {
			node = node.next;
			runner = runner.next;
		}
		return node;
	}

	private static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println("null");
	}

}
