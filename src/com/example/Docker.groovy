package com.example

class Docker implements Serializable{
    
    def script
    Docker(script){
        this.script = script
    } 
      def tag = script.sh(
                script: 'git describe --tags',
                returnStdout: true
            ).trim()
    def dockerimagebuild(String frontimage , String backimage){
    script.echo "building docker image through src"
    script.sh "docker build -t ${frontimage}:${tag} ./frontend"
    script.sh "docker build -t ${backimage}:${tag} ./backend"
    }
    def dockerlogin(){
        script.withCredentials([
        script.usernamePassword(credentialsId: 'dockerhub_creds' , usernameVariable: 'USER' , passwordVariable: 'PASSWORD' )]){
            script.sh 'echo  $PASSWORD | docker login -u $USER --password-stdin'
        }
    }
    def dockerpush(String frontimage , String backimage){
    script.sh "docker push ${frontimage}:${tag}"
    script.sh "docker push ${backimage}:${tag}"  

    }

}