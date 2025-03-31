# Use OpenJDK 21 as the base image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the target directory
COPY target/key-value-cache-0.0.1-SNAPSHOT.jar app.jar

# Expose port 7171
EXPOSE 7171

# Run the application with explicit port setting
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=7171"]
