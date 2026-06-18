# Dockerfile en la raíz del proyecto
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app
COPY target/*.jar app.jar
# Regla DevSecOps: Nunca ejecutar el contenedor como Root
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]