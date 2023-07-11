plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.alexmumo.network"
    compileSdk = 33

    defaultConfig {
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(project(":common"))

    implementation(libs.android.core)
    implementation(libs.android.appcompat)
    testImplementation(libs.junit)

    // Coroutines
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.test)

    androidTestImplementation(libs.expresso.core)

    debugImplementation(libs.chunker.debug)
    releaseImplementation(libs.chunker.release)

    // Koin
    implementation(libs.koin.android)

    // Okhttp
    implementation(libs.okhttp.interceptor)
    implementation(libs.okhttp3.version)

    // Timber
    implementation(libs.timber)

    // Retrofit
    implementation(libs.retrofit.version)
    implementation(libs.retrofit.gson)

    // Serialization-json
    implementation(libs.kotlin.serializatin)

    // Coroutine
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.test)
}
