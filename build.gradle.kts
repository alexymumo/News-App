buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.0")
        //classpath("com.google.gms:google-services:4.3.15")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.8.21")
        classpath("com.google.gms:google-services:4.3.14")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.9.2")
        //classpath("com.google.firebase:firebase-crashlytics-gradle:2.9.7")
        //classpath("com.google.firebase:firebase-appdistribution-gradle:4.0.0")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.0.0" apply false
    id("com.android.library") version "8.0.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.20" apply false
    id("org.jlleitschuh.gradle.ktlint") version ("11.3.1")
    id("com.diffplug.spotless") version ("5.17.1")
}

allprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}

subprojects {
    apply(plugin = "com.diffplug.spotless")
    spotless {
        kotlin {
            target("**/*.kt")
            licenseHeaderFile(
                rootProject.file("${project.rootDir}/spotless/copyright.kt"),
                "^(package|object|import|interface)"
            )
            ktlint()
            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
        }

        format("xml") {
            target()
            indentWithSpaces()
            trimTrailingWhitespace()
            endWithNewline()
        }

        format("misc") {
            target("**/*.md", "**/.gitignore")
            indentWithSpaces()
            trimTrailingWhitespace()
            endWithNewline()
        }
    }
}