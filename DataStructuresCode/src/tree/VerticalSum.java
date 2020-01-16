package tree;

import java.util.HashMap;

public class VerticalSum {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.head = new Node(10);
		bt.head.left = new Node(7);
		bt.head.left.left = new Node(2);
		bt.head.left.right = new Node(3);
		bt.head.right = new Node(5);
		bt.head.right.left = new Node(6);
		bt.head.right.right = new Node(4);
		
		HashMap<Integer, Integer> sum = new HashMap<Integer, Integer>();
		
		treeTraversal(bt.head, sum, 0);
		for(Integer key : sum.keySet()) {
			System.out.println(key+" : "+sum.get(key));
		}
	}

	private static void treeTraversal(Node head, HashMap<Integer, Integer> sum, int location) {
		if(head == null) {
			return;
		}
		sum.compute(location, (key, value) -> {return value == null ? head.data : value + head.data;});
		treeTraversal(head.left, sum, location -1);
		treeTraversal(head.right, sum, location + 1);
	}

}
