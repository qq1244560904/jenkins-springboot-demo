pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }

    stages {
            stage('checkout') {
                steps {
                   git credentialsId: '1e42b478-2e0f-421a-9fda-250802d86cba', url: 'https://github.com/qq1244560904/jenkins-springboot-demo.git'
                }
            }

    }

}
