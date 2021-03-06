# Workshop 4 - Week 5: Introduction to the Spring Framework

- If you are using JDK1.8 (Java version 8), you should use [Spring Framework version 4][1].
- If you want to use the workshop provided Spring 3.2.0, you have to use JDK1.7 (Java version 7).
- If these versions do not match up, you will encounter this exception:
    ```
    Exception in thread "main" java.lang.IllegalArgumentException
        at org.springframework.asm.ClassReader.<init>(Unknown Source)
    ```
- This `SpringDemo` project has already used [Spring 4][1].

[1]: https://repo.spring.io/release/org/springframework/spring/4.3.9.RELEASE/spring-framework-4.3.9.RELEASE-dist.zip

## Activity 1: Creating objects using the Spring Bean Factory and ApplicationContext

Discussion:

What is the difference between BeanFactory and ApplicationContext in Spring framework?

:) 

Go run the `DrawingApp` and observe it, and then you can answer. These links might help understanding.

- https://stackoverflow.com/questions/9568042/what-is-application-context-and-bean-factory-in-spring-framework
- https://docs.spring.io/spring/docs/4.3.9.RELEASE/javadoc-api/org/springframework/context/ApplicationContext.html
- https://spring.io/understanding/application-context
- https://www.google.com.au/search?q=ApplicationContext
- https://www.google.com.au/search?q=BeanFactory

### NOTE

- This is not a Web Application. So Right Click on DrawingApp.java and Run as Java Application.
- This mainly explore the Spring core pattern and concept about Inversion of Control and Dependency Injection.
- The following an example output of a run.

```
Triangle drawn: using new keyword. Type is: null
Oct 29, 2017 1:00:54 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from file [D:\...\sda-tute\SpringDemo\spring.xml]
Triangle drawn: using BeanFactory. Type is: equilateral constructor
Oct 29, 2017 1:00:55 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@19bb089b: startup date [Sun Oct 29 13:00:54 AEDT 2017]; root of context hierarchy
Oct 29, 2017 1:00:55 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Triangle drawn: using ApplicationContext. Type is: equilateral constructor
x values are 0:-20:20
```
