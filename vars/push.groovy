
def call() {
       echo "logging to docker hub"
    withCredentials([
        usernamePassword(credentialsId: 'dockerhub_creds' , usernameVariable: 'USER' , passwordVariable: 'PASSWORD' )]){
            sh 'echo $PASSWORD | docker login -u $USER --password-stdin'
        }
    echo "pushing to docker hub"
    sh 'docker push atiyadocker/wandarlustfrontpipeline:latest'
    sh 'docker push atiyadocker/wandarlustbackpipeline:latest'
}