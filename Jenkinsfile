pipeline {
    agent any

    tools {
       maven "M3"
    }

    stages {
        stage('Build') {
            steps {                
                git 'https://github.com/wallacerlima/alunoapp.git'       
                bat "mvn clean package"
            }
        }
        
        stage('Deploy') {
            // Deploy to Tomcat
            deploy adapters: [tomcat8(credentialsId: '8cea677d-6ba0-4802-ab49-f624207cfdef', path: '', url: 'http://ec2-54-94-171-77.sa-east-1.compute.amazonaws.com:8080/')], contextPath: 'alunoapp', war: 'target/alunoapp.war'
        }
        
    }
}
