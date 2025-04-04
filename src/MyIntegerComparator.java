package src;

import java.util.*;

public class MyIntegerComparator implements Comparator<Integer> {
		
	public int compare(Integer i1, Integer i2) {
		int res1 = cntOfDigits(i1);
		int res2 = cntOfDigits(i2);
		
		if (res1 > res2) return 1;
		else if (res1 < res2) return - 1;
		else return 0;
	}
	
	private int cntOfDigits(Integer num) {
		String numStr = Integer.toString(num);
		return numStr.length();
	}
}