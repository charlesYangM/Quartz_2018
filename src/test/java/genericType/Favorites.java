/*
 * Copyright (c) 2017. all the right belong to CharlesYang
 */

package genericType;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CharlesYang on 2017/7/28.
 */
public class Favorites {
    private Map<Class<?>,Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type ,T instance ){
        if (type == null){
            throw new NullPointerException("type is null");
        }
        favorites.put(type,type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        //底层代码会检查是获取的对象是否是type所代表的类
        return type.cast(favorites.get(type));
    }

    public static void main(String[] args) {
        Favorites favorites = new Favorites();
        favorites.putFavorite(String.class,"java");
        favorites.putFavorite(Class.class,Favorites.class);
        Class<?> favoriteClass = favorites.getFavorite(Class.class);
        String favoriteString = favorites.getFavorite(String.class);
        System.out.printf("%s  s %s", favoriteClass.getName(), favoriteString);
        System.out.println(Apple.FUJI.toString());
    }

    enum Apple{
        FUJI,PIPIN
    }
}
