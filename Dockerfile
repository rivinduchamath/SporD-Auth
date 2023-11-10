FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-alpine-slim
#ADD target/auth-service-0.0.1-SNAPSHOT.jar app.jar
#WORKDIR /opt
ADD target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
ENV PORT 2002
EXPOSE 2002
#COPY target/*.jar /opt/app.jar
#ENTRYPOINT exec java $JAVA_OPTS -jar app.jarkubectl version --client