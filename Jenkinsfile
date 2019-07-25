pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }

parameters {

        string(name: 'DOCKER_IMAGE', defaultValue: 'jenkins-springboot-demo', description: 'docker镜像名')

    }
    stages {
            stage('checkout') {
                steps {
                   git credentialsId: '1e42b478-2e0f-421a-9fda-250802d86cba', url: 'https://github.com/qq1244560904/jenkins-springboot-demo.git'
                   sh 'mvn clean package -Dfile.encoding=UTF-8 -DskipTests=true'
                   stash includes: 'target/*.jar', name: 'app'
                }
            }
            stage('Docker Build') {
                        steps {
                            unstash 'app'

                            sh "mvn docker build --build-arg JAR_FILE=`ls target/*.jar |cut -d '/' -f2` -t ${params.DOCKER_IMAGE} ."

                        }

                    }

    }

}
