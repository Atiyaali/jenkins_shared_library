

def call(String frontimage , String backimage) {
    echo "building docker image"
    sh "docker build -t ${frontimage} ./frontend"
    sh "docker build -t ${backimage} ./backend"
}
