/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package polymorphism;

import polymorphism.interfaceprocessor.Processor;
import polymorphism.stringprocessor.StringProcessor;

import java.util.Arrays;

/**
 * Created by CharlesYang on 2017/8/4.
 */
public class Apply {
    public static void process(Processor p ,Object s){
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
    public static String s  = "Disagreement with belifes ";
    public static void main(String[] args) {
        process(new StringProcessor(),s);
//        process(new Upcase(),s);
//        process(new Splitter(),s);
    }
}
class Upcase implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    public String process(Object input){
        return ((String)input).toUpperCase();
    }
}
class Splitter implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    public String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }
}
