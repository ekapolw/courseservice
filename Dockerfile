FROM openjdk:8u111-jdk-alpine
VOLUME /tmp
EXPOSE 9999
ADD courseservice.jar courseservice.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dserver.port=9999","-jar","/courseservice.jar"]
