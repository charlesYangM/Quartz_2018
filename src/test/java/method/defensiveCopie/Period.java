/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package method.defensiveCopie;

import java.util.Date;

/**
 * Created by CharlesYang on 2017/8/4.
 */
public class Period {
    private final Date start;
    private final Date end;

    public Period(Date start,Date end) {
        if (start.compareTo(end)>0){
            throw new IllegalArgumentException(start +"after " + end);
        }
        this.end = end;
        this.start = start;
    }
    public Date getStart(){
        return  this.start;
    }
    public Date getEnd(){
        return  this.end;
    }

    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start,end);
        end.setYear(78);
    }
}
