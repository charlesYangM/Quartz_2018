/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package polymorphism.filters;

/**
 * Created by CharlesYang on 2017/8/4.
 */
public class HighPass extends Filter {
    double cutoff;
    public  HighPass(double cutoff){
        this.cutoff = cutoff;
    }
    public WaveForm process(WaveForm input){
        return  input;
    }
}
