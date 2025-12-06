FROM eclipse-temurin:17-jdk
COPY ./target/*-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "DevOpsLabs-1.0.0.2-jar-with-dependencies.jar"]