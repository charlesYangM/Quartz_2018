/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package annotations;
import java.lang.reflect.*;
/**
 * Created by CharlesYang on 2017/8/2.
 */
public class RunTests {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests=0;
        int passed=0;
        Class testClass = Class.forName(args[0]);
        for (Method m : testClass.getDeclaredMethods()){
//            if (m.isAnnotationPresent(Test.class)){
            if (m.isAnnotationPresent(ExceptionTest.class)){
                tests++;
                try{
                    m.invoke(null);
                    System.out.printf("Tests % s failed : no exception %n",m);
                } catch (InvocationTargetException e) {
                    Throwable exc = e.getCause();
                    Class<? extends Exception>[] excTypes = m.getAnnotation(ExceptionTest.class).value();
                    int oldPassed = passed;
                    for (Class<? extends Exception> excType : excTypes){
                        if (excType.isInstance(exc)){
                            passed++;
                        }
                    }
                   if (passed == oldPassed){
                        System.out.printf("Test %s failed:%s %n",m,exc);
                    }

                } catch (Exception e) {
                    System.out.println("INVALID @test: "+m);
                }
            }

        }
        System.out.printf("Passed : %d,failed: %d %n", passed, tests - passed);
    }
}
