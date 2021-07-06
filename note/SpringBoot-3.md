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

### SpringBoot监听机制

### SpringBoot启动流程分析

## SpringBoot监控

## SpringBoot项目部署

