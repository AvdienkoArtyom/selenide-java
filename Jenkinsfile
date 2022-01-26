pipeline {
    agent any
    stages {
        stage('Gradle test') {
            steps {
               bat 'gradlew test --rerun-tasks'
            }
        }
    }
    post{
        always{
            allure([
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'build\\allure-results']]
                ])
        }
    }
}