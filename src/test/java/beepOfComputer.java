//import org.xvolks.jnative.JNative;
//import org.xvolks.jnative.Type;
//import org.xvolks.jnative.exceptions.NativeException;
//
///**
// * Created by HP on 2017/6/20.
// */
//public class beepOfComputer {
//    public static void main(String[] args) throws IllegalAccessException, NativeException {
//        testBep2();
//    }
//
//    public static JNative getBeepJNative() throws NativeException {
//        return new JNative("kernel32.dll", "Beep");
//    }
//    public static void beep(JNative jn, int freq, int dwruration)throws NativeException, IllegalAccessException {
//        jn.setRetVal(Type.VOID);
//        jn.setParameter(0, freq);// 20--22000Hz
//        jn.setParameter(1, dwruration);
//        jn.invoke();
//    }
//    //奏响你的都来米吧
//    public static void testBep2() throws NativeException,
//            IllegalAccessException {
//        int freqs[] = { 523, 587, 659, 698, 784, 880, 998, 1047, 998, 880, 784,698,659,587,523 };
//        JNative jn = getBeepJNative();
//        for (int i = 0, l = freqs.length; i < l; i++) {
//            beep(jn, freqs[i], 500);
//        }
//    }
//}
