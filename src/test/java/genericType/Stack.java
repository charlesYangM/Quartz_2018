

/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package genericType;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> {
    private Object[] elements;
    private int size =0;
    private static final int DEFAULT_CAPACITY = 16;


    public Stack(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop(){
        if (size == 0){
            throw new EmptyStackException();
        }
        @SuppressWarnings("uncheced")
        E result = (E)elements[--size];

        elements[size] = null;
        return result;
    }
    private void ensureCapacity() {
        if (elements.length == 0){
            elements = Arrays.copyOf(elements,2*size+1);
        }
    }

    private boolean isEmpty(){
        return size == 0;
    }
    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.dir"));
        Stack<String> stringStack = new Stack<String>();
        for (String arg : args){
            stringStack.push(arg);
        }
        while(!stringStack.isEmpty()){
            System.out.println(stringStack.pop().toUpperCase());
        }
    }
}
