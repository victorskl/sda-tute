# Workshop 6 - Week 7

Patterns for Data-source Layer

- Pretty much observation on continuation of previous Workshop 5 - Week 6 on Hibernate; all about O/R mapping.
- Code are from tutorial provided `RequiredCode.zip` file; but with some modification to make it work.
- Reuse `HibernateExamples\lib` into this project classpath lib.
- Refer [HibernateExamples\README.md][1] on 
Database Development Perspective and Add **new Derby connection > New (Derby) Driver Definition** setup.

[1]: https://github.com/victorskl/sda-tute/blob/master/HibernateExamples/README.md

### Note that

This tute use Hibernate version 3; to be exact see below. So, if you look for Hibernate documentation, do trail version 3 or note this difference instance.
The latest version might have features that aren't available to version 3. Therefore, some part of the the tute become
obsolete to use with the current best available Hibernate version. However, the fundamental concept still hold and this is the
main purpose of the tute. 

```
 INFO [main] (Version.java:15) - Hibernate Annotations 3.4.0.GA
 INFO [main] (Environment.java:560) - Hibernate 3.3.2.GA
 INFO [main] (Environment.java:593) - hibernate.properties not found
 INFO [main] (Environment.java:771) - Bytecode provider name : javassist
 INFO [main] (Environment.java:652) - using JDK 1.4 java.sql.Timestamp handling
 INFO [main] (Version.java:14) - Hibernate Commons Annotations 3.1.0.GA
```

### Activity 3.2: Splitting a single object across multiple tables

- use case: for the horizontal scaling data

### Activity 3.3: One table from two or more objects

- use case: badly design table, legacy database

### Activity 4.1: Foreign key mapping - one-to-one unidirectional relationship

- use case: most cases for forward OO software modeling for data(-base) modeling


### TODO

- Activity 4.3: Foreign key mapping - creating two classes with one-to-many relationships
- Additional activity: Inheritance Mapping