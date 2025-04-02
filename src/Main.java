package src;

import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) {

		MyArrayListTest<Integer> malt1 = new MyArrayListTest<>();
		malt1.add(11);malt1.add(12);malt1.add(13);
		malt1.add(14);malt1.add(15);malt1.add(16);

//		System.out.println(malt1);
//		System.out.println("Size: " + malt1.size);
//		System.out.println("Удалим третий элемент (index = 2)");
//		Integer removed = malt1.remove(2);
//		System.out.println(malt1);
//		System.out.println("Size: " + malt1.size);
//		System.out.println(removed);

//		MyArrayListTest<Integer> malt2 = (MyArrayListTest<Integer>)
//				malt1.subList(1, malt1.size() - 1);
//
//		System.out.println("Вывожу первый");
//		System.out.println(malt1);
//		System.out.println("Вывожу второй");
//		System.out.println(malt2);
//
//		System.out.println("Очищаю основной список");
//		malt1.clear();
//
//		System.out.println("Вывожу первый");
//		System.out.println(malt1);
//		System.out.println("Вывожу второй");
//		System.out.println(malt2);

//		System.out.println("Размер первого: " + malt1.size());
//		System.out.println("Размер второго: " + malt2.size());

		//task1
		/* ArrayList<Double> malt1 = new ArrayList<>();
		malt1.add(3.14);
		malt1.add(2.89);
		malt1.add(10.15);
		malt1.add(10.14);
		MyDoubleComparator mdc =  new MyDoubleComparator(0.0001);
		System.out.println(malt1);
		Collections.sort(malt1, mdc);
		System.out.println(malt1);
		*/

		//task2
		/* ArrayList<Integer> malt2 = new ArrayList<>();
		malt2.add(400);
		malt2.add(20);
		malt2.add(10000);
		malt2.add(80);
		malt2.add(4000000);
		malt2.add(10000);
		System.out.println(malt2);
		MyIntegerComparator mic = new MyIntegerComparator();
		Collections.sort(malt2, mic);
		System.out.println(malt2);
 */
		//task3
/*		List<Student> list = reading();
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println("\nВывел исходный\n");
*/
		//task4
/*		MyStudentsFirstComparator msfc = new MyStudentsFirstComparator();
		Collections.sort(list, msfc);
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println("\nОтсортировал пофамильно\n");
*/
		//task5
/*		MyStudentsSecondComparator mssc = new MyStudentsSecondComparator();
		Collections.sort(list, mssc);
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println("\nОтсортировал по среднему баллу\n");
*/
	}
	
	private static List<Student> reading() {
		String path = "C:\\Users\\user\\Desktop\\Students.txt";
		List<Student> list = new ArrayList<>();
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			String line;
			while((line = bufferedReader.readLine()) != null) {
				String[] words = line.split("#");
				Student temp = new Student(
						words[0], words[1],
						words[2], Integer.parseInt(words[3]),
						Integer.parseInt(words[4]), Integer.parseInt(words[5]),
						Integer.parseInt(words[6]), Integer.parseInt(words[7])
				);
				list.add(temp);
			}
		} catch (IOException e) {
			System.out.println("Файл не найден!");
		}
		return list;
	}
}