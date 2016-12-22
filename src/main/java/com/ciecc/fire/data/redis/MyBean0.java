package com.ciecc.fire.data.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyBean0 {

	// Spring Boot为Jedis客户端库提供了基本的自动配置，并在Spring Data Redis提供的基础上提供了抽象。
	private StringRedisTemplate template;

	@Autowired
	public MyBean0(StringRedisTemplate template) {
		// 默认情况下，实例将尝试使用localhost连接到Redis服务器：6379：

		this.template = template;
		// 如果你添加一个自己的任何自动配置的类型的@Bean它将替换默认值（除了在RedisTemplate的情况下，排除基于bean名称'redisTemplate'而不是其类型）。
		// 如果commons-pool2在类路径上，你将默认得到一个池连接工厂。
	}
}
