pipeline {
    agent any

    environment {
        SLACK_WEBHOOK_URL = credentials('SLACK_WEBHOOK_URL')
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test -Dcucumber.filter.tags="@web"'
            }
        }
    }

    post {
        success {
            script {
                sendSlackMessage("Pipeline execution was successful!")
            }
        }
        failure {
            script {
                sendSlackMessage("Pipeline execution failed...")
            }
        }
        always {
            allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
        }
    }
}

def sendSlackMessage(String message) {
    def jenkinsUrl = "http://localhost:8080/job/web-pipeline-selenium-grid"
    def allureReportUrl = "${jenkinsUrl}/${env.BUILD_NUMBER}/allure/"
    def finalMessage = "${message}\n*Allure Report:* <${allureReportUrl}|View Report>"

    sh """
        curl -X POST -H 'Content-type: application/json' \
        --data '{"text": "${finalMessage}"}' $SLACK_WEBHOOK_URL
    """
}
