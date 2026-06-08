package com.example

class Docker implements Serializable{
    def script
    Docker(script){
        this.script = script
    } 
    def dockerimagebuild(String frontimage , String backimage){
    script.echo "building docker image"
    script.sh "docker build -t ${frontimage} ./frontend"
    script.sh "docker build -t ${backimage} ./backend"
    }

}