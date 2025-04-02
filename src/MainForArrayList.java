package src;

public class MainForArrayList {
	
	public static void main(String[] args) {

		MyArrayList<Integer> malt1 = new MyArrayList<>();
		malt1.add(11);
		malt1.add(12);
		malt1.add(13);
		malt1.add(14);
		malt1.add(15);
		malt1.add(16);

		System.out.println(malt1);
		malt1.add(0, 228);
		System.out.println(malt1);
		malt1.remove(14);
		System.out.println("contains 15 " + malt1.contains(15));
		MyArrayList<Integer> malt2 = (MyArrayList<Integer>) malt1.subList(0, malt1.size);
		System.out.println("containsAll " + (malt1.containsAll(malt2)));
		System.out.println(malt1.isEmpty());
		System.out.println(malt2.isEmpty());
		System.out.println(malt1.size());
		System.out.println(malt2.size());

	}
}