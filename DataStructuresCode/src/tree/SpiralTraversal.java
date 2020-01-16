package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SpiralTraversal {

	/**
	 * Date 04/16/2015
	 * @author tusroy
	 *
	 * Video link - https://youtu.be/vjt5Y6-1KsQ
	 *
	 * Given a root of binary tree, print in spiral order. 
	 * e.g               1 
	 *             2           3 
	 *        4       5     6      7
	 *      8   9  10    11 
	 * should print 1 3 2 4 5 6 7 8 9 10 11
	 *
	 * Solution 1 : Use two stack. Put root in stack1. While stack1 is not
	 * empty take items from stack1 and put its child left,right in stack2.
	 * Then once stack1 is empty pop from stack2 and put its child right,
	 * left into stack1.
	 * 
	 * Solution 2 : Use one dequeue. Technique is like above but instead of
	 * using two stack use dequeue. Also keep count till which point you read
	 * in the dequeue.
	 * 
	 * Solution 3: Use one dequeue. Use a delimiter to separate between one 
	 * stack growing from top and another one growing from bottom.
	 *         
	 * Time complexity is O(n) 
	 * Space complexity is O(n)
	 *
	 * Reference
	 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
	 */
	
	public static void main(String[] args) {
		SpiralTraversal lot = new SpiralTraversal();
		BinaryTree bt = new BinaryTree();
		Node head = null;
		/*
		 *                  10
		 *                5     15 
		 *              4   7
		 */
        head = bt.addData(head, 10);
        head = bt.addData(head, 15);
        head = bt.addData(head, 5);
        
        head = bt.addData(head, 7);
        //head = bt.addData(head, 19);
        //head = bt.addData(head, 20);
        head = bt.addData(head, 4);
       // head = bt.addData(head, 3);
        List<Node> result = new ArrayList<>();
        lot.stackImplementation(head, result);
        Collections.reverse(result);
        result.forEach(node -> System.out.println(node.data) );
        System.out.println("@!@@##$%%^");
        result.clear();
        lot.dequeueImplementation(head, result);
        Collections.reverse(result);
        result.forEach(node -> System.out.println(node.data) );
	}

	private void dequeueImplementation(Node head, List<Node> result) {
		Deque<Node> dq = new LinkedList<>();
		dq.add(head);
		dq.add(null);
		boolean forwardDirection = true;
		while(dq.size() > 1) {
			if(forwardDirection) {
				while(dq.peek() != null) {
					Node node = dq.poll();
					result.add(node);
					if(node.right != null) {
						dq.addLast(node.right);
					}
					if(node.left != null) {
						dq.addLast(node.left);
					}
				}
				forwardDirection = false;
			}else {
				while(dq.peekLast() != null) {
					Node node = dq.pollLast();
					result.add(node);
					if(node.left != null) {
						dq.addFirst(node.left);
					}
					if(node.right != null) {
						dq.addFirst(node.right);
					}
				}
				forwardDirection = true;
			}
		}
		
	}

	private void stackImplementation(Node head, List<Node> result) {
		Stack<Node> s1 = new Stack<Node>(); // LR 
		Stack<Node> s2 = new Stack<Node>(); // RL
		
		s1.push(head);
		while(!s1.isEmpty() || !s2.isEmpty()) {
			while(!s1.isEmpty()) { // LR
				Node node = s1.pop();
				result.add(node);
				if(node.left != null) {
					s2.push(node.left);
				}
				if(node.right != null) {
					s2.push(node.right);
				}
			}
			while(! s2.isEmpty()) { // RL
				Node node = s2.pop();
				result.add(node);
				if(node.right != null) {
					s1.push(node.right);
				}
				if(node.left != null) {
					s1.push(node.left);
				}
			}
		}
		
	}

}
