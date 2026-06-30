package com.example

class Docker implements Serializable{
    
    def script
    Docker(script){
        this.script = script
    } 
    def dockerimagebuild(String imagename , String filepath){
    script.sh "docker build -f ${filepath} -t ${imagename} ."
    }
    def dockerlogin(){
        withCredentials([
    [$class: 'AmazonWebServicesCredentialsBinding',
     credentialsId: 'aws-creds']
]) {
    script.sh '''
    aws ecr get-login-password --region us-east-1 | \
    docker login --username AWS --password-stdin \
    590398356271.dkr.ecr.us-east-1.amazonaws.com
    '''
}
        // script.withCredentials([
        // script.usernamePassword(credentialsId: 'dockerhub_creds' , usernameVariable: 'USER' , passwordVariable: 'PASSWORD' )]){
        //     script.sh 'echo  $PASSWORD | docker login -u $USER --password-stdin'
        // }
    }
    def dockerpush(String imagename){
    script.sh "docker image push ${imagename}"  
    }

}