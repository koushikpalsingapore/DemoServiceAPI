pipeline {
    bat 'echo "Starting the Pipe Line"'
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean build'
                }
        }
    }
}
