FROM openjdk:8u111-jdk-alpine
VOLUME /tmp
EXPOSE 8888
ARG JAR_FILE=/target/courseservice-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} courseservice.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/courseservice.jar"]