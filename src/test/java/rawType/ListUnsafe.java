package rawType;

import java.util.List;
import com.google.common.collect.Lists;
/**
 * Created by CharesYang on 2017/7/26.
 */
public class ListUnsafe {
    public static void main(String[] args) {
        List<String> strings = Lists.newArrayList();

//        unsafeAdd(strings,new Integer(43));
        String s = strings.get(0);
    }
    private static void unsafeAdd(List<Object> list,Object o ){
        list.add(o);
    }
}
