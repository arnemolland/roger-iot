plugins {
    // Apply the java plugin to add support for Java
    java

    // Apply the application plugin to add support for building an application
    //application
}

repositories {
    // Using jcenter for resolving dependenies.
    jcenter()
    mavenCentral()
}

dependencies {
    // This dependency is found on compile classpath of this component and consumers.
    implementation("com.google.guava:guava:26.0-jre")

    // Use JUnit test framework
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}

tasks {
    // Use the built-in JUnit support of Gradle.
    "test"(Test::class) {
        useJUnitPlatform()
    }
}