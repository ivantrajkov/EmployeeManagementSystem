FROM maven:3.9-eclipse-temurin-17 as builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder /app/target/ems-backend-0.0.1-SNAPSHOT.jar ems-backend.jar

EXPOSE 8080

CMD ["java", "-jar", "ems-backend.jar"]
