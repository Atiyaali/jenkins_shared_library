import com.example.Deploy
def call(){
def deployer = new Deploy(this)
def server = "ec2-user@13.234.34.0"
deployer.sshDeploy(
        server,
        env.VERSION
    )
}
