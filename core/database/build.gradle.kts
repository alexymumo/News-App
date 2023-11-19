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
    testImplementation(libs.junit)
    androidTestImplementation(libs.expresso.core)
    androidTestImplementation(libs.truth)
    testImplementation(libs.truth)
    androidTestImplementation(libs.core.testing)
    implementation(libs.core.ktx)
    implementation("androidx.test:core-ktx:1.5.0")


    // Paging
    implementation(libs.paging.runtime)

    // Robolectric
    testImplementation(libs.roboelectric)

    // Coroutine
    implementation(libs.bundles.coroutine)

    // Room
    testImplementation(libs.room.testing)
    implementation(libs.room.paging)
    implementation(libs.room.ktx)
    api(libs.room.runtime)
    kapt(libs.room.compiler)

    // Koin
    implementation(libs.bundles.koin)

    // Timber
    implementation(libs.timber)

}