FROM openjdk:8-jre
MAINTAINER Grain Stark <palagend@icloud.com>

ARG JAR_FILE
ADD target/${JAR_FILE} /app/app.jar
EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]
