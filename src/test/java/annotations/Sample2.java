/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package annotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharlesYang on 2017/8/2.
 *
 */
public class Sample2 {
    @ExceptionTest(ArithmeticException.class)
    public static void m1() {//Test should pass
        int i = 0;
        i = i/i;
    }
    @ExceptionTest(ArithmeticException.class)
    public static void m2() {
        int[] a = new int[0];
        int i = a[1];
    }
    @ExceptionTest(ArithmeticException.class)
    public void m3(){

    }
    @ExceptionTest({IndexOutOfBoundsException.class,NullPointerException.class})
    public static void doublyBad(){
        List<String> list = new ArrayList<String>();

        list.addAll(5,null);
    }
}
