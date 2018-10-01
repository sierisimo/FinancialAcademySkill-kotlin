plugins {

    kotlin("jvm") version "1.2.71"

    id("org.jetbrains.dokka") version "0.9.17"
}

apply {
    plugin("java")
    plugin("kotlin")
    plugin("org.jetbrains.kotlin.kapt")
}

group = "com.cts"
version = "0.2.0"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8", "1.2.71"))

    implementation("com.amazon.alexa:ask-sdk:2.6.0")

    //Logging
    implementation("io.github.microutils:kotlin-logging:1.6.10")
    implementation("com.amazonaws:aws-lambda-java-log4j2:1.0.0")

    implementation("com.squareup.moshi:moshi:1.7.0")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.7.0")

    implementation("com.squareup.retrofit2:retrofit:2.4.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.4.0")
   // implementation("com.squareup.okhttp3:logging-interceptor:3.8.0")

    val junitJupiterVersion = "5.2.0"

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testImplementation("org.junit.platform:junit-platform-runner:1.2.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitJupiterVersion")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")

    testImplementation("org.jetbrains.kotlin:kotlin-test:1.2.71")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.2.71")

}

tasks.withType<Jar> {
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
}