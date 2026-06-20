package com.example

class Deploy implements Serializable{
    
    def script
    Deploy(script){
        this.script = script
    } 
    
    def sshDeploy(String server , String VERSION){
   script.sshagent(['ec2-server-key']){
    script.sh """
     scp -o StrictHostKeyChecking=no \
        docker-compose.yml \
        ${server}:~/wandarlust/
    ssh -o StrictHostKeyChecking=no ${server} "mkdir -p ~/wandarlust/nginx"
    scp -o StrictHostKeyChecking=no -r \
    nginx/ssl \
    ${server}:~/wandarlust/nginx/
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