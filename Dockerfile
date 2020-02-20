FROM openjdk:8-jdk-alpine


#设置时区
RUN mvn package -DskipTests

COPY target/jenkins-springboot-demo-SNAPSHOT.jar file/
EXPOSE 8002
WORKDIR file/

ENTRYPOINT exec java -jar jenkins-springboot-demo-SNAPSHOT.jar
