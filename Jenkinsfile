pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    environment {
        GIT_TAG = sh(returnStdout: true,script: 'git describe --tags --always').trim()
    }
    parameters {
        string(name: 'DOCKER_IMAGE', defaultValue: 'jenkins-springboot-demo', description: 'docker镜像名')
    }

    stages {
            stage('checkout') {
                steps {
                   git credentialsId: '1e42b478-2e0f-421a-9fda-250802d86cba', url: 'https://github.com/qq1244560904/jenkins-springboot-demo.git'
                }
            }

            stage('Build') {

                steps {
                    sh 'mvn -B -DskipTests clean package'
                    stash includes: 'target/*.jar', name: 'app'
                    unstash 'app'
                    sh "docker build --build-arg JAR_FILE=`ls target/*.jar |cut -d '/' -f2` -t ${params.DOCKER_IMAGE}:${GIT_TAG} ."
                }
            }
            stage('Test') {
                steps {
                    sh 'mvn test'
                }
                post {
                    always {
                        junit 'target/surefire-reports/*.xml'
                    }
                }
            }
            stage('Deliver') {
                steps {

                }
            }
    }

}
