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
        url: 'https://github.com/MuthamgariVenu/hospital-ui-automation.git'
}

        }

       stage('Build & Test') {
    steps {
        sh 'mvn clean test -Denv=qa -Dbrowser=chrome'
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
