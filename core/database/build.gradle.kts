plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.alexmumo.database"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.android.core)
    implementation(libs.android.appcompat)
    implementation(libs.junit.androidx.ktx)
    implementation(libs.core.ktx)
    implementation(libs.core.test)

    // Paging
    implementation(libs.paging.runtime)

    // Coroutine
    implementation(libs.bundles.coroutine)

    // Room
    implementation(libs.room.paging)
    implementation(libs.room.ktx)
    api(libs.room.runtime)
    kapt(libs.room.compiler)

    // Timber
    implementation(libs.timber)

    // Hilt
    implementation(libs.dagger.hilt)
    kapt(libs.hilt.compiler)


    testImplementation(libs.junit)
    testImplementation(libs.truth)
    testImplementation(libs.room.testing)
    testImplementation(libs.roboelectric)

    androidTestImplementation(libs.core.testing)
    androidTestImplementation(libs.expresso.core)
    androidTestImplementation(libs.truth)
    androidTestImplementation(libs.junit)
}