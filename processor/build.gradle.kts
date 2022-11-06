

plugins {
    id("com.android.library")
    kotlin("jvm")
    id("com.google.devtools.ksp") version "1.7.0-1.0.6"
    id("maven-publish")
}

// Versions are declared in 'gradle.properties' file




dependencies {
    implementation(project(":annotations"))
    implementation("com.google.devtools.ksp:symbol-processing-api:1.7.0-1.0.6")

    implementation("com.squareup:kotlinpoet:1.12.0")
    implementation("com.squareup:kotlinpoet-ksp:1.12.0")

    //Auto service
    implementation("com.google.auto.service:auto-service-annotations:1.0.1")
    //ksp("dev.zacsweers.autoservice:auto-service-ksp:1.0.0")

    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.4.32")
    testImplementation("com.github.tschuchortdev:kotlin-compile-testing:1.4.9")
    testImplementation("com.github.tschuchortdev:kotlin-compile-testing-ksp:1.4.9")

    //ksp("dev.zacsweers.autoservice:auto-service-ksp:1.0.0")

}
repositories {
    // mavenCentral()
}
ksp {
    arg("autoserviceKsp.verify", "true")
    arg("autoserviceKsp.verbose", "true")
}
/*afterEvaluate {
    publishing {
        publications {
            release(MavenPublication) {
                from components.release

                groupId = 'com.github.rajumark'
                artifactId = 'cabbage-processor'
                version = '0.0.2'
            }
        }
    }
}*/
