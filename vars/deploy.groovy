import com.example.Deploy
def call(){
def deployer = new Deploy(this)
def server = "ec2-user@43.205.129.49"
deployer.sshDeploy(
        server,
        env.VERSION
    )
}
