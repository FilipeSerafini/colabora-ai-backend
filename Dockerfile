FROM openjdk:22-jdk-slim

WORKDIR /app

COPY pom.xml /app/
COPY src /app/src/
COPY src/main/resources/.env /app/src/main/resources/.env

RUN apt-get update && \
    apt-get install -y maven && \
    mvn dependency:go-offline

RUN mvn package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/colaboraai-0.0.1-SNAPSHOT.jar"]