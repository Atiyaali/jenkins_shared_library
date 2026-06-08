
def call(String frontimage , String backimage) {
       echo "logging to docker hub"
    withCredentials([
        usernamePassword(credentialsId: 'dockerhub_creds' , usernameVariable: 'USER' , passwordVariable: 'PASSWORD' )]){
            sh 'echo $PASSWORD | docker login -u $USER --password-stdin'
        }
    echo "pushing to docker hub"
    sh "docker push ${frontimage}"
    sh "docker push ${backimage}"
}