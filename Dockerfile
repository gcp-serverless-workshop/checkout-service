# Use the official gradle 8.5 with Java 17 image to create a build artifact.
# https://hub.docker.com/_/gradle
FROM gradle:8.5-jdk17 AS build-env

# Set the working directory to /app
WORKDIR /app
# Copy the pom.xml file to download dependencies
#COPY build.gradle.kts ./
# Copy local code to the container image.
#COPY src ./src
COPY . .

# Download dependencies and build a release artifact.
# RUN gradle build -x test
RUN ./gradlew bootJar --no-daemon

# Use OpenJDK for base image.
# https://hub.docker.com/_/openjdk
# https://docs.docker.com/develop/develop-images/multistage-build/#use-multi-stage-builds
FROM eclipse-temurin:17-jre

# Copy the jar to the production image from the builder stage.
COPY --from=build-env /app/build/libs/app.jar /app.jar

#EXPOSE 8080

# Run the web service on container startup.
CMD ["java", "-jar", "/app.jar"]
