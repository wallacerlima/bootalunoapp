  pipeline {
    agent any

    tools {
      maven "M3"
    }

    stages {
      stage('Build') {
        steps {
          git branch: 'testes', url: 'http://localhost:3000/edveloso/bootalunoapp.git'
          sh "mvn -Dmaven.test.failure.ignore=true clean package"
        }                
      }
      stage("Quality analises") {
        steps {
          sh "mvn sonar:sonar -Dsonar.projectName=boot-app -Dsonar.projectKey=boot-key -Dsonar.projectVersion=$BUILD_NUMBER"
  			 }
         
  		}
      stage("SIT") {
        steps {
          sh " mvn verify "        
  			}
  		}
      stage("Deploy Docker") {
        steps {          
		     sh 'docker build -t bootapp:${BUILD_ID} . '
             sh 'docker run --name -dp 8181:8181 bootapp:${BUILD_ID} '
  			}
  		}      
    }
  }