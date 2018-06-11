package thread;

import util.CmdUtil;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by HP on 2017/7/20.
 */
public class testForCountDown {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        final CountDownLatch latch=new CountDownLatch(5);

        for (int i = 3 ;i<8 ;i++){
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);

                        //下面的代码用于对主线程通知，await等待通知
                        latch.countDown();
                        Thread.sleep(1000);
//                        SvnUserImplV1.getSingleInstanceFor86().updateProjectFromSvn(new File(WorkPathOF822+"\\autosolver-"+index+"\\application"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        latch.await();

        //如果不加下面这句话就会造成程序无法退出的现象
        fixedThreadPool.shutdown();
        System.out.println(latch.getCount());
    }
}
