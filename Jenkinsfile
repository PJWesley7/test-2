pipeline{
    agent{label 'JenkinsTest'}
    triggers{pollSCM('* * * * *')}
    stages{
     stage('SourceCode'){
         steps{git branch: 'master', url: 'https://github.com/PJWesley7/test.git'}
     }
     stage('Wait Stage') {
         steps{
           script{
                    echo 'Waiting for 30 seconds...'
                    sleep time: 60, unit: 'SECONDS'
                }
            }
     }
     stage('Test'){
         steps{sh 'mvn clean test'}
     }
     stage('Save Test Results'){
         steps{junit '**/sure-fire-reports/*.xml'}
     }
    }
}
