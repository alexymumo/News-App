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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}


dependencies {

    implementation(project(":domain"))
    implementation(project(":core:network"))
    implementation(project(":core:database"))
    implementation(project(":common"))

    implementation(libs.android.core)
    implementation(libs.android.appcompat)

    // Paging
    implementation(libs.bundles.paging)

    // Timber
    implementation(libs.timber)

    // Retrofit
    implementation(libs.retrofit.version)
    
    // Coroutine
    implementation(libs.bundles.coroutine)

    // Room
    implementation(libs.room.ktx)

    // Hilt
    implementation(libs.dagger.hilt)
    kapt(libs.hilt.compiler)

    // Mockk
    testImplementation(libs.mockk.agent)
    testImplementation(libs.mockk)

    // Junit
    testImplementation(libs.junit)
    testImplementation(libs.junit.androidx.ktx)


    testImplementation(libs.core.test)
    testImplementation(libs.roboelectric)

}