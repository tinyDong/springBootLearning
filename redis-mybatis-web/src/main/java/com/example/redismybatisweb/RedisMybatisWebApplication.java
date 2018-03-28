package com.example.redismybatisweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("com.example.redismybatisweb.mapper")
public class RedisMybatisWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisMybatisWebApplication.class, args);
	}
}
