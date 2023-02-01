#!/urs/bin/env groovy 

def call(String packageName){
    sh '''
    pip3 list | findstr ${packageName}
    aws --version 
    
    '''
}