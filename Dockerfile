FROM openjdk:latest
COPY ./target/DevOpsLabs-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "DevOpsLabs-1.0-SNAPSHOT-jar-with-dependencies.jar"]