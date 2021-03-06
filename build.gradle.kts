plugins {
    kotlin("jvm") version "1.6.0"
    java
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.0")
    implementation("org.mockito:mockito-all:1.10.19")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.4.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
}

java.sourceCompatibility = JavaVersion.VERSION_17

tasks.test {
    useJUnitPlatform()
}
