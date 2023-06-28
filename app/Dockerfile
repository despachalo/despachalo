# BUILD JAR
FROM eclipse-temurin:17-jdk-jammy AS builder

WORKDIR /app/builder/

COPY . .

RUN ./gradlew bootJar

FROM eclipse-temurin:17-jre-jammy AS release

WORKDIR /app

RUN addgroup runner; adduser  --ingroup runner --disabled-password runner
USER runner

COPY --from=builder /app/builder/build/libs/*.jar app.jar

EXPOSE 8080

VOLUME /app/logs

ENTRYPOINT ["java","-jar","app.jar"]
