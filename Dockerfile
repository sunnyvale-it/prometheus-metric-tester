FROM maven:3.8.5-openjdk-11-slim as builder
ARG MVN_ARGS
ADD ./src/ /app/src/
ADD ./pom.xml /app/pom.xml
WORKDIR /app
RUN mvn -DskipTests --batch-mode package ${MVN_ARGS}

FROM openjdk:11-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8102
CMD ["java","-jar","app.jar"]
