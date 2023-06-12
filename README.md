# 瑞吉外卖项目笔记

## 7.28

P1 - P5

搭建好了数据库表与SpringBoot项目环境

1. 在映射==实体==或者==属性==时，将数据库中==表名==和==字段名==中的下划线去掉，按照驼峰命名法映射

   ```yml
   mybatis-plus:
     configuration:
       map-underscore-to-camel-case: true
   ```

   如表名：`address_book ---> AddressBook`

   字段名：`user_name ---> userName`

   ==**注意**==：mybatis-plus默认已经做好了这种映射关系

2. 在SpringMVC中，默认情况下只能访问`static`或者`template`目录下的静态资源。

   可以通过==配置类==来设置静态资源的映射，告诉SpringMVC这些目录下的资源直接放行

   ```java
   @Configuration
   public class WebMvcConfig extends WebMvcConfigurationSupport {
       /**
        * 设置静态资源映射
        */
       @Override
       protected void addResourceHandlers(ResourceHandlerRegistry registry) {
           registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
           registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
       }
   }
   ```

## 7.29

因为核酸检测没有做项目

## 7.30

P6 - P13

1. 如果实体类属性`userName`，表中字段`user_name`。此时MyBatis-Plus会==自动==将下划线命名风格转化为驼峰命名风格。（表名也如此）

2. + `@Mapper`是mybatis自身带的注解，用在dao层接口上，交给Spring容器管理。在spring程序中，mybatis需要找到对应的mapper，在编译时生成动态代理类，与数据库进行交互，这时需要用到@Mapper注解
   + 但是有时候当我们有很多mapper接口时，就需要写很多@Mappe注解，这样很麻烦，有一种简便的配置化方法便是在启动类上使用`@MapperScan("指定Mapper接口所在的包")`注解。

3. 如果前端传递过来的参数被封装成了`json`格式，则后端在接收时需要使用`@RequestBody`注解

4. md5加密：`DigestUtils.md5DigestAsHex()`

5. String的`getBytes()`方法是得到一个操作系统默认的编码格式的==字节数组==

6. 只有一个抽象方法的接口称为==函数式接口==，我们就能使用Lambda表达式。可以使用`@FunctionalInterface`注解来判断当前接口是否为函数式接口

7. 在`mybatisplus`的`LambdaQueryWrapper`中，为防止数组库表中的字段名写错，可以使用==函数式接口==来访问实体类中的某个属性所对应的字段名，当把属性访问之后就会==自动==地获取属性所对应的字段名来作为查询条件的字段

8. 在用户登录时，虽然最后返回了在数据库中查询到的登录用户的信息，前端根据这个信息确定登录的用户，但是还是需要提前一步把用户的id放入`session`，

   ![image-20220730230446517](https://threeshui.oss-cn-guangzhou.aliyuncs.com/img/notebook/reggie/image-20220730230446517.png)

   ![image-20220730230537332](https://threeshui.oss-cn-guangzhou.aliyuncs.com/img/notebook/reggie/image-20220730230537332.png)

## 7.31

P14 - P17

1. 如果方法没有返回值，则通过输出流给前端提供json数据

   ```java
   response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
   ```

2. 使用过滤器需要在springboot启动类上加上`@ServletComponentScan`注解才会生效

3. request.getRequestURL() 返回全路径

   request.getRequestURI() 返回除去host（域名或者ip）部分的路径

   > 例：输入的url地址为`http://localhost:8080/testproject/test?32fr`
   >
   > getRequestURI()返回`/testproject/test`，为一个String
   >
   > getRequestURL()返回`http://localhost:8080/testproject/test`，为一个StringBuffer

4. `AntPathMatcher`不仅可以匹配Spring的`@RequestMapping`路径，也可以用来匹配各种字符串，包括文件路径等。`match()`方法判断，第一个参数匹配的规则和第二个参数路径是否相等

   ```java
   // **匹配0个或多个目录
   pathMatcher.match("/admin/**", requestURI)
   ```


## 8.1

P18 - P35

1. `@RestControllerAdvice`的`annotations`参数指定一个或多个被这些注解所标记的 Controller 会被管理

   ```java
   @RestControllerAdvice(annotations = {RestController.class, Controller.class})
   ```

2. `@ExceptionHandler`注解中可以添加参数，参数是某个异常类的class，代表这个方法专门处理该类异常

   ```java
   @ExceptionHandler(RuntimeException.class)
   ```

3. SpringMVC使用默认的==消息转换器==将服务端的Java对象转为json数据响应给客户端，如果默认的不能满足要求，可以对其进行扩展。

   ![image-20220801234549316](https://threeshui.oss-cn-guangzhou.aliyuncs.com/img/notebook/reggie/image-20220801234549316.png)

## 8.2

P36 - P40

## 8.3

P41 - P52

1. Mybatis Plus**公共字段自动填充**，也就是在插入或者更新的时候为指定字段赋予指定的值，使用它的好处就是可以统一对这些字段进行处理，避免了重复代码。
   **实现步骤:**
   1、在实体类的属性上加入`@TableField`注解，指定自动填充的策略
   2、按照框架要求编写元数据对象处理器，在此类中统一为公共字段赋值，此类需要实现`MetaObjectHandler`接口

2. 使用**ThreadLocal**动态获取当前登录用户的id

   ![image-20220803164642362](https://threeshui.oss-cn-guangzhou.aliyuncs.com/img/notebook/reggie/image-20220803164642362.png)

   ![image-20220803164223313](https://threeshui.oss-cn-guangzhou.aliyuncs.com/img/notebook/reggie/image-20220803164223313.png)

   ![image-20220803164347913](https://threeshui.oss-cn-guangzhou.aliyuncs.com/img/notebook/reggie/image-20220803164347913.png)

   ![image-20220803164427454](https://threeshui.oss-cn-guangzhou.aliyuncs.com/img/notebook/reggie/image-20220803164427454.png)

3. 文件上传与下载

   ![image-20220804172458259](https://threeshui.oss-cn-guangzhou.aliyuncs.com/img/notebook/reggie/image-20220804172458259.png)

   ![image-20220804172534002](https://threeshui.oss-cn-guangzhou.aliyuncs.com/img/notebook/reggie/image-20220804172534002.png)

## 8.4

P53 - P54

晚上停电，学习中断。

## 8.5

P55 - P67

1. P57使用到了stream流，又是我不会的知识。

2. 拷贝属性

   ```java
   BeanUtils.copyProperties(dish, dishDto);
   ```

3. DTO，全称为`Data Transfer object`，即数据传输对象，一般用于展示层与服务层之间的数据传输

## 8.6

P68 - P74

## 8.7

1. 如果前端传递的参数是加载链接上的，当参数不止一个时，后端可以用数组直接接收，只需要数组名与前端保持一致。也可以用集合来接收，除了集合名保持一致外，还需要加`@RequestParam`注解。

## 8.8

1. 对于后端接收Json类型的参数，也可以使用Map来接收，添加`@RequestBody`注解时，会将其包装成LinkedHashMap对象

## 8.9

1. `AtomicInteger`是一个提供原子操作的`Integer`类，通过线程安全的方式操作加减。十分适合高并发情况下的使用

# 致谢

感谢黑马程序员赵老师：https://www.bilibili.com/video/BV13a411q753

# github地址

https://github.com/threeshui1024/reggie
