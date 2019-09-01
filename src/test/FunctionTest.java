package test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author : fanc
 * @Date : 2019-09-01 22:17
 */
public class FunctionTest {
    public static void addList(List<Integer> a) {
        a.add(5);
        a.add(6);
        a.remove(a.indexOf(6));
    }
    public static void main(String[] args) {
        List<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(2);
        addList(a);
        System.out.println(a);

    }
}
