# Workshop 4 - Week 5: Introduction to the Spring Framework

- If you are using JDK1.8 (Java version 8), you should use [Spring Framework version 4][1].
- If you want to use the workshop provided Spring 3.2.0, you have to use JDK1.7 (Java version 7).
- If these versions do not match up, you will encounter this exception:
    
    Exception in thread "main" java.lang.IllegalArgumentException
        at org.springframework.asm.ClassReader.<init>(Unknown Source)

- This `SpringMVCDemo` project has already used [Spring 4][1].

[1]: https://repo.spring.io/release/org/springframework/spring/4.3.9.RELEASE/spring-framework-4.3.9.RELEASE-dist.zip


## Activity 4: Develop a simple Spring MVC application

- If you encounter `ClassNotFoundException` like below, make sure you build the project first, before `Run on Server` or add as module to Tomcat.

    org.springframework.beans.factory.CannotLoadBeanClassException: Cannot find class [com.swen90007.example1.HelloWorldController] for bean with name '/welcome.htm' defined in ServletContext resource [/WEB-INF/dispatcher-servlet.xml]; nested exception is java.lang.ClassNotFoundException: com.swen90007.example1.HelloWorldController
        org.springframework.beans.factory.support.AbstractBeanFactory.resolveBeanClass(AbstractBeanFactory.java:1385)
     
    java.lang.ClassNotFoundException: com.swen90007.example1.HelloWorldController
        org.apache.catalina.loader.WebappClassLoaderBase.loadClass(WebappClassLoaderBase.java:1285)

- Alternatively, you can turn on `Project > Build Automatically`. Usually this is the default, in case if you happen to turn off at some point.

![build-auto.png](https://www.dropbox.com/s/gfqjso367xfcdc4/build-auto.png?raw=1)

- Pro Tip: time to time, you might want to perform `Project > Clean` to clean and rebuild the classes.

![build-auto.png](https://www.dropbox.com/s/w27iuw8zynmd84y/build-clean.png?raw=1)

### Activity 4.7: Code-based approach AppInitializer

**Task:**

Code-based approach: Instead of the `web.xml`, the Dispatcher Servlet can be initialised by using `AppInitializer` which is a class that implements `WebApplicationInitializer` interface. Try to figure out how to use `WebApplicationInitializer` in your application.

**Response:**

This is implemented in `AppInitializer`. There are two more approaches in addition to the traditional XML-based `web.xml` approach.

1. The code-based approach with `WebApplicationInitializer` but still use of xml for Spring configuration.
2. A 100% code-based approach to configuration i.e. without use of any xml configurations.

Follow the comments in [`AppInitializer.java`](src/com/swen90007/example1/AppInitializer.java) to observe these different approaches.
