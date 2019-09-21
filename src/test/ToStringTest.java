package test;

import java.util.Objects;

/**
 * @Author : fanc
 * @Date : 2019-09-15 21:04
 */
public class ToStringTest {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println(a + b);
        System.out.println(new Integer(a).toString() + new Integer(b).toString());
        System.out.println(Objects.toString(a) + Objects.toString(b));
    }
}
