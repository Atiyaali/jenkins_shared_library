import com.example.Deploy
def call(){
def deployer = new Deploy(this)
def server = "ubuntu@YOUR_SERVER_IP"
deployer.sshDeploy(
        server,
        env.VERSION
    )
}
