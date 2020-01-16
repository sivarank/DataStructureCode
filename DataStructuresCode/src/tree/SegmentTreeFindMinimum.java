package tree;

import java.util.Arrays;
import java.util.stream.Stream;

class SegmentTree{
	private int size = 0;
	private int leafCount = 0;
	private int currentIndex;
	private int segmentTree[];
	
	SegmentTree(int m){
		size= m;
		segmentTree = new int[m];
		currentIndex =0;
		// use lamda to set Integer.Max_NUMBER. It is not possible
		for(int i=0; i<m;i++) {
			segmentTree[i] = Integer.MAX_VALUE;
		}
	}
	
	int getIndex(){
		return currentIndex;
	}
	int length() {
		return size;
	}
	
	
	void incrementLeafCount() {
		leafCount++;
	}
	int getLeafCount() {
		return leafCount;
	}
	void setValue(int value) {
		segmentTree[currentIndex] = value;
	}
	void goToLeftChild() {
		currentIndex = 2*currentIndex+1;
	}
	void goToRightChild() {
		currentIndex = 2*currentIndex+2;
	}
	void goToParent() {
		currentIndex = (currentIndex-1)/2;
	}
	void printArray() {
		System.out.println(Arrays.toString(segmentTree));
	}
}
public class SegmentTreeFindMinimum {

	private static int constructSegmentTree(SegmentTree segmentTree, int[] input) {
		// is this leaf
		int i = segmentTree.getIndex();
		if(2*i+1 >=  segmentTree.length()) {
			segmentTree.setValue(input[segmentTree.getLeafCount()]);
			segmentTree.incrementLeafCount();
			segmentTree.goToParent();
			return input[segmentTree.getLeafCount()-1];
			
		}else {
			segmentTree.goToLeftChild();
			int leftValue = constructSegmentTree(segmentTree, input);
			segmentTree.goToRightChild();
			int rightValue = constructSegmentTree(segmentTree, input);
			segmentTree.setValue(Math.min(leftValue, rightValue));
			segmentTree.goToParent();
			return Math.min(leftValue, rightValue);
		}
	}
	
	public static void main(String[] args) {
		int input[] = new int[] {-1,0,3,6};
		
		int n = input.length;
		int m = 2*n - 1;
		SegmentTree seg = new SegmentTree(m);
		
		constructSegmentTree(seg, input);
		seg.printArray();
		//Arrays.toString(a)
		//System.out.println(seg.getIndex());
	}
}
