package com.example

class Deploy implements Serializable{
    
    def script
    Deploy(script){
        this.script = script
    } 
    def sshDeploy(String server , String VERSION){
   script.sshagent(["your_server_keys"]){
    script.sh """
    ssh ${server} '
    set -e 
    cd /app/wandarlust 
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