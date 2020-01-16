package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 03/08/2016
 * @author Tushar Roy
 *
 * Morris inorder/preorder traversals
 *
 * Time complexity O(n)
 * Space complexity O(1)
 *                       15
 *                    13     16
 *                  11  14     17
 */
public class MorrisInorderTraversalWithoutStack {

	public static void main(String[] args) {
		Node head = new Node(15);
		head.left = new Node(13);
		head.right = new Node(16);
		head.left.left = new Node(11);
		head.left.right = new Node(14);
		head.right.right = new Node(17);
		
		MorrisInorderTraversalWithoutStack mor = new MorrisInorderTraversalWithoutStack();
        List<Node> result = new ArrayList<>();
		mor.inorderTraversal(head, result);
		result.forEach(node ->System.out.println(node.data));
		
		mor.inorder(head);
	}
    public void inorder(Node root) {
        Node current = root;
        while(current != null) {
            //left is null then print the node and go to right
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            }
            else {
                //find the predecessor.
                Node predecessor = current.left;
                //To find predecessor keep going right till right node is not null or right node is not current.
                while(predecessor.right != current && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                //if right node is null then go left after establishing link from predecessor to current.
                if(predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                }else{ //left is already visit. Go rigth after visiting current.
                    predecessor.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }
    
	private void inorderTraversal(Node root, List<Node> result) {
		// if left null, visit node. got to right
		
		if(root == null) {
			return;
		}
		while(root != null) {
			if(root.left == null) {
				result.add(root);
				root = root.right;
			}else {
				 Node pred = getPredecessor(root);
				
				// if get predecessor, its right is not present, form link, goto left. if predecessor has right link, visit node
				if(pred.right == null) {
					pred.right = root;
					root = root.left;
				}else { // second visit, back visit
					pred.right = null;
					result.add(root);
					root = root.right;
				}
			}
		}
	}
	private Node getPredecessor(Node root) {
//		if(root == null || root.left == null) {
//			return null;
//		}
//
//		Node cur = root.left;
//		while(cur.right != null) {
//			cur = cur.right;
//		}
//		return cur;
		Node predecessor = root.left;
        //To find predecessor keep going right till right node is not null or right node is not current.
        while(predecessor.right != root && predecessor.right != null){
            predecessor = predecessor.right;
        }
        return predecessor;
	}


}
