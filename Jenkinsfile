pipeline {
    agent any

    tools {
       maven "M3"
    }

    stages {
        stage('Build') {
            steps {                
                git branch: 'finalize', url: 'https://github.com/edveloso/bootalunoapp.git'       
                bat "mvn clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.war'
                }
            }
        }
        stage('Deploy to tomcat') {
            steps {
                deploy adapters: [tomcat8(credentialsId: 'TOMCAT-DEPLOYER', path: '', url: 'http://localhost:8484')], contextPath: 'bootaluno', war: 'target/*.war'
            }
            
        }
       stage('Verify') {
            steps {
                bat 'mvn verify'
                }
            
        }
        
    }
}
