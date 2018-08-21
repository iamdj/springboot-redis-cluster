package com.iamdj.redis.rediscluster.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.Arrays;
import java.util.List;

@Configuration
public class RedisClusterConfigurationProperties {

    /**
     * 获取redis集群地址
     */
    @Value("${spring.redis.cluster.nodes}")
    private String nodes;

    /**
     * 初始化RedisConnectionFactory
     * @return
     */
    @Bean
    public RedisConnectionFactory connectionFactory() {
        String[] nodeArr = nodes.split(",");
        List<String> nodeList = Arrays.asList(nodeArr);
        return new JedisConnectionFactory(new RedisClusterConfiguration(nodeList));
    }
}
