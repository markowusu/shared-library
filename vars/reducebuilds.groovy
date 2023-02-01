#!/urs/bin/env groovy

def call(){
 def builds = currentBuild.getRawBuild().getParent().getBuilds()
int count = builds.size()
if (count > 4) {
for (int i = 0; i < count - 4; i++) {
    builds[i].delete()
    }
        }
                
}