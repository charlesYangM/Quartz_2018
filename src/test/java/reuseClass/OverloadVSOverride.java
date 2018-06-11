package reuseClass;

/**
 * Created by CharlesYang on 2017/7/26.
 */
class OverloadVSOverride extends OverloadClass{
    public static void main(String[] args) {
        OverloadVSOverride overloadVSOverride = new OverloadVSOverride();
        overloadVSOverride.print(2);
    }
    @Override
    void print(int i){
        System.out.println("print with int2");
    }
}

class OverloadClass {
    void print(String s){
        System.out.println("print with s");
    }
    void print(char s){
        System.out.println("print with char");
    }
    void print(int i){
        System.out.println("print with int1");
    }
}