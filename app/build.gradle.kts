import org.gradle.configurationcache.extensions.capitalized

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("com.google.dagger.hilt.android")
    jacoco
}


jacoco {
    toolVersion = "0.8.8"
}



project.afterEvaluate {
    setupAndroidReporting()
}
android {
    namespace = "com.alexmumo.news_app"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.alexmumo.news_app"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    kotlin {
        jvmToolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }



    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {

    // Modules
    implementation(project(":presentation"))
    implementation(project(":core:repository"))
    implementation(project(":core:network"))
    implementation(project(":core:database"))
    implementation(project(":core:datastore"))

    implementation(libs.android.appcompat)
    implementation(libs.android.core)

    // Koin
    implementation(libs.bundles.koin)

    // Compose
    implementation(libs.bundles.compose)

    // Timber
    implementation(libs.timber)

    //Firebase
    implementation(libs.bundles.firebase)

    //Material
    implementation(libs.material)

    // Hilt
    implementation(libs.dagger.hilt)
    kapt(libs.hilt.compiler)

}

fun setupAndroidReporting() {
    val buildTypes = listOf("debug")
    buildTypes.forEach { buildTypeName ->
        val testTaskName = "test${buildTypeName.capitalized()}UnitTest"
        tasks.register<JacocoReport>("${testTaskName}Coverage") {

            dependsOn(tasks.findByName(testTaskName))

            group = "Reporting"
            description = "Generate Jacoco coverage reports on ${buildTypeName.capitalized()} build"

            reports {
                xml.required.set(true)
                csv.required.set(true)
                html.required.set(true)
            }

            val fileFilters = listOf(
                // android
                "**/R.class",
                "**/R$*.class",
                "**/BuildConfig.*",
                "**/Manifest*.*",
                "**/*Test*.*",
                "android/**/*.*",
                // kotlin
                "**/*MapperImpl*.*",
                "**/*\$ViewInjector*.*",
                "**/*\$ViewBinder*.*",
                "**/BuildConfig.*",
                "**/*Component*.*",
                "**/*BR*.*",
                "**/Manifest*.*",
                "**/*\$Lambda$*.*",
                "**/*Companion*.*",
                "**/*Module*.*",
                "**/*Dagger*.*",
                "**/*Hilt*.*",
                "**/*MembersInjector*.*",
                "**/*_MembersInjector.class",
                "**/*_Factory*.*",
                "**/*_Provide*Factory*.*",
                "**/*Extensions*.*",
                // sealed and data classes
                "**/*\$Result.*",
                "**/*\$Result$*.*",
                // adapters generated by moshi
                "**/*JsonAdapter.*",
                "**/*Activity*",
                "**/di/**",
                "**/hilt*/**",
                "**/entrypoint/**",
                "**/theme/**",
                "**/*Screen*.*"
            )

            val javaTree = fileTree("${project.buildDir}/intermediaries/javac/$buildTypeName/classes") {
                exclude(fileFilters)
            }

            val kotlinTree = fileTree("${project.buildDir}/tmp/kotlin-classes/$buildTypeName") {
                exclude(fileFilters)
            }
            classDirectories.setFrom(files(javaTree, kotlinTree))

            executionData.setFrom(files("${project.buildDir}/jacoco/${testTaskName}.exec"))

            val coverageDirectories = listOf(
                "${project.projectDir}/src/main/java",
                "${project.projectDir}/src/$buildTypeName/java"
            )

            sourceDirectories.setFrom(files(coverageDirectories))
            additionalClassDirs.setFrom(files(coverageDirectories))

        }
    }

}
kapt {
    correctErrorTypes = true
}
