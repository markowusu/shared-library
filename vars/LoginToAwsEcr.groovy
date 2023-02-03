#!/usr/bin/evn groovy


def call(Map args) {

    def awsCredentialsId = args.credentialsId

    def awsRegion = args.awsRegion

    def awsAccountId = args.awsAccountId

    withCredentials([aws(credentialsId: awsCredentialsId, region: awsRegion)]) {

        // sh "aws ecr get-login-password | docker login --username AWS --password-stdin ${awsAccountId}.dkr.ecr.${awsRegion}.amazonaws.com"
     sh 'echo ${awsAccountId}.dkr.ecr.${awsRegion}.amazonaws.com'
        sh 'docker login --username AWS --password $(aws ecr get-login-password --region ${awsRegion}) ${awsAccountId}.dkr.ecr.${awsRegion}.amazonaws.com'

    }
}
