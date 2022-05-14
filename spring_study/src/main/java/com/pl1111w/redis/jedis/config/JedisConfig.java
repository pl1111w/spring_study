package com.pl1111w.redis.jedis.config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/5/14 12:48
 */
public class JedisConfig {

    private static JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMinIdle(2);
        jedisPoolConfig.setMaxIdle(4);
        jedisPoolConfig.setMaxTotal(12);
        jedisPoolConfig.setMaxWaitMillis(2000);
        jedisPool = new JedisPool(jedisPoolConfig, "192.168.1.13", 6379, 1000, "Weixb4818");
    }

    public static Jedis getJedis() {
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }
}
