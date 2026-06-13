import com.example.Docker

def call(String nginximage , String filepath) {
   return new Docker(this).dockernginximagebuild(nginximage , filepath)
}
