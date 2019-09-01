package test;

import java.util.Arrays;

/**
 * @Author : fanc
 * @Date : 2019-09-01 21:49
 */
public class ArrayCopyTest {
    public static void main(String[] args) {
        int[] a1 = {-1, 2, 3};
        //浅拷贝
        int[] a2 = a1;
        a2[0] = 2;
        //深拷贝
        int[] a3 = a1.clone();
        a3[0] = 3;
        System.out.println("a1" + Arrays.toString(a1));
        System.out.println("a2" + Arrays.toString(a2));
        System.out.println("a3" + Arrays.toString(a3));
        int[] a4 = new int[10];
        System.arraycopy(a1, 1, a4, 3, 2);
        System.out.println("a4" + Arrays.toString(a4));
        int[] a5 = Arrays.copyOf(a1, 2);
        System.out.println("a5" + Arrays.toString(a5));
    }


}
