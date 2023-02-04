#!/usr/bin/evn groovy


def call(Map args) {

    def awsCredentialsId = args.credentialsId

    def awsRegion = args.awsRegion

    def awsAccountId = args.awsAccountId

//       withCredentials([[$class: 'AmazonWebServicesCredentialsBinding',credentialsId: awsCredentialsId]]) {
//    container('aws-cli') {
//       sh('env')
//       sh('aws sts get-caller-identity')
//     }
// }

    withCredentials([aws(credentialsId: awsCredentialsId)]) {

        // sh "aws ecr get-login-password | docker login --username AWS --password-stdin ${awsAccountId}.dkr.ecr.${awsRegion}.amazonaws.com"
     sh 'echo ${awsCredentialsId}'
     sh 'env'
     sh 'aws sts get-caller-identity'
     sh 'docker login --username AWS --password $(aws ecr get-login-password --region ${awsRegion}) ${awsAccountId}.dkr.ecr.${awsRegion}.amazonaws.com'

    }
}
