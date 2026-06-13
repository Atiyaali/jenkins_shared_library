import com.example.Docker

def call(String imagename , String filepath) {
   return new Docker(this).dockerimagebuild(imagename, filepath)
}
