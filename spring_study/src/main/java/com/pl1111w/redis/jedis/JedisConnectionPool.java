package com.pl1111w.redis.jedis;

import redis.clients.jedis.Jedis;

import static com.pl1111w.redis.jedis.config.JedisConfig.getJedis;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/5/13 14:44
 */
public class JedisConnectionPool {

    public static void main(String[] args) {
        Jedis jedis = getJedis();
        jedis.set("k1","v01");
        System.out.println(jedis.get("k1"));
        jedis.hset("hk1","h01","v01");
        jedis.close();
    }
}
