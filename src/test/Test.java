package test;
import java.util.*;

/**
 * @Author : fanc
 * @Date : 2019-09-15 22:43
 */
public class Test {
    public static void main(String[] args) {
        // 常量池
        Long a = 1L, b = 1L;
        // 堆
        Long c = new Long(1);
        Long d = new Long(1);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(c == d);
        System.out.println(c.equals(d));
    }
}
