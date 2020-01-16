package LinkedList;

import java.util.ArrayList;


public class SingleLinkedList <T>{
	T data;
	SingleLinkedList<T> next;
	public SingleLinkedList(T input) {
		data = input;
		next = null;
	}
	
	public SingleLinkedList(ArrayList<T> arr) {
		SingleLinkedList<T> previous = null;
		SingleLinkedList<T> current = null;
		for(T val : arr) {
			// header 
			if(previous == null) {
				data = val;
				next = null;
				previous = this;
			}else {
				previous.next = new SingleLinkedList<T>(val);
				previous = previous.next;
			}
		}
	}
}
