def call() {
  dir('backend') {
    def status = sh(script: "npm test", returnStatus: true)
    if (status != 0) {
      error("Tests failed")
    }
  }
}