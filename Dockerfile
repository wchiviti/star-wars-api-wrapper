FROM maven:3.8.3-openjdk-17-slim AS MAVEN_TOOL_CHAIN
RUN mkdir -p /workspace
WORKDIR /workspace/

COPY ./ /workspace/

RUN mvn -B -f pom.xml dependency:go-offline
RUN mvn -B install

FROM openjdk:18-jdk-alpine3.13
COPY --from=MAVEN_TOOL_CHAIN /workspace/target/star-wars-api.jar app.jar

RUN sh -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
