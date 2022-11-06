plugins {
    kotlin("jvm")
    id("maven-publish")
}
/*repositories {
      mavenCentral()
}*/
afterEvaluate {
    publishing {
        publications {
            release(MavenPublication) {
                from components.release

                groupId = 'com.github.rajumark'
                artifactId = 'cabbage-annotations'
                version = '0.0.2'
            }
        }
    }
}