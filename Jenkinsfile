pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    options {
            skipStagesAfterUnstable()
        }
        stages {
            stage('checkout') {
                steps {
                    checkout scm
                   NAME=`mvn help:evaluate -Dexpression=project.name | grep "^[^\[]"`
                   echo $NAME
                   VERSION=`mvn help:evaluate -Dexpression=project.version | grep "^[^\[]"`
                   echo $VERSION
                    img_name = "${NAME}-${VERSION}"
                    echo "artifactId: ${NAME}, version: ${VERSION}"
                    echo "docker-img-name: ${docker_img_name}"
                    echo "${JOB_NAME}"
                    script {
                    build_tag = sh(returnStdout: true, script: 'git rev-parse --short HEAD').trim()
                        if (env.BRANCH_NAME != 'master' && env.BRANCH_NAME != null) {
                         build_tag = "${env.BRANCH_NAME}-${build_tag}"
                        }
                    }

                }
            }
        }
        stages {
            stage('Build') {
                steps {
                    sh 'mvn -B -DskipTests clean package'
                    sh "docker build -t ${img_name}:${build_tag} " +
                                    " --build-arg SPRING_PROFILE=default " +
                                    " --build-arg JAR_FILE=target/${pom.artifactId}-${pom.version}.jar " +
                                    " ."
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
