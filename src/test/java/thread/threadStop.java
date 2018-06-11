package thread;

/**
 * Created by HP on 2017/7/12.
 */
public class threadStop {
    public static void main(String[] args) {

        Thread ta = new ThreadA();
        Thread tb = new ThreadB();

        ta.start();
        tb.start();
    }

    static class ThreadA extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 10000; i++){
                System.out.println("线程A "+i);
            }
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 10; i++){
                System.out.println("线程B "+i);

                if(i == 6){
                    System.out.println("程序强制退出");
                    System.exit(0);
                }
            }
        }
    }
}