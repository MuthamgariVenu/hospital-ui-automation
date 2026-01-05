pipeline {
    agent any

    parameters {
        choice(name: 'ENV', choices: ['qa', 'stage'], description: 'Environment')
        choice(name: 'BROWSER', choices: ['chrome'], description: 'Browser')
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                 git url: 'https://github.com/MuthamgariVenu/hospital-ui-automation.git'

            }
        }

        stage('Build & Test') {
            steps {
                bat """
                mvn clean test -P%ENV% -Dbrowser=%BROWSER%
                """
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/surefire-reports/**/*', fingerprint: true
        }
        success {
            echo 'BUILD SUCCESS'
        }
        failure {
            echo 'BUILD FAILED'
        }
    }
}
