pipeline{
    agent{label 'JenkinsTest'}
    triggers{pollSCM('* * * * *')}
    stages{
     stage('SourceCode'){
         steps{git branch: 'master', url: 'https://github.com/PJWesley7/test.git'}
     }
     stage('Test'){
         steps{sh 'mvn clean test'}
     }
     stage('Save Test Results'){
         steps{junit '**/sure-fire-reports/*.xml'}
     }
    }
}
