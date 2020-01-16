package sort;

public class RadixSort {
	
	private void countSort(Integer arr[], Integer pos, Integer base){
		//LEARN: Integer arr[] = new Integer[10]; // allocates array , but default value is null. we need to set the value to 0 explicitly.
		int count[] = new int[base];
		int output[] = new int[arr.length];
		
		// set counts in count array
		for(Integer val : arr){
			//System.out.println((val/pos)%base);
			count[(val/pos)%base]++;
		}
		
		// cumulative sum of count array
		for(int i = 1; i<count.length; i++){
			count[i] += count[i-1];
		}
		
		// sort numbers based on cumulative array
		for(int i=arr.length -1 ; i>=0; i--){
			output[count[(arr[i]/pos)%base]-1] = arr[i];
			count[(arr[i]/pos)%base]--;
		}
		
		//copy output to arr
		for(int i=0; i<arr.length; i++){
			arr[i] = output[i];
		}
	}
	
	private Integer getMax(Integer arr[]){
		Integer max = Integer.MIN_VALUE;
		for(Integer val : arr){
			max = Math.max(max, val);
		}
		return max;
	}
	
	public static void main(String[] args) {
		RadixSort rsort = new RadixSort();
		Integer arr[] = new Integer[]{170,45,75,90,802};
		Integer maxValue = rsort.getMax(arr);
		
		Integer base = 10;
		for(Integer pos = 1; maxValue / pos > 0; pos *= base){
			rsort.countSort(arr, pos, base);
		}
		
		for(int i=0; i< arr.length; i++){
			System.out.println(arr[i]);
		}

	}
}
