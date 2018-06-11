/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

/**
 * Created by CharlesYang on 2017/8/17.
 */
public class SpeedTest {

    public static void main(String[] args) {
        int i,j;
        double d =0;
        int limit =6;
        long start , finish ;
        // begin testing
        start =System.currentTimeMillis();
        for(i=0;i<limit*10000;i++)
            for(j=0;j<10000;j++)
                d = d + 0.001;
        finish =System.currentTimeMillis();
        long time = finish - start;
        //output
        System.out.println("Time used:"+time+" ms");
        System.out.println("D value:"+d );
    }

}
