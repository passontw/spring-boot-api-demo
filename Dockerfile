FROM eclipse-temurin:21

LABEL mentainer="passon.com.tw@gmail.com"

WORKDIR /app

COPY target/spring-boot-api-demo-0.0.1-SNAPSHOT.jar /app/springboot-docker-demo.jar

ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]
