import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.alexmumo.network"
    compileSdk = 33

    defaultConfig {
        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())
        //buildConfigField("String", "API_KEY", properties.getProperty("API_KEY"))
        minSdk = 26
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(project(":common"))

    implementation(libs.android.core)
    implementation(libs.android.appcompat)
    testImplementation(libs.junit)

    // Ktor
    implementation(libs.bundles.ktor)

    // Coroutine
    implementation(libs.bundles.coroutine)

    androidTestImplementation(libs.expresso.core)
    testImplementation(libs.mock.webserver)
    testImplementation(libs.core.test)
    testImplementation(libs.truth)

    // Okhttp, Retrofit
    implementation(libs.bundles.networking)

    // Robolectric
    implementation(libs.roboelectric)

    // Timber
    implementation(libs.timber)

    // Serialization-json
    implementation(libs.kotlin.serializatin)

    // Hilt
    implementation(libs.dagger.hilt)
    kapt(libs.hilt.compiler)
}
