FROM openjdk:17-jdk-slim
ADD target/hunt-back.jar hunt-back.jar
ENTRYPOINT ["java", "-jar","hunt-back.jar"]
EXPOSE 8080