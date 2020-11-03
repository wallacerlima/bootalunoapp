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
          //sh "mvn sonar:sonar -Dsonar.projectName=boot-app -Dsonar.projectKey=boot-key -Dsonar.projectVersion=$BUILD_NUMBER"
            sh 'echo "sonar"'
  			 }
         
  		}
      stage("SIT") {
        steps {
          sh " mvn verify "        
  			}
  		}
      stage("Deploy Docker") {
        steps {   
             sh 'docker stop boot && docker rm boot'
		     sh 'docker build -t bootapp:${BUILD_ID} . '
             sh 'docker run --name boot -dp 8181:8181 bootapp:${BUILD_ID} '
  			}
  		}  

	  stage('Performance test') {

            steps {
              sh 'jmeter -Jjmeter.save.saveservice.output_forma=xml -n -t perf_app.jmx -l Test.jtl '
			  perfReport filterRegex: '', sourceDataFiles: 'Test.jtl'
            }
        }

    }
  }