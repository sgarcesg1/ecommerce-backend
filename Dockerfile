#FROM openjdk:11-jre-ubuntu
FROM adoptopenjdk/openjdk11:jdk-11.0.10_9

RUN apt-get update
RUN apt-get install -y imagemagick

VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]