/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package timeTest;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by CharlesYang on 2017/8/22.
 */
public class isMondayTest {
    public static void main(String[] args) {
        Date nowtime = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(nowtime);
        boolean monday = cal.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY;

        System.out.println(monday);
    }
}
