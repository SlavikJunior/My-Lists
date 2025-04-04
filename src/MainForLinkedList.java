package src;

import java.util.Arrays;

public class MainForLinkedList {

    public static void main(String[] args) {

        MyLinkedList<Integer> mll1 = new MyLinkedList<>();
        mll1.add(1);
        mll1.add(12);
        mll1.add(123);
        mll1.add(1234);

        System.out.println(mll1);
        Integer res = mll1.remove(0);
        System.out.println(mll1);
        System.out.println(res);
    }
}
