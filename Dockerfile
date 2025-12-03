FROM eclipse-temurin:21-jdk
MAINTAINER dias
COPY build/libs/rpo-0.0.1-SNAPSHOT.jar rpo.jar
ENTRYPOINT ["java", "-jar", "rpo.jar"]