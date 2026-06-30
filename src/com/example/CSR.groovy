package com.example

class CSR implements Serializable{
    
    def script
    CSR(script){
        this.script = script
    } 
  
    def csrpush(String imagename){
    script.sh "docker image push ${imagename}"  
    }

}