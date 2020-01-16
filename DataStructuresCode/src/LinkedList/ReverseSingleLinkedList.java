package LinkedList;

public class ReverseSingleLinkedList {

	public static void main(String[] args) {
		SingleLinkedList<Integer> head = new SingleLinkedList<Integer>(100);
		head.next = new SingleLinkedList<Integer>(101);
		head.next.next = new SingleLinkedList<Integer>(102);
		head.next.next.next = new SingleLinkedList<Integer>(103);
		
		SingleLinkedList<Integer> p = null, q = head, r = head.next;
		
		while(q != null) {
			q.next = p;
			
			p = q;
			q = r;
			if(r != null) {
				r = r.next;
			}
		}
		
		// print list
		head = p;
		while(p != null) {
			System.out.println(p.data);
			p = p.next;
		}
	}
}
