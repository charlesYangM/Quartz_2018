/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package polymorphism.stringprocessor;

import polymorphism.interfaceprocessor.Processor;

/**
 * Created by CharlesYang on 2017/8/4.
 */
public class StringProcessor implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public String process(Object input) {
        return new String(swapStringPairToPair(((String) input)));
    }

    private char[] swapStringPairToPair(String s){
        char temp;
        char[] chars = s.toCharArray();
        try{
            for (int i = 0; (chars.length%2==0)?i<chars.length:i<chars.length-1;i=i+2){
                temp = chars[i];
                chars[i] = chars[i+1];
                chars[i+1] = temp;
            };
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("out of boundary  ,the length of char is "+ chars.length);
            System.err.println("failed due to "+e.toString());
        }finally {
            return chars;
        }
    }
}
