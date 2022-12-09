# Microservice-marianoMatesanz-hexagonal

We will build a **Spring Boot Rest API** for Inditex.

**H2 Database**, *it is also known as an Embedded Java Database*, for persisting(storing) the data.

## Documentacion API

 - Open API: http://localhost:8080/app/price-docs
 - Swagger UI: http://localhost:8080/app/swagger-ui/index.html

## Requirements

- [JDK 1.8+](https://www.oracle.com/java/technologies/javase-downloads.html) - Java™ Platform, Standard Edition
  Development Kit
- [Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new
  Spring Applications
- [Maven](https://maven.apache.org/) - Dependency Management (This comes in-built in Spring Boot package)
- [Tomcat](http://tomcat.apache.org/) - The Apache Tomcat® is a Java Servlet container used as web server for running
  the application (This comes in-built in Spring Boot package)


## Running the application locally

There are several ways to run a Spring Boot application on your local machine.

### Using Main method

Clone the repository to your local drive.

```shell
git clone https://github.com/prasbhat/microservice-springboot-h2.git
```

Import the project as "Maven Project" into your favourite IDE and execute the `main` method in
the  `MicroserviceSpringbootH2Application` class from your IDE.

`Right Click on the file and Run as Java Application`

### Running the application with Maven

Alternatively you can use
the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html)
like:

```shell
git clone https://github.com/prasbhat/microservice-springboot-h2.git
cd microservice-springboot-h2
mvn spring-boot:run
```

### Running the application with Executable JAR

The code can also be built into a jar and then executed/run. Once the jar is built, double-click on the jar and run or by using the command:

```shell
git clone https://github.com/prasbhat/microservice-springboot-h2.git
cd microservice-springboot-h2
mvn package -DskipTests
java -jar target/microservice-springboot-h2-0.0.1-SNAPSHOT.jar
```

More detailed documentation regarding this project can be 
found [here](https://marianoMatesanz.com/post/microservice-springboot-h2/).