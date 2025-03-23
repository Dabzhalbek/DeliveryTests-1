plugins {
    id("java")
    id("application")
    id("io.qameta.allure") version "2.11.2"
}

application {
    mainClass.set("org.aqa.Main")
}

group = "org.aqa"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.qameta.allure:allure-java-commons:2.29.1")
    testImplementation("io.qameta.allure:allure-junit5:2.29.1")
}

tasks.test {
    useJUnitPlatform()
}
