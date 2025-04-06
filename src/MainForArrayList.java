package src;

import java.util.Arrays;

public class MainForArrayList {
	
	public static void main(String[] args) {

		MyArrayList<Integer> malt1 = new MyArrayList<>();
		malt1.add(11);
		malt1.add(12);
		malt1.add(13);
		malt1.add(14);
		malt1.add(15);

		System.out.println(malt1);
		MyArrayList<Integer> sub = (MyArrayList<Integer>) malt1.subList(1, malt1.size() - 1);

		System.out.println(sub);
		boolean isRetained = malt1.retainAll(sub);
		System.out.println(isRetained);
		System.out.println(sub);
		System.out.println(malt1);
		System.out.println(malt1.size());
	}
}
