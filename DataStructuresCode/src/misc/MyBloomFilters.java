package misc;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class MyBloomFilters {

	public static void main(String[] args) {
		BloomFilter<Integer> filter = BloomFilter.create(
				  Funnels.integerFunnel(),
				  5000,
				  0.01);
		filter.put(1);
		filter.put(2);
		filter.put(3);
		System.out.println(filter.mightContain(1));
		System.out.println(filter.mightContain(2));
		System.out.println(filter.mightContain(3));
		System.out.println(filter.mightContain(99));
	}
}

