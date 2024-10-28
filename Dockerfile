# Use the latest Ubuntu image as the build stage
FROM ubuntu:latest AS build

# Set the working directory
WORKDIR /app

# Update package list and install required packages
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk gradle  # Fixed the command to use '-y' properly

# Copy the project files to the working directory
COPY . .

# Build the application using Gradle
RUN ./gradlew bootJar --no-daemon

# Use a smaller base image for the runtime
FROM openjdk:21-jdk  # Change this to openjdk:21-jdk or openjdk:21-slim if it becomes available

# Set the working directory for the runtime container
WORKDIR /app

# Expose the application port
EXPOSE 8081

# Copy the jar file from the build stage to the runtime stage
COPY --from=build /app/build/libs/coffee-shop.jar app.jar  # Corrected the path

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
