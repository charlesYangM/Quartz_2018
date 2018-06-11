/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package polymorphism.interfaceprocessor;

import polymorphism.Apply;
import polymorphism.filters.Filter;
import polymorphism.filters.LowPass;
import polymorphism.filters.WaveForm;

/**
 * Created by CharlesYang on 2017/8/4.
 */
class FilterAdapter implements Processor{
    Filter filter;
    public FilterAdapter(Filter filter){
        this.filter = filter;
    }
    @Override
    public String name(){
        return filter.name();
    }

    @Override
    public WaveForm process(Object input) {
        return filter.process((WaveForm)input);
    }

}
public class FilterProcessor{
    public static void main(String[] args) {
        WaveForm w  = new WaveForm();
        Apply.process(new FilterAdapter(new LowPass(1.0)),w);
    }
}
