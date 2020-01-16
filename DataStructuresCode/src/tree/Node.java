package tree;

public class Node {
	int data;
	Node left;
	Node right;
    Node next;
    Node pred;
    int lis;
    int height;
    int size;
	public Node(int val) {
		left = right = null;
		data = val;
	}
	
}

class BinaryTree{
	Node head;
	public BinaryTree(Node head) {
		this.head = head;
	}
	public BinaryTree() {
		this.head = null;
	}
	/**
	 * 
	 * @param pos is the tree location where we want to add new node
	 * @param val
	 * @return 
	 */
	public Node addData(Node pos, int val) {
		
		Node newNode = new Node(val);
		// default root head is position
		if(pos == null) {
			pos = head;
		}
		Node currentNode = pos;
		
		
		if(head == null) {
			head = pos;
		}
		if(head == null && pos == null) {
			head = newNode;
			return head;
		}
		
		while(currentNode != null) {
			// insert in left tree
			if(currentNode.data >= val) {
				if(currentNode.left == null) {
					currentNode.left = newNode;
					break;
				}else {
					currentNode = currentNode.left;
				}
			}else {// insert right subtree
				if(currentNode.right == null) {
					currentNode.right = newNode;
					break;
				}else {
					currentNode = currentNode.right;
				}
			}
		}
		return head;
	}
}
