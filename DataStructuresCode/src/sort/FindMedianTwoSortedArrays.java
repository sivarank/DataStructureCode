package sort;

public class FindMedianTwoSortedArrays {

	public static void main(String[] args) {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 18, 25};
        int start = 0; 
        int end = x.length;
        while(start < end) {
        	int partitionX = (start + end)/2;
        	int partitionY = (x.length + y.length +1)/2 - partitionX;
        	
            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : x[partitionX - 1];
            int minRightX = (partitionX == x.length) ? Integer.MAX_VALUE : x[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : y[partitionY - 1];
            int minRightY = (partitionY == y.length) ? Integer.MAX_VALUE : y[partitionY];

        	if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
        		// found answer 
        		if((x.length + y.length)%2 == 1) {
        			System.out.println(Math.max(maxLeftX, maxLeftY));
        		}else {
        			System.out.println((Math.max(maxLeftX, maxLeftY) + Math.min( minRightX, minRightY))/2);
        		}
        		break;
        	}else if(maxLeftX > minRightY) {
        		// move left
        		end = partitionX -1 ;
        	}else {
        		start = partitionX + 1;
        	}
        }
	}

}
