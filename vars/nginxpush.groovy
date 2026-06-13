import com.example.Docker
def call(String nginximage) {
     return new Docker(this).nginxpush(nginximage)
}