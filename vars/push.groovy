import com.example.Docker
def call(String frontimage , String backimage) {
     return new Docker(this).dockerpush(frontimage , backimage)
}