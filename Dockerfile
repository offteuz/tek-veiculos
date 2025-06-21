FROM maven:3.8.4-openjdk-17 as builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/target/tekveiculos-0.0.1-SNAPSHOT.jar /app/tekveiculos.jar

CMD ["java", "-jar", "/app/tekveiculos.jar"]

EXPOSE 8081