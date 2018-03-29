package com.example.redismybatisweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisMybatisWebApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void contextLoads() {

		ValueOperations<String,String> operations=redisTemplate.opsForValue();
		RedisSerializer<String> stringSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(stringSerializer );
		redisTemplate.setValueSerializer(stringSerializer );
		redisTemplate.setHashKeySerializer(stringSerializer );
		redisTemplate.setHashValueSerializer(stringSerializer );

		String key="test1";
		operations.set(key,"1");
		System.out.println(operations.get("test1"));
	}

}
