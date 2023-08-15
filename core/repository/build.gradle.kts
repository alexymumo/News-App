plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.alexmumo.repository"
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

    implementation(project(":domain"))
    implementation(project(":core:network"))
    implementation(project(":core:database"))
    implementation(project(":common"))

    implementation(libs.android.core)
    implementation(libs.android.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.expresso.core)

    // Paging
    implementation(libs.bundles.paging)

    // Koin
    implementation(libs.bundles.koin)

    // Timber
    implementation(libs.timber)

    // Retrofit
    implementation(libs.retrofit.version)
    
    // Coroutine
    implementation(libs.bundles.coroutine)

    // Room
    implementation(libs.room.ktx)

    // Firebase
    implementation(libs.bundles.firebase)

}