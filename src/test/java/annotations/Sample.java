/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package annotations;

/**
 * Created by CharlesYang on 2017/8/2.
 *
 */
public class Sample {
    @Test
    public static void m1() {

    }
    @Test
    public static void m3() {
        throw new RuntimeException("Boom");
    }
    @Test public void m5(){}
}
