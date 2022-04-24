FROM maven:3.8.5-openjdk-17-slim as builder

COPY src /src
COPY pom.xml /

RUN mvn -f /pom.xml clean package -Dmaven.test.skip

FROM openjdk:18-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
COPY --from=builder /target/blogapi-0.0.1-SNAPSHOT.jar /home/spring/target/blogapi-0.0.1-SNAPSHOT.jar
USER spring:spring
ENTRYPOINT ["java","-jar","/home/spring/target/blogapi-0.0.1-SNAPSHOT.jar"]