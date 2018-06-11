/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package polymorphism.filters;

/**
 * Created by CharlesYang on 2017/8/4.
 */
public class LowPass extends Filter{
    double cutoff;
    public LowPass(double cutoff){
        this.cutoff = cutoff;
    }
    public WaveForm process(WaveForm input){
        return input;
    }
    

}
