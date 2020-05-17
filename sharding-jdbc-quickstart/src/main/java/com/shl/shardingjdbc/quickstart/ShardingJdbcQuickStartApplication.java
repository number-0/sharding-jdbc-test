package com.shl.shardingjdbc.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author songhengliang
 * @date 2020/5/16
 */
@SpringBootApplication
//@SpringBootApplication(exclude = org.apache.shardingsphere.shardingjdbc.spring.boot.SpringBootConfiguration.class) 使用sharding-jdbc的java配置的时候需要排除SpringBootConfiguration.class
public class ShardingJdbcQuickStartApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShardingJdbcQuickStartApplication.class, args);
  }
}
