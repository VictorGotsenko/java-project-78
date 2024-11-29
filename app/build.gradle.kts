import com.adarshr.gradle.testlogger.theme.ThemeType

plugins {
    id("java")
    id("application")
    checkstyle
    jacoco
    id("com.adarshr.test-logger") version "4.0.0"
    id("se.patrikerdes.use-latest-versions") version "0.2.18"
    id("com.github.ben-manes.versions") version "0.50.0"

}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application {
        mainClass = "hexlet.code.Validator"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    
    testImplementation("org.assertj:assertj-core:3.25.3")
}

checkstyle {
    toolVersion = "10.20.1"
    configFile = file("config/checkstyle/checkstyle.xml")
}

jacoco {
    toolVersion = "0.8.12"
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
//    testlogger {
//        theme = ThemeType.MOCHA
//        showStandardStreams = true
//        showExceptions = true
//        showStackTraces = true
//        showSummary = true
//        showSimpleNames = false
//        showPassed = true
//        showSkipped = true
//        showFailed = true
//        showOnlySlow = false
//        showStandardStreams = false
//        showPassedStandardStreams = true
//        showSkippedStandardStreams = true
//        showFailedStandardStreams = true
//        logLevel = LogLevel.LIFECYCLE
//    }
}

tasks.jacocoTestReport {
    reports {
        xml.required = true
    }
}
