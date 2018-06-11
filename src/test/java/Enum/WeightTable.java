/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package Enum;

/**
 * Created by CharlesYang on 2017/7/31.
 */
public class WeightTable {
    public enum Planet{
        MERCURY(3.302E+23,2.439e6),
        MARS(6.419e+23,3.393e6),
        EARTH(5.975E+24,6.378E6);


        private final double mass;
        private final double radius;
        private final double surfaceGravity;

        private static final double G = 6.67300E-11;

        Planet(double mass,double radius){
            this.mass = mass;
            this.radius = radius;
            surfaceGravity = G * mass / (radius*radius);

        }

        public double getMass(){
            return mass;
        }
        public double getRadius(){
            return radius;
        }
        public double getSurfaceGravity(){
            return surfaceGravity;
        }

        public double surfaceWeight(double mass){
            return mass*surfaceGravity;
        }

    }

    public static void main(String[] args) {
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight / Planet.EARTH.getSurfaceGravity();
        for (Planet p : Planet.values()){
            System.out.printf("Weight on %s is %f %n",p,p.surfaceWeight(mass));
        }
    }
}
