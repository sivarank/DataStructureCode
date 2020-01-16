package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class OrderTraversal {
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
		OrderTraversal lot = new OrderTraversal();
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
        lot.iterativeInOrderTraversal(head, result);
        Collections.reverse(result);
        result.forEach(node -> System.out.println(node.data) );
        System.out.println("+++++++++++++++++++++++");
        result.clear();
        
        lot.iterativePreOrderTraversal(head, result);
        result.forEach(node -> System.out.println(node.data) );
        result.clear();
        lot.iterativePostOrderTraversal(head, result);
        Collections.reverse(result);
        System.out.println("%%$%$%$%$%$");
        result.forEach(node -> System.out.println(node.data) );
        
	}
	private void iterativePostOrderTraversal(Node head, List<Node> result) {
		Stack<Node> s = new Stack<Node>();
		s.push(head);
		while(!s.isEmpty()) {
			Node root = s.pop();
			result.add(root);
			if(root.left != null) {
				s.push(root.left);
			}
			if(root.right != null) {
				s.push(root.right);
			}
		}
	}

	private void iterativePreOrderTraversal(Node head, List<Node> result) {
        Stack<Node> s = new Stack<Node>();	
        Node p = head;
        
        while(p!= null || !s.isEmpty()){
        	if(p!= null) {
        		result.add(p);
        		s.push(p);
        		p = p.left;
        	}else {
        		Node node = s.pop();
        		p = node.right;
        	}
        }
	}
	private void iterativeInOrderTraversal(Node head, List<Node> result) {
        Stack<Node> s = new Stack<Node>();	
        Node p = head;
        
        while(p!= null || !s.isEmpty()){
        	if(p!= null) {
        		s.push(p);
        		p = p.left;
        	}else {
        		Node node = s.pop();
        		result.add(node);
        		p = node.right;
        	}
        }
	}
}
