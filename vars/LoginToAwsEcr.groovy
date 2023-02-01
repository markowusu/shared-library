#!/usr/bin/env groovy
def call(Map args) {

    def awsCredentialsId = args.credentialsId

    def awsRegion = args.awsRegion

    withCredentials([aws(credentialsId: awsCredentialsId, region: awsRegion)]) {
        
        sh "aws ecr get-login-password | docker login --username AWS --password-stdin ${args.awsAccountId}.dkr.ecr.${awsRegion}.amazonaws.com"
    }
}
