#!/usr/bin/evn groovy


def call(Map args) {

    def awsCredentialsId = args.credentialsId

    def awsRegion = args.awsRegion

    withCredentials([aws(credentialsId: awsCredentialsId, region: awsRegion)]) {

        sh "docker login --username AWS -p $(aws ecr get-login-password --region ${awsRegion}) ${args.awsAccountId}.dkr.ecr.${awsRegion}.amazonaws.com"
       
    }
}
