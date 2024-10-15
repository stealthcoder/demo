FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/demo-*.jar demo-app.jar

ENTRYPOINT [ "java", "-jar", "/app/demo-app.jar" ]