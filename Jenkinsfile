pipeline {
    agent {
        label ""
    }

    environment {
        APP_NAME = 'star-wars-api'
        RECIPIENT = 'wilsonchiviti@gmail.com'
        DOCKER_IMAGE = "${APP_NAME}"
        HOST_APP_PORT = 8080
        CONTAINER_APP_PORT = "${HOST_APP_PORT}"
    }

    stages {
        stage('Docker Build') {
            steps {
                sh "docker build -t ${APP_NAME} ."
                sh "docker stop ${APP_NAME} || true"
                sh "docker rm ${APP_NAME} || true"
                sh """
                    docker run -d --restart=always --name ${APP_NAME} \
                        -p ${HOST_APP_PORT}:${CONTAINER_APP_PORT} \
                        ${APP_NAME}
                   """
            }
        }

    }

    post {
        always {
            step([
                    $class                  : 'Mailer',
                    notifyEveryUnstableBuild: true,
                    recipients              : "${RECIPIENT}",
                    sendToIndividuals       : true
            ])
        }

    }
}