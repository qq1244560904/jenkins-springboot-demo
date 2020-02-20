FROM openjdk:8-jdk-alpine

RUN apt-get update -qq && apt-get install -y maven && apt-get clean

WORKDIR /code
ADD pom.xml /code/pom.xml
ADD src /code/src
#设置时区
RUN mvn package -DskipTests

EXPOSE 8002

ENTRYPOINT exec java -jar target/jenkins-springboot-demo-SNAPSHOT.jar
