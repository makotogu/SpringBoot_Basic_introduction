package com.example.springbootenable;

import com.example.springbootenableother.config.EnableUser;
import com.example.springbootenableother.config.MyImportBeanDefinitionRegistrar;
import com.example.springbootenableother.config.MyImportSelector;
import com.example.springbootenableother.config.UserConfig;
import com.example.springbootenableother.domain.Role;
import com.example.springbootenableother.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @ComponentScan 扫描范围是当前引导类及其子包
 *
 *
 * 1. 使用@ComponentScan
 * 2. 可以使用@Import注解，加载类。这些类都会被Spring创建，并放入IOC容器
 * 3. 对import注解进行封装
 */

/**
 * import4种用法
 * 1. 导入Bean
 * 2. 导入配置类
 * 3. 导入ImportSelector的实现类
 * 4. 导入ImportBeanDefinitionRegistrar实现类
 */


@SpringBootApplication
//@ComponentScan("com.example.springbootenableother.config")
//@Import(UserConfig.class)
//@EnableUser
//@Import(User.class)
//@Import(MyImportSelector.class)
@Import({MyImportBeanDefinitionRegistrar.class})
public class SpringBootEnableApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringBootEnableApplication.class, args);

       /* Object user = context.getBean("user");
        System.out.println(user);*/

       //User user = context.getBean(User.class);
       //System.out.println(user);
       //Role role = context.getBean(Role.class);
       //System.out.println(role);

        //Map<String, User> map = context.getBeansOfType(User.class);
        //System.out.println(map);

        Jedis jedis = context.getBean(Jedis.class);
        System.out.println(jedis);
        Map<String, String> user = jedis.hgetAll("user");
        System.out.println(user);
    }

    @Bean
    public Jedis jedis(){
        return new Jedis("localhost",6379);
    }
}
