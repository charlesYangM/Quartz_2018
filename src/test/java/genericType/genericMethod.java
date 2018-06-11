/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package genericType;

import org.junit.Test;

import java.util.*;

/**
 * Created by CharlesYang on 2017/7/27.
 */
public class genericMethod {
    public static void main(String[] args) {
//        System.out.println(max(Arrays.asList("nlp","nlo", "nlu")));
        testUnionSet();
        List<String> list = Arrays.asList("nlp", "nlo", "nlu");
        swap(list,1,2);
        System.out.println(list);
    }
    @Test
    public  void testGenericSingleton(){
        String[] strings ={"jute","hemp","nylon"};
        UnaryFunction<String> sameString = identityFunction();
        for (String s : strings){
            System.out.println(sameString.apply(s));
        }

        Number[] numbers = {1,2.0,3L};
        UnaryFunction<Number> sameNumber = identityFunction();
        for (Number n : numbers){
            System.out.println(sameNumber.apply(n));
        }

    }
    public static void testUnionSet(){
        Set<String> guys = new HashSet<>(
                Arrays.asList("Tom","Dick","Harry")
        );
        Set<String> stooges = new HashSet<>(
                Arrays.asList("Larry","Moe","Curly")
        );

        Set<String> aflCio = Union.union(guys, stooges);

        System.out.println(aflCio);
    }
    public static void testUnionSetWithDifferType(){
        Set<Integer> guys = new HashSet<>(
                Arrays.asList(2,1,3)
        );
        Set<Double> stooges = new HashSet<>(
                Arrays.asList(2.0,2.3,2.5)
        );

        Set<Number> aflCio = Union.<Number>union(guys, stooges);

        System.out.println(aflCio);
    }

    public interface UnaryFunction<T>{
        T apply(T arg);
    }

    private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
        @Override
        public Object apply(Object arg) {
            return arg;
        }
    };

    @SuppressWarnings("unchecked")
    public static <T> UnaryFunction<T> identityFunction(){
        return (UnaryFunction<T>) IDENTITY_FUNCTION;
    }

    private static <T extends Comparable<T>> T max1(List<T> list){
        Iterator<T> i = list.iterator();
        T result = i.next();
        while (i.hasNext()){
            T o = i.next();
            if (o.compareTo(result)>0){
                result = o;
            }
        }
        return result;
    }
    public static <T extends Comparable<? super T>> T max(List<? extends T> list){
        Iterator<? extends T> i = list.iterator();
        T result = i.next();
        while (i.hasNext()){
            T o = i.next();
            if (o.compareTo(result)>0){
                result = o;
            }
        }
        return result;
    }

    static class Union {
        public static <E> Set<E> union(Set<? extends E> s1 ,Set<? extends E> s2){
            Set<E> result = new HashSet<>(s1);
            result.addAll(s2);
            return result;
        }

    }

    public static void swap(List<?> list ,int i,int j){
        swapHelper(list,i,j);
    }

    private static <E> void swapHelper(List<E> list,int i,int j){
        list.set(i,list.set(j,list.get(i)));
    }
}
