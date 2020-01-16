package backTracking;

import java.util.Arrays;

public class SumOfAllSubSets {

	static void printResult(int values[], boolean resultSet[]) {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		for(int i=0; i<values.length; i++) {
			if(resultSet[i]) {
				System.out.println(values[i]);
			}
		}
	}
	
	static void findSubset(int values[], int currentIndex, int targetSum, int sumSofar, int remainingSum, boolean resultSet[]) {
		if(currentIndex >= values.length || sumSofar + remainingSum <targetSum) {
			return;
		}
		
		if(sumSofar + values[currentIndex] > targetSum) {
			resultSet[currentIndex] =  false;
			findSubset(values, currentIndex+1, targetSum, sumSofar, remainingSum -values[currentIndex], resultSet );
		}else if(sumSofar + values[currentIndex] == targetSum){
			resultSet[currentIndex] =  true;
			printResult(values, resultSet);
			resultSet[currentIndex] =  false;
		}else {
			// first you consider current value
			resultSet[currentIndex] =  true;
			findSubset(values, currentIndex+1, targetSum, sumSofar + values[currentIndex], remainingSum -values[currentIndex], resultSet );
			
			// you don't consider current value
			resultSet[currentIndex] =  false;
			findSubset(values, currentIndex+1, targetSum, sumSofar , remainingSum -values[currentIndex], resultSet );
		}
	}
	
	public static void main(String[] args) {
		int[] values = new int[]{5,10,12,13,15,18};
		int n = values.length;
		int m = 30;
		boolean[] resultSet = new boolean[n];
		
		findSubset(values, 0, m, 0,Arrays.stream(values).sum(), resultSet );
	}

}
