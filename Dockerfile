FROM openjdk:14-alpine
COPY build/libs/*.jar tourguide-rewrads-service.jar
EXPOSE 9003
ENTRYPOINT ["java", "-jar", "tourguide-rewards-service.jar"]