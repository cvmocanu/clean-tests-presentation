plugins {
    alias(libs.plugins.kotlinJvm)
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.assertj.core)
    testImplementation(libs.awaitility.core)
    testImplementation(libs.awaitility.kotlin)
    testRuntimeOnly(libs.junit.platformLauncher)
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
