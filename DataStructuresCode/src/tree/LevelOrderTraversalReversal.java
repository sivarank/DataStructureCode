package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Date 04/20/2015
 * 
 * Video link - https://youtu.be/D2bIbWGgvzI
 *
 * Given a binary tree print its level order traversal in reverse
 * e.g           1
 *          2         3
 *        4    5    6   7
 * 
 * Output should be 4 5 6 7 2 3 1
 * 
 * Solution
 * Maintain a stack and queue. Do regular level order traversal but
 * put right first in the queue. Instead of printing put the result
 * in stack. Finally print contents of the stack.
 * 
 * Time and space complexity is O(n)
 * 
 * References : http://www.geeksforgeeks.org/reverse-level-order-traversal/
 */

public class LevelOrderTraversalReversal {
	private void traversal(List<Node> result, Queue<Node> q ) {
		//dequeue node, add left and right
		while(!q.isEmpty()) {
			Node head = q.poll();
			result.add(head);
			if(head.right != null) {
				q.add(head.right);
			}
			if(head.left != null) {
				q.add(head.left);
			}
		}
	}
	
	public static void main(String[] args) {
		LevelOrderTraversalReversal lot = new LevelOrderTraversalReversal();
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
        Collections.reverse(result);
        result.forEach(node -> System.out.println(node.data) );
	}
}
