package com.example

class Deploy implements Serializable{
    
    def script
    Deploy(script){
        this.script = script
    } 
    
    def sshDeploy(String server , String VERSION){
   script.sshagent(['ec2-server-key']){
    script.sh """
    ssh -o StrictHostKeyChecking=no ${server} '
    set -e 
    cd ~/wandarlust 
    echo "VERSION=${VERSION}" > .env 
    docker compose down || true
    docker compose pull 
    docker compose up -d 
    echo "deployment successfull"
    '
    """
   }
    }
 

}