# Use the official OpenJDK 17 image as a base image
FROM eclipse-temurin:17-jre-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY target/blogs-api-0.0.1-SNAPSHOT.jar blogs-api-0.0.1-SNAPSHOT.jar

# Get the value from the system environment and set it as an environment variable
ARG X_API_KEY_THE_BASICS
ENV X_API_KEY_THE_BASICS=${X_API_KEY_THE_BASICS}

# Expose the port that your Spring Boot application runs on
EXPOSE 9000

# Command to run your application
CMD ["java", "-jar", "blogs-api-0.0.1-SNAPSHOT.jar"]
