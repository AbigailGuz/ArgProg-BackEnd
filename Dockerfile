FROM amazoncorretto:11-alpine-jdk
MAINTAINER AbigailGuzman
COPY targer/abigailGuzman-0.0.1-SNAPSHOT.jar abigailguzman-app.jar
ENTRYPOINT["java","-jar","/abigailguzman-app.jar"]