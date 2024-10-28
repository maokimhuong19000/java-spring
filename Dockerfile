# Use the latest Ubuntu image as the build stage
FROM ubuntu:latest AS build

WORKDIR /app

RUN apt-get update && \
    apt-get install -y openjdk-21-jdk gradle

COPY . .

RUN ./gradlew bootJar --no-daemon

FROM openjdk:21-jdk-slim


WORKDIR /app


EXPOSE 8081

COPY --from=build /app/build/libs/coffee-shop.jar app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]
