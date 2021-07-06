# SpringBoot高级

## SpringBoot原理分析

### SpringBoot自动配置

#### Condition

* condition是spring 4.0增加的条件判断功能，通过这个功能可以实现选择性创建Bean操作
* SpringBoot是如何知道需要创建哪个Bean的？
* 案例：
  * 在Spring的IOC容器中有一个User的Bean，现在要求：
    * 导入Jedis坐标后，加载Bean，没导入，则不加载。

### 切换内置web服务器

* SpringBoot的web默认使用tomcat，作为内置服务器，其实SpringBoot提供了4中内置服务器供我们选择，我们可以很方便的进行切换。

### @Enable*注解

* SpringBoot中提供了很多Enable开头的注解，这些注解都是用于动态启用某些功能的。而其底层原理是使用@Import注解导入一些配置类，实现Bean的动态加载
* SpringBoot是否可以直接读取jar包中定义的Bean？ 不能

### @Import注解

* @Enable*底层依赖于@Import导入的类会被Spring加载到IOC容器中，而@Import提供4种用法：
  1. 导入Bean
  2. 导入配置类
  3. 导入ImportSelector实现类，一般用于加载配置文件中的类
  4. 导入ImportBeanDefinitionRegistrar实现类

### @EnableAutoConfiguration 注解

* @EnableAutoConfiguration注解内部使用@Import(AutoConfigurationImportSelector.class)来加载配置类。
* 配置文件位置：META-INF/spring.factories，该配置文件中定义了大量的配置类，当SpringBoot启动时，会自动加载这些配置类，初始化Bean
* 并不是所有的Bean都会被初始化，在配置类中使用Condition来加载满足条件的Bean

### 案例需求：

* 自定义redis-starter，要求当导入redis坐标时，SpringBoot自动创建Jedis的Bean
* 实现步骤
  1. 创建redis-spring-boot-autoconfigure模块
  2. 创建redis-spring-boot-starter模块，依赖redis-spring-boot-autoconfigure模块
  3. 在redis-spring-boot-autoconfigure模块中初始化Jedis的bean，并定义META-INF/spring.factories文件

### SpringBoot监听机制

#### Java监听机制

* SpringBoot的监听机制，其实是对Java提供的事件监听机制的封装
* Java中的事件监听机制定义了以下几个角色
  1. 事件：Event，继承java.util.EventObject类的对象
  2. 事件源：Source，任意对象Object
  3. 监听器：Listener，实现java.util.EventListener接口的对象

#### SpringBoot 监听机制

* SpringBoot在项目启动时，会对几个监听器进行回调，我们可以实现这些监听器接口，在项目启动时完成一些操作
* ApplicationContextInitializer、SpringApplicationRunListener、CommandLineRunner、ApplicationRunner

### SpringBoot启动流程分析

![SpringBoot启动流程](D:\Java_SSM\SpringBoot\note\SpringBoot启动流程.png)

## SpringBoot监控

### SpringBoot监控概述

* SpringBoot自带监控功能Actuator，可以帮助实现对程序内部运行情况监控，比如监控状况、Bean加载情况、配置属性、日志信息等

### SpringBoot监控 Spring Boot Admin

* Spring Boot Admin是一个开源社区项目 用于管理和监控SpringBoot应用程序
* Spring Boot Admin有两个角色，客户端(Client)和服务端(Server)
* 应用程序作为Spring Boot Admin Client 向Spring Boot Admin Server注册
* Spring Boot Admin Server 的UI界面将Spring Boot Admin Client 的Actuator Endpoint上的一些监控信息
* 使用步骤
  * admin-server
    1. 创建admin-server模块
    2. 导入依赖坐标admin-starter-server
    3. 在引导类上启用监控功能@EnableAdminServer
  * admin-client
    1. 创建admin-client模块
    2. 导入依赖坐标admin-starter-client
    3. 配置相关信息：server地址等
    4. 启动server和client服务，访问server

## SpringBoot项目部署

* SpringBoot项目开发完毕后，支持两种方式部署到服务器：
  1. jar（官方推荐）
  2. war

