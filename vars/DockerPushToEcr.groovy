#!/usr/bin/env groovy 
// : 
def call(String imageTag, String repository){
    
    def buildID = env.BUILD_ID

  

    sh'echo tagging the built image to be pushed to the new repo on aws '
                sh 'docker tag ${imageTag} ${repository}:${buildID}'
            
                
                sh 'echo pushng new image to the ECR repo on aws'
                sh 'docker push ${repository}:${buildID}'
}