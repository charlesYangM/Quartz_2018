/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package polymorphism.filters;

/**
 * Created by CharlesYang on 2017/8/4.
 */
public class WaveForm {
    private  static long counter;
    private final long id = counter++;
    public String toString(){
        return "Wavaform "+ id;
    }

}
