

def call(String frontimage , String backimage) {
   return new Docker(this).dockerimagebuild(frontimage , backimage)
}
