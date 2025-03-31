package src;

public class Main{
	
	public static void main(String[] args) {

		MyArrayList<Integer> mal1 = new MyArrayList<>();
		mal1.add(1);mal1.add(2);mal1.add(3);
		mal1.add(4);mal1.add(5);mal1.add(6);

		MyArrayList<Integer> mal2 = (MyArrayList<Integer>)mal1.subList(0, mal1.size());
		for (Integer x : mal1) System.out.print(x + " ");
		System.out.println("\nТеперь по копии");
		for (Integer x : mal2) System.out.print(x + " ");
		System.out.println("\nОчищаем");
		mal1.clear();
		for (Integer x : mal1) System.out.print(x + " ");
		System.out.println("\nТеперь по копии");
		for (Integer x : mal2) System.out.print(x + " ");
		System.out.println("\n" + mal1.size());
		System.out.println(mal2.size());
		System.out.println("Снова добавим");
		mal1.add(11);mal1.add(12);mal1.add(13);
		mal1.add(14);mal1.add(15);mal1.add(16);
		for (Integer x : mal1) System.out.print(x + " ");
		System.out.println("\nТеперь по копии");
		for (Integer x : mal2) System.out.print(x + " ");
		System.out.println("\n" + mal1.size());
		System.out.println(mal2.size());
	}
}