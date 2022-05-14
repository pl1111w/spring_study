package com.pl1111w.redis.jedis;

import redis.clients.jedis.Jedis;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/5/13 14:44
 */
public class JedisConnection {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.13", 6379);
        jedis.auth("Weixb4818");
        jedis.select(0);
        jedis.set("k1","v1");
        System.out.println(jedis.get("k1"));
        jedis.hset("hk1","h1","v1");
        jedis.close();
    }
}
