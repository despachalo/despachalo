# BUILD JAR
FROM openjdk:17-jdk-slim as builder

WORKDIR /app/builder/

COPY . .

RUN ./gradlew assemble

FROM openjdk:17-jdk-slim as release

WORKDIR /app

COPY --from=builder /app/builder/build/libs/*.jar app.jar

EXPOSE 8080

VOLUME /app/logs

ENTRYPOINT ["java","-jar","app.jar"]
