plugins {
    kotlin("jvm") version "1.7.0"
    java
    application
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("org.openjfx.javafxplugin") version "0.0.13"
}

group = "com.github.saisana299.roulette"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("com.jfoenix:jfoenix:9.0.10")

    runtimeOnly("org.openjfx:javafx-base:$javafx.version:win")
    runtimeOnly("org.openjfx:javafx-controls:$javafx.version:win")
    runtimeOnly("org.openjfx:javafx-fxml:$javafx.version:win")
    runtimeOnly("org.openjfx:javafx-graphics:$javafx.version:win")
    runtimeOnly("org.openjfx:javafx-base:$javafx.version:linux")
    runtimeOnly("org.openjfx:javafx-controls:$javafx.version:linux")
    runtimeOnly("org.openjfx:javafx-fxml:$javafx.version:linux")
    runtimeOnly("org.openjfx:javafx-graphics:$javafx.version:linux")
    runtimeOnly("org.openjfx:javafx-base:$javafx.version:mac")
    runtimeOnly("org.openjfx:javafx-controls:$javafx.version:mac")
    runtimeOnly("org.openjfx:javafx-fxml:$javafx.version:mac")
    runtimeOnly("org.openjfx:javafx-graphics:$javafx.version:mac")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

javafx {
    version = "17"
    modules = listOf("javafx.controls", "javafx.fxml")
}

application {
    val name = "com.github.saisana299.roulette.Main"
    mainClass.set(name)

    // Required by ShadowJar.
    mainClassName = name
}
