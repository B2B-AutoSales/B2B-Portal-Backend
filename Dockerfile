FROM openjdk:21
WORKDIR /app
ARG JAR_FILE=authorization-0.1.jar
COPY target/${JAR_FILE} /app/${JAR_FILE}
CMD ["java", "-jar", "authorization-0.1.jar"]

EXPOSE 8080