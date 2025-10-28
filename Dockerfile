# Build stage
#
FROM maven:4.0.0-openjdk-21 AS build
COPY . .
RUN mvn clean install

#
# Package stage
#
FROM eclipse-temurin:21-jdk
COPY --from=build /target/SpringMVC-0.0.1-SNAPSHOT.jar SpringMVC-0.0.1-SNAPSHOT.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","SpringMVC-0.0.1-SNAPSHOT.jar"]

