/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package polymorphism.interfaceprocessor;

/**
 * Created by CharlesYang on 2017/8/4.
 */
public interface Processor {
    String name();
    Object process(Object input);
}
