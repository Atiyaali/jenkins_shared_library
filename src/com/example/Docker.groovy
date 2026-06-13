package com.example

class Docker implements Serializable{
    
    def script
    Docker(script){
        this.script = script
    } 
    def dockerbackimagebuild(String backimage , String filepath){
    script.sh "docker build -f ${filepath} -t ${backimage} ."
    }
     def dockerfrontimagebuild(String frontimage , String filepath){
    script.sh "docker build -f ${filepath} -t ${frontimage} ."
    }
    def dockernginximagebuild(String nginximage , String filepath){
      script.sh "docker build -f ${filepath} -t ${nginximage} ."
    }
    def dockerlogin(){
        script.withCredentials([
        script.usernamePassword(credentialsId: 'dockerhub_creds' , usernameVariable: 'USER' , passwordVariable: 'PASSWORD' )]){
            script.sh 'echo  $PASSWORD | docker login -u $USER --password-stdin'
        }
    }
    def backendpush(String backimage){
    script.sh "docker back image push ${backimage}"  
    }
    def frontendpush(String frontimage){
    script.sh "docker front image push ${frontimage}"
    }
    def nginxpush(String nginximage){
    script.sh "docker nginx image push ${nginximage}"
    }

}