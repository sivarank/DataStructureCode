package tree;

/**
 * Time complexity O(1). Table construction O(nlogn)
 * it is useful when there is Range related question.
 * @author SIVAR1
 *
 */
public class SparseTable {


	private int size = 0;
	private int[][] sparseTable;
	private int[] input;
	
	public SparseTable(int[] input) {
		this.input = input;
		this.size = input.length; 
		sparseTable = new int[size][log2(size) + 1];
		
		constructTable();
	}
	
    private void constructTable() {
    	//fill first column
    	for(int i=0; i<size; i++) {
    		sparseTable[i][0] = i;
    	}
    	
    	for(int j=1; (1<<j) < size; j++) {
    		for(int i=0; i + (1<<j)< size; i++) {
    			if(input[sparseTable[i][j-1]] < input[sparseTable[i+(1<<(j-1))][j-1]]) {
    				sparseTable[i][j] = sparseTable[i][j-1];
    			}else {
    				sparseTable[i][j] = sparseTable[i+(1<<(j-1))][j-1];
    			}
    		}
    	}
	}

	private int rangeMinimumQuery(int low, int high) {
		int totalElements = high-low + 1;
		int k = log2(totalElements);
		int remainingElements = totalElements - (1<<k); 
		return Math.min(input[sparseTable[low][k]], input[sparseTable[low+remainingElements][k]]);
	}
	private static int log2(int n){
        if(n <= 0) throw new IllegalArgumentException();
        return 31 - Integer.numberOfLeadingZeros(n);
    }
    
	public static void main(String[] args) {
		
        int[] input = {2, 5, 3, 6, 4, 1, -1, 3, 4, 2};
        SparseTable sparseTableRangeMinimumQuery = new SparseTable(input);
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                System.out.print(sparseTableRangeMinimumQuery.rangeMinimumQuery(i, j) + " ");
            }
            System.out.println();
        }
	}

}
