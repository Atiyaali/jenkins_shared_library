package com.example

class trivy implements Serializable{
    
    def script
    trivy(script){
        this.script = script
    } 
    def trivyscan(String imagename){
   script.sh """
        docker run --rm \
          -v /var/run/docker.sock:/var/run/docker.sock \
          aquasec/trivy:latest image \
          --timeout 15m \
          ${imagename}
        """
    }
 

}