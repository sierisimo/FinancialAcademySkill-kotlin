plugins {

    kotlin("jvm") version "1.2.71"

    id("org.jetbrains.dokka") version "0.9.17"
}

apply {
    plugin("java")
    plugin("kotlin")
}

group = "com.cts"
version = "0.0.1"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8", "1.2.71"))

    implementation("com.amazon.alexa:ask-sdk:2.6.0")

    testImplementation("junit:junit:4.12") //group: 'junit', name: 'junit', version: '4.12'
}

tasks.withType<Jar> {
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
}