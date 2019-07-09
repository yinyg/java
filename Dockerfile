FROM openjdk:8-jdk-alpine

ADD ./target/JavaApplication.jar /app/
CMD ["java", "-Xmx500m", "-jar", "/app/JavaApplication.jar"]

EXPOSE 8081
