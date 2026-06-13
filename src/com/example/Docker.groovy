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
        script.withCredentials([
        script.usernamePassword(credentialsId: 'dockerhub_creds' , usernameVariable: 'USER' , passwordVariable: 'PASSWORD' )]){
            script.sh 'echo  $PASSWORD | docker login -u $USER --password-stdin'
        }
    }
    def dockerpush(String imagename){
    script.sh "docker image push ${imagename}"  
    }

}