FROM openjdk:14-alpine
COPY build/libs/*.jar tourguide-rewards-service.jar
EXPOSE 9003
ENTRYPOINT ["java", "-jar", "tourguide-rewards-service.jar"]