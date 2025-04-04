package src;

import java.io.*;
import java.util.*;

public class MainForClassTasks {

    public static void main(String[] args) {

        //task1
		ArrayList<Double> malt1 = new ArrayList<>();
		malt1.add(3.14);
		malt1.add(2.89);
		malt1.add(10.15);
		malt1.add(10.14);
		MyDoubleComparator mdc =  new MyDoubleComparator(0.0001);
		System.out.println(malt1);
		Collections.sort(malt1, mdc);
		System.out.println(malt1);


        //task2
		 ArrayList<Integer> malt2 = new ArrayList<>();
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
		System.out.println();

        //task3
		List<Student> list = reading();
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println("\nВывел исходный\n");

		//task4
		Collections.sort(list);
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println("\nОтсортировал пофамильно\n");

		//task5
		Comparator<Student> mssc = new Comparator<>() {
			@Override
			public int compare(Student s1, Student s2) {
				double s1am = s1.getAverageMark();
				double s2am = s2.getAverageMark();

				double pogreshnost = 0.001;
				double resAbs = Math.abs(s1am - s2am);
				if (resAbs <= pogreshnost) {
					return 0;
				}
				else if (s1am > s2am)
					return 1;
				else
					return - 1;
			}
		};

		Collections.sort(list, mssc);
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println("\nОтсортировал по среднему баллу\n");

    }

    private static List<Student> reading() {
        String path = "res/Students.txt";
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
