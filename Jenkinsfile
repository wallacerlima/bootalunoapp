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
      stage("Deploy to tomcat") {
        steps {          
          deploy adapters: [tomcat8(credentialsId: 'tomcat_cred', path: '', url: 'http://localhost:8484')], contextPath: 'bootapp', war: 'target/*.war'
  			}
  		}      
    }
  }