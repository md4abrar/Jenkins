node {
   stage('Build') {
      sh 'mvn clean package'
   }
   stage('Test') {
      sh 'mvn test'
   }
   stage('Deploy') {
      sh 'scp target/myapp.war user@server:/opt/tomcat/webapps/'
   }
}
