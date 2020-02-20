pipeline {
  agent any
  stages {
    stage('checkout') {
      agent {
        docker {
          image "${params.DOCKER_HOST}/maven:3-alpine"
          args '-v /root/.m2:/root/.m2'
        }

      }
      steps {
        git(credentialsId: '1e42b478-2e0f-421a-9fda-250802d86cba', url: 'https://github.com/qq1244560904/jenkins-springboot-demo.git')
        sh 'mvn clean package -Dfile.encoding=UTF-8 -DskipTests=true'
        stash(includes: 'target/*.jar', name: 'app')
        retry(count: 5) {
          sh 'echo hello word'
        }

        sleep(time: 10, unit: 'SECONDS')
      }
    }
    stage('Docker Build') {
      steps {
        unstash 'app'
        sh "docker build --build-arg JAR_FILE=`ls target/*.jar |cut -d '/' -f2` -t ${params.DOCKER_HOST}/${params.DOCKER_IMAGE}:${GIT_TAG} ."
        sh "docker push ${params.DOCKER_HOST}/${params.DOCKER_IMAGE}:${GIT_TAG}"
        sh 'docker stop jenkins-pipeline-demo'
        sh 'docker rm jenkins-pipeline-demo'
        sh "docker run -d --name jenkins-pipeline-demo -p 8002:8002 ${params.DOCKER_HOST}/${params.DOCKER_IMAGE}:${GIT_TAG}"
      }
    }
  }
  environment {
    GIT_TAG = sh(returnStdout: true,script: 'git describe --tags --always').trim()
  }
  parameters {
    string(name: 'DOCKER_IMAGE', defaultValue: 'jenkins-springboot-demo', description: 'docker镜像名')
    string(name: 'DOCKER_HOST', defaultValue: '120.78.176.7:5000', description: '私有docker仓库地址')
  }
}
