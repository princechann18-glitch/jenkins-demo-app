pipeline {
    agent any

    tools {
        maven 'Maven 3.8.1'
        jdk 'JDK 17'
    }

    environment {
        DOCKER_IMAGE = 'jenkins-demo-app:${BUILD_NUMBER}'
        REGISTRY = 'docker.io'
    }

    stages {
        stage('Checkout') {
            steps {
                echo '====== Checking out source code ======'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo '====== Building Maven project ======'
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo '====== Running unit tests ======'
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo '====== Packaging application as JAR ======'
                sh 'mvn package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                echo '====== Building Docker image ======'
                sh 'docker build -t ${DOCKER_IMAGE} .'
            }
        }

        stage('Archive Artifacts') {
            steps {
                echo '====== Archiving build artifacts ======'
                archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: false
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            echo '====== Cleaning up workspace ======'
            cleanWs()
        }
        success {
            echo '====== Build completed successfully ======'
        }
        failure {
            echo '====== Build failed ======'
        }
    }
}