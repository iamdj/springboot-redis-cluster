package com.iamdj.redis.rediscluster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    /**
     * 注入RedisConnectionFactory
     */
    @Autowired
    private RedisConnectionFactory connectionFactory;

    @GetMapping("/getRedis")
    public String getRedis() {
        // 获取集群连接
        RedisClusterConnection connection = connectionFactory.getClusterConnection();
        // 放入值
        connection.set("llcoding".getBytes(), "www.llcoding.com".getBytes());
        // 获取值并返回
        return new String(connection.get("llcoding".getBytes()));
    }

}
