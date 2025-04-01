package src;

public class Main{
	
	public static void main(String[] args) {

		MyArrayListTest<Integer> malt1 = new MyArrayListTest<>();
		malt1.add(11);malt1.add(12);malt1.add(13);
		malt1.add(14);malt1.add(15);malt1.add(16);

		MyArrayListTest<Integer> malt2 = (MyArrayListTest<Integer>) malt1.subList(0, malt1.size());

		System.out.println(malt1);
		System.out.println(malt2);

		malt1.add(1212);
		System.out.println(malt1);
		System.out.println(malt2);

		malt2.add(1414);
		System.out.println(malt1);
		System.out.println(malt2);

	}
}