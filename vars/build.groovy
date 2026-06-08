

def call() {
    echo "building docker image"
    sh 'docker build -t atiyadocker/wandarlustfrontpipeline:latest ./frontend'
    sh 'docker build -t atiyadocker/wandarlustbackpipeline:latest ./backend'
}
