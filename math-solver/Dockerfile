# --- Stage 1: Build the application with Maven ---
# Use a specific Maven version with OpenJDK 17 for a reproducible build
FROM maven:3.9.6-eclipse-temurin-17-focal AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project definition file and wrapper files
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
COPY mvnw.cmd .

# Download dependencies first to leverage Docker layer caching
# Use a simple pom copy if you don't use the wrapper
RUN mvn dependency:go-offline

# Copy the rest of the application source code
COPY src ./src

# Build the application, creating the executable .jar file. Skip tests for faster builds.
RUN mvn package -DskipTests


# --- Stage 2: Create the final, lightweight runtime image ---
# Use a minimal Java Runtime Environment (JRE) image for a small footprint
FROM eclipse-temurin:17-jre-jammy

# Set the working directory
WORKDIR /app

# Copy only the built .jar file from the 'build' stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the application runs on (Render will use this)
EXPOSE 8080

# The command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
