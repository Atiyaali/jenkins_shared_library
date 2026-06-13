import com.example.Docker

def call(String backimage , String filepath) {
   return new Docker(this).dockerbackimagebuild(backimage , filepath)
}
