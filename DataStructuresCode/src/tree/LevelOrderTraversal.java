package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
	private void traversal(List<Node> result, Queue<Node> q ) {
		//dequeue node, add left and right
		while(!q.isEmpty()) {
			Node head = q.poll();
			result.add(head);
			if(head.left != null) {
				q.add(head.left);
			}
			if(head.right != null) {
				q.add(head.right);
			}
		}
	}
	
	public static void main(String[] args) {
		LevelOrderTraversal lot = new LevelOrderTraversal();
		BinaryTree bt = new BinaryTree();
		Node head = null;
        head = bt.addData(head, 10);
        head = bt.addData(head, 15);
        head = bt.addData(head, 5);
        head = bt.addData(head, 7);
        head = bt.addData(head, 19);
        head = bt.addData(head, 20);
        head = bt.addData(head, 4);
        head = bt.addData(head, 3);
        List<Node> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<Node>();
        //result.add(head);
        q.add(head);
        lot.traversal(result, q);
        result.forEach(node -> System.out.println(node.data) );
	}
}
