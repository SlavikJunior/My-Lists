package src;

import java.util.*;

public class MyDoubleComparator implements Comparator<Double> {
	
	private double pogreshnost;
	
	public MyDoubleComparator(double pogreshnost) {
		this.pogreshnost = pogreshnost;
	}
	
	public int compare(Double d1, Double d2) {
		double resAbs = Math.abs((double) (d1 - d2));
		if (resAbs <= pogreshnost) {
			return 0;
		}
		else if (d1 > d2)
			return 1;
		else
			return - 1;
	}
}