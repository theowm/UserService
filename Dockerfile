FROM eclipse-temurin:21-jdk
COPY target/*.jar /app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

FROM eclipse-temurin:21-jdk
WORKDIR /app
ENV SPRING_PROFILES_ACTIVE=prod
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]