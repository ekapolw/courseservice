FROM openjdk:8u111-jdk-alpine
VOLUME /tmp
EXPOSE 9999
ARG JAR_FILE=/target/courseservice-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} courseservice.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dserver.port=9999","-jar","/courseservice.jar"]