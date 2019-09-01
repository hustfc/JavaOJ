package test;

import java.util.*;

/**
 * @Author : fanc
 * @Date : 2019-09-01 21:12
 */
public class CopyTest {
    public static void main(String[] args) {
        List<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(2);
        List<Integer> b = new LinkedList<>(a);
        b.set(0, 3);
        List<Integer> c = new LinkedList<>();
        c.addAll(a);
        c.set(0, 4);
        List<Integer> d = a;
        d.set(0, 5);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

    }

}

