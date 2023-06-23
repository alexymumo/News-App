plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.appdistribution")
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Modules
    implementation(project(":presentation"))
    implementation(project(":core:repository"))
    implementation(project(":core:network"))
    implementation(project(":core:database"))

    // Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")

    // Koin
    implementation("io.insert-koin:koin-android:3.3.3")

    // Paging
    implementation("androidx.paging:paging-compose:1.0.0-alpha20")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.firebase:firebase-crashlytics-ktx:18.3.2")
    implementation("com.google.firebase:firebase-analytics-ktx:21.2.0")

    // Timber
    implementation("com.jakewharton.timber:timber:5.0.1")


    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("com.google.firebase:firebase-crashlytics-ktx:18.3.2")
    implementation("com.google.firebase:firebase-analytics-ktx:21.2.0")


    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
}