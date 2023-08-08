# Use an OpenJDK image as the base image
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/backend-services.jar /app/backend-services.jar

# Expose the application port (change the port if necessary)
EXPOSE 8081

# Start the Spring Boot application
CMD ["java", "-jar", "backend-services.jar"]
