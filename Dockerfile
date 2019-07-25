FROM hub.c.163.com/wuxukun/maven-aliyun:3-jdk-8
WORKDIR /var/jenkins_home/workspace                                           
EXPOSE 8002
ADD  /${JOB_NAME}/${NAME}-${VERSION}.jar   ${NAME}.jar  
ENTRYPOINT ["java","-jar","${NAME}.jar","-c"]