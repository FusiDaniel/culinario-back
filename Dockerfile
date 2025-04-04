FROM ubuntu:latest AS build

ARG JKS_FILE_SOURCE
ARG JKS_FILE_DESTINATION
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .
COPY ${JKS_FILE_SOURCE} ${JKS_FILE_DESTINATION}

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/*.jar app.jar
ENTRYPOINT [ "java","-jar", "app.jar" ]