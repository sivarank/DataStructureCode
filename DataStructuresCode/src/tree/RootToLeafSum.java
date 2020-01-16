package tree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafSum {


	private boolean getPath(Node head, int i, List<Node> result) {
		if(head == null) {
			return false;
		}
		
		if(head.left == null && head.right == null) {
			if(i == head.data) {
				result.add(head);
				return true;
			}
			return false;
		}
		
		boolean childResult = getPath(head.left, i-head.data, result);
		if(childResult == true) {
			result.add(head);
			return true;
		}
		childResult = getPath(head.right, i-head.data, result);
		if(childResult == true) {
			result.add(head);
		}
		return childResult;
	}
	
	public static void main(String[] args) {

		RootToLeafSum rtls = new RootToLeafSum();
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
        boolean r =  rtls.getPath(head, 22, result);
        if(r){
            result.forEach(node -> System.out.print(node.data + " "));
        }else{
            System.out.println("No path for sum " + 22); 
        }
	}


}
