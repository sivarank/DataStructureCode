package dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
class Job {
	int profit;
	int start;
	int end;
	Job(int start, int end, int profi){
		profit = profi;
		this.start = start;
		this.end = end;
	}
}
class FinishTimeComparator implements Comparator<Job>{
	@Override
	public int compare(Job o1, Job o2) {
		
		return o1.end <= o2.end ? -1 : 1;
	}
}
public class JobSchedulingMaxProfit {

	public static void main(String[] args) {
        Job jobs[] = new Job[6];
        jobs[0] = new Job(1,3,5);
        jobs[1] = new Job(2,5,6);
        jobs[2] = new Job(4,6,5);
        jobs[3] = new Job(6,7,4);
        jobs[5] = new Job(5,8,11);
        jobs[4] = new Job(7,9,2);
        JobSchedulingMaxProfit mp = new JobSchedulingMaxProfit();
        System.out.println(mp.maximum(jobs));

	}

	private int maximum(Job[] jobs) {
		//sort by end time
		Arrays.sort(jobs, new FinishTimeComparator());
		
		int[] profit = new int[jobs.length+1];
		int maxProfit = Integer.MIN_VALUE;
		// initialize array
		for(int i=1; i<= jobs.length; i++) {
			profit[i] = jobs[i-1].profit;
		}
		for(int i=2; i<=jobs.length; i++) {
			for(int j=1; j<i;j++) {
				//overlap
				if(overlap(jobs[j-1], jobs[i-1])) {
					continue;
				}else {
					profit[i] = Math.max(profit[i], jobs[i-1].profit + profit[j]);
				}
			}
			maxProfit = Math.max(maxProfit, profit[i]);
		}
		return maxProfit;
	}

	private boolean overlap(Job job1, Job job2) {
		return job1.end > job2.start;
	}

}
