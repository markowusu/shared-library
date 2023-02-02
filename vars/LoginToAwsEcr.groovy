#!/usr/bin/evn groovy


def call(Map args) {

    def awsCredentialsId = args.credentialsId
    def awsAccountId = args.awsAccountId
    def awsRegion = args.awsRegion

    withCredentials([aws(credentialsId: awsCredentialsId, region: awsRegion)]) {

        sh "docker login --username AWS -p $(aws ecr get-login-password --region ${awsRegion}) ${awsAccountId}.dkr.ecr.${awsRegion}.amazonaws.com"
       
    }
}
