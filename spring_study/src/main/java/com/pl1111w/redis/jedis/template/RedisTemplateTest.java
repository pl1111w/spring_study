package com.pl1111w.redis.jedis.template;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pl1111w.mybatis.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2022/5/14 20:59
 */
@RestController
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // JSON工具
     private static final ObjectMapper mapper = new ObjectMapper();

    @GetMapping("redis")
    public String getRedisValue() {
        redisTemplate.opsForValue().set("k2","v2");
        Employee employee = new Employee("zs",'M',"@145.com");
        redisTemplate.opsForHash().put("user001","001",employee);
        System.out.println(redisTemplate.opsForValue().get("k2"));
        System.out.println(redisTemplate.opsForHash().values("user001"));
        return "REDIS SUCCESS";
    }

    @GetMapping("redis_string")
    public String getRedisStringValue() throws IOException {
        stringRedisTemplate.opsForValue().set("k2","v2");
        Employee employee = new Employee("zs",'M',"@145.com");
        String writeValueAsString = mapper.writeValueAsString(employee);
        System.out.println(writeValueAsString);
        Employee student2 = mapper.readValue(writeValueAsString, Employee.class);
        System.out.println(student2);
        stringRedisTemplate.opsForHash().put("user001","001",writeValueAsString);
        System.out.println(stringRedisTemplate.opsForValue().get("k2"));
        List<Object> user001 = stringRedisTemplate.opsForHash().values("user001");
        System.out.println(user001.get(0));
        List<Employee> employees = mapper.readValue(user001.toString(), ArrayList.class);
        System.out.println(employees);
        return "REDIS_STRING SUCCESS";
    }
}
