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
        servershell.sh \
        ${server}:~
    scp -o StrictHostKeyChecking=no \
        docker-compose.yml \
        ${server}:~/wandarlust/
    ssh -o StrictHostKeyChecking=no ${server} "mkdir -p ~/wandarlust/nginx"
    scp -o StrictHostKeyChecking=no -r \
    nginx/ssl \
    ${server}:~/wandarlust/nginx/
    ssh -o StrictHostKeyChecking=no ${server} '
    chmod +x ~/servershell.sh
    VERSION=${VERSION} bash ~/servershell.sh
    '
    """
   }
    }
 

}