package redis;



import redis.clients.jedis.Jedis;

import java.util.Date;

/**
 * Created by CharlesYang on 2017/7/3.
 */
public class testConnection {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("172.16.8.6");
        System.out.println("redis 存储状态: "+ jedis.exists("autosolver"));
        System.out.println("redis 存储状态: "+ jedis.exists("autosolver2"));
        System.out.println("redis 存储状态: "+ jedis.exists("junior_solve"));

       //jedis.flushAll();
        System.out.println("redis 存储状态: "+ jedis.exists("autosolver"));
        System.out.println("redis 存储状态: "+ jedis.exists("autosolver2"));
        System.out.println("redis 存储状态: "+ jedis.exists("junior_solve"));
//        System.out.println("连接成功");
//        //查看服务是否运行
//        System.out.println("服务正在运行: "+jedis.ping());
//
//        jedis.set("runoobkey", "www.runoob.com");
//        // 获取存储的数据并输出
//        while (true){

//        }
//        System.out.println(new Date());
//
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(jedis.exists("autosolver"));
//        System.out.println(jedis.get);
    }

}
