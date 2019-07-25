FROM hub.c.163.com/wuxukun/maven-aliyun:3-jdk-8
WORKDIR /var/jenkins_home/workspace                                           
EXPOSE 8002
ADD  /${JOB_NAME}/${pom.artifactId}-${pom.version}.jar   ${pom.artifactId}.jar  
ENTRYPOINT ["java","-jar","${pom.artifactId}.jar","-c"]