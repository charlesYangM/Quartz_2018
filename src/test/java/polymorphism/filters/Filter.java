/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package polymorphism.filters;

/**
 * Created by CharlesYang on 2017/8/4.
 */
public class Filter {
    public String name(){
        return getClass().getSimpleName();
    }
    public WaveForm process(WaveForm input){
        return input;
    }
}
