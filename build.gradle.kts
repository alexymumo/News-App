buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.0")
        classpath("com.google.gms:google-services:4.3.14")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.9.2")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.0.0" apply false
    id("com.android.library") version "8.0.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.21" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    id("org.jlleitschuh.gradle.ktlint") version ("11.3.1")
    id("com.diffplug.spotless") version ("5.17.1")
}

subprojects {
    apply(plugin = "com.diffplug.spotless")
    spotless {
        kotlin {
            target("**/*.kt")
            ktlint()
            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
        }

        java {
            target("**/*.java")
            googleJavaFormat().aosp()
            removeUnusedImports()
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