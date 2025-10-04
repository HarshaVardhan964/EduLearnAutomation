pipeline {
    agent any

    tools {
        maven 'Maven_3.9.6'
        jdk 'JDK21'   // Or your configured JDK name
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/HarshaVardhan964/EduLearnAutomation.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Publish Reports') {
            steps {
                publishHTML(target: [
                    reportDir: 'test-output',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Extent Test Report'
                ])
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
