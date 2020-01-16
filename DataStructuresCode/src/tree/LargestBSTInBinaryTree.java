package tree;
/**
 * Date 07/20/2014
 * @author tusroy
 * 
 * Video link - https://youtu.be/4fiDs7CCxkc
 * 
 * Given a binary tree, find size of largest binary search subtree in this
 * binary tree.
 * 
 * Traverse tree in post order fashion. Left and right nodes return 4 piece
 * of information to root which isBST, size of max BST, min and max in those
 * subtree. 
 * If both left and right subtree are BST and this node data is greater than max
 * of left and less than min of right then it returns to above level left size +
 * right size + 1 and new min will be min of left side and new max will be max of
 * right side.
 * 
 * References:
 * http://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
 * https://leetcode.com/problems/largest-bst-subtree/
 *                       10
 *                    15     16
 *                  12  17
 *                  
 */
/**
 * Object of this class holds information which child passes back
 * to parent node.
 */

public class LargestBSTInBinaryTree {
	private MinMax getLargestBSTSizeNew(Node root) {
		if(root == null) {
			return null;
		}
		MinMax minmax = new MinMax();
		minmax.min = minmax.max = root.data;
		minmax.size = 0;
		if(root.left == null || root.right == null) {
			minmax.size = 1;
			minmax.isBST = true;
			return minmax;
		}
		MinMax leftResult = null;
		MinMax rightResult = null;
		if(root.left != null) {
			leftResult = getLargestBSTSizeNew(root.left);
		}
		if(root.right != null) {
			rightResult = getLargestBSTSizeNew(root.right);
		}
		// return max left or right , if there is no largest subtree with root
		
		if((leftResult != null && (!leftResult.isBST || leftResult.max > root.data)) || (rightResult != null && (!rightResult.isBST || rightResult.min <=root.data))) {
			minmax.isBST = false;
			if(leftResult == null) {
				minmax.size = rightResult.size;
			}else if(rightResult == null) {
				minmax.size = leftResult.size;
			}else {
				minmax.size = Math.max(leftResult.size, rightResult.size);
			}
			return minmax;
		}
		minmax.isBST = true;
		minmax.size = 1;
		if(leftResult != null) {
			minmax.size += leftResult.size;		
			minmax.min = leftResult.min;
		}
		if(rightResult != null) {
			minmax.size += rightResult.size;
			minmax.max = rightResult.max;
		}
		return minmax;
	}

	private MinMax getLargestBSTSize(Node root) {
		// leaf node
		if(root.left == null || root.right == null) {
			MinMax minmax = new MinMax();
			minmax.size = 1;
			minmax.isBST = true;
			minmax.min = minmax.max = root.data;
			return minmax;
		}else if(root.left != null && root.right != null) {
			MinMax leftResult = getLargestBSTSize(root.left);
			MinMax rightResult = getLargestBSTSize(root.right);
			// root.data should be greater than left max, less than right min.
			if(leftResult.isBST && rightResult.isBST && root.data >= leftResult.max && root.data < rightResult.min) {
				leftResult.size = leftResult.size+1+rightResult.size;
				return leftResult;
			}else {
				leftResult.isBST = rightResult.isBST = false;	
			}
			return leftResult.size >= rightResult.size ? leftResult : rightResult;
		}else if(root.left != null) {
			MinMax leftResult = getLargestBSTSize(root.left);
			if(root.data >= leftResult.max) {
				leftResult.size += 1;
			}else {
				leftResult.isBST = false;
			}
			return leftResult;
		}else {
			MinMax rightResult = getLargestBSTSize(root.right);
			if(root.data < rightResult.min) {
				rightResult.size += 1;
			}else {
				rightResult.isBST = false;
			}
			return rightResult;
		}
	}
	public static void main(String[] args) {
		LargestBSTInBinaryTree bst = new LargestBSTInBinaryTree();
		Node head = new Node(10);
		head.left = new Node(15);
		head.right = new Node(16);
		head.left.left = new Node(12);
		head.left.right = new Node(17);
		MinMax result = bst.getLargestBSTSize(head);
		System.out.println(result.size);
		result = bst.getLargestBSTSizeNew(head);
		System.out.println(result.size);
	}
}
class MinMax{
    int min;
    int max;
    boolean isBST;
    int size ;
    
    MinMax(){
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        isBST = true;
        size = 0;
    }
}
