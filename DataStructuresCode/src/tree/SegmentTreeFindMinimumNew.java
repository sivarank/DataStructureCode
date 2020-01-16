package tree;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Time complexity O(logn). tree construction O(n)
 * it is useful when there is Range related question.
 * @author SIVAR1
 *
 */
public class SegmentTreeFindMinimumNew {

	private  int constructSegmentTree(int[] segmentTree, int pos, int[] input, int low, int high) {
		if(low == high) {
			segmentTree[pos] = input[low];
			return input[low];
		}else {
			int mid = (low+high)/2;
			int leftVal = constructSegmentTree(segmentTree, 2*pos+1, input, low,mid);
			int rightVal = constructSegmentTree(segmentTree, 2*pos+2, input, mid+1, high);
			segmentTree[pos] = Math.min(leftVal, rightVal);
			return segmentTree[pos];
		}
	}
	
	private int getMinQuery(int[] segTree, int pos, int qLow, int qHigh, int low, int high) {
		// no overlapping
		if(qHigh < low || qLow >high) {
			return Integer.MAX_VALUE;
		}else if(qLow<= low && qHigh >= high) {
			return segTree[pos];
		}else {
			int mid = (low+high)/2;
			int leftValue = getMinQuery(segTree, 2*pos+1, qLow, qHigh, low, mid);
			int rightValue = getMinQuery(segTree, 2*pos+2, qLow, qHigh, mid+1, high);
			return Math.min(leftValue, rightValue);
		}
	}
	
	public static void main(String[] args) {
		SegmentTreeFindMinimumNew obj = new SegmentTreeFindMinimumNew();
		int input[] = new int[] {-1,0,3,6};
		
		int n = input.length;
		int m = 2*n - 1;
		int[] segmentTree = new int[m];
		
		obj.constructSegmentTree(segmentTree, 0, input, 0, n-1);
		System.out.println(Arrays.toString(segmentTree));
		System.out.println(obj.getMinQuery(segmentTree, 0, 0,3, 0,3));
		System.out.println(obj.getMinQuery(segmentTree, 0, 2,3, 0,3));
		System.out.println(obj.getMinQuery(segmentTree, 0, 0,1, 0,3));
		//seg.printArray();
		//Arrays.toString(a)
		//System.out.println(seg.getIndex());
	}
}
