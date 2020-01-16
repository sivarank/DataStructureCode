package LinkedList;

import java.util.ArrayList;

class Result<T>{
	SingleLinkedList<T> head, previousHead;
}
public class ReverseEveryKElementsInSLL<T> {
	private Result<T> reverseKElements(SingleLinkedList<T> head, Integer nodeNumber, Integer k) {
		if(head == null) {
			return new Result<T>();
		}else if(head.next == null) {
			Result<T> result = new Result<T>();
			result.head = head;
			return result;
		}
		//System.out.println(head.data);
		Result<T> result = reverseKElements(head.next, nodeNumber + 1, k);
		// First node
		if(nodeNumber % k == 1) {
			head.next.next = head;
			head.next = result.previousHead;
		}else if(nodeNumber % k == 0) {
			//last node
			result.previousHead = result.head;
			result.head = head;
		}else {
			head.next.next = head;
		}
		return result;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 1; i<9 ; i++) {
			arr.add(i);
		}
		
		SingleLinkedList<Integer> head = new SingleLinkedList<Integer>(arr);
		Result<Integer> result = new ReverseEveryKElementsInSLL<Integer>().reverseKElements(head, 1, 3);
		SingleLinkedList<Integer> newHead = result.head;
		while(newHead != null) {
			System.out.println(newHead.data);
			newHead = newHead.next;
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		newHead = new ReverseEveryKElementsInSLL<Integer>().reverseKElementsNonRecursive(result.head, 0, 3);
		while(newHead != null) {
			System.out.println(newHead.data);
			newHead = newHead.next;
		}
	}

	private SingleLinkedList<T> reverseKElementsNonRecursive(SingleLinkedList<T> head, int i, int k) {
		
		if(head == null || head.next == null) {
			return head;
		}else {
			// Maintain three pointers
			SingleLinkedList<T> p=null,q = head,r=head.next, previousTail = null, currentTail = null, newHead = null;
			while(q != null) {
				System.out.println(q.data);
				// last node in K nodes 
				if(i %k == k-1 || q.next == null) {
					if(previousTail != null) {
						previousTail.next = q;
					}else {
						newHead = q;
					}
					q.next = p;
					
				}
				// first Node in K nodes
				else if(i % k == 0) {
					previousTail = currentTail;
					currentTail = q;
					q.next = null;// Learn: make sure , last node next is null
				}else{
					q.next = p;
				}
				
				// set all pointers
				p = q;
				q = r;
				if(r != null) {
					r = r.next;
				}
				i++;
			}
			return newHead;
		}
	}
}
