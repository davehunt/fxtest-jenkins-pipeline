package org.mozilla.fxtest

def testProject(String name) {
  node {
    def Random rand = new Random()
    echo "Testing project " + name
    def failures = 0
    def tests = ["1", "2"]
    for (test in tests) {
      stage(test) {
        echo "Running " + test
        failures = rand.nextInt(2)
        echo "Failed " + failures
      }
    }
    stage('Ship it!') {
      if (failures == 0) {
        sh 'exit 0'
      } else {
        sh 'exit 1'
      }
    }
  }
}
