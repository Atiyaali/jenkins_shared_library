import com.example.Docker
def call(String backimage) {
     return new Docker(this).backendpush(backimage)
}