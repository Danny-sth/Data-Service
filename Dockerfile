FROM adoptopenjdk/maven-openjdk11
ADD src/main/java/com/dannykudinov/dataservice /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080