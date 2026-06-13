import com.example.Docker

def call(String frontimage , String filepath) {
   return new Docker(this).dockerfrontimagebuild(frontimage , filepath)
}
