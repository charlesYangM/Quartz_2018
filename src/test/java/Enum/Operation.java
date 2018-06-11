/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package Enum;

/**
 * Created by CharlesYang on 2017/7/31.
 */
public enum Operation {
    PLUS("+") {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    };

    private final String symble;

    Operation(String symble) {
        this.symble = symble;
    }

    @Override public String toString(){
        return symble;
    }
    abstract double apply(double x, double y);

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        for (Operation op : Operation.values()){
            System.out.printf("%f %s %f = %f%n",x,op,y,op.apply(x,y));
        }
    }
}
