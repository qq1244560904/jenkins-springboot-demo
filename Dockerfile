FROM openjdk:8-jdk-alpine

RUN yum update -qq && yum install -y maven && yum clean

WORKDIR /code
ADD pom.xml /code/pom.xml
ADD src /code/src
#设置时区
RUN mvn package -DskipTests

EXPOSE 8002

ENTRYPOINT exec java -jar target/jenkins-springboot-demo-SNAPSHOT.jar
