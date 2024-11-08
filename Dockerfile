# Step 1: Use a Maven image for building the application
FROM maven:3.9.9-eclipse-temurin-21 AS build
# Set the working directory
WORKDIR /app
# Copy only the pom.xml and download dependencies (caching layer)
COPY pom.xml .
RUN mvn dependency:go-offline -B
# Copy the source code
COPY src ./src
# Build the application
RUN mvn clean package -DskipTests

# Step 2: Use a lightweight JRE image for the runtime
FROM eclipse-temurin:21-jdk
# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]