package com.example

class Docker implements Serializable{
    def script
    Docker(script){
        this.script = script
    } 
    def dockerimagebuild(String frontimage , String backimage){
    script.echo "building docker image through src"
    script.sh "docker build -t ${frontimage} ./frontend"
    script.sh "docker build -t ${backimage} ./backend"
    }
    def dockerlogin(){
        script.withCredentials([
        script.usernamePassword(credentialsId: 'dockerhub_creds' , usernameVariable: 'USER' , passwordVariable: 'PASSWORD' )]){
            script.sh 'echo  $PASSWORD | docker login -u $USER --password-stdin'
        }
    }
    def dockerpush(String frontimage , String backimage){
    script.sh "docker push ${frontimage}"
    script.sh "docker push ${backimage}"  

    }

}