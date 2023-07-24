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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
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

    // Coroutines
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.test)

    // Room
    testImplementation(libs.room.testing)
    implementation(libs.room.paging)
    implementation(libs.room.ktx)
    api(libs.room.runtime)
    kapt(libs.room.compiler)

    // Koin
    implementation(libs.koin.android)

    // Timber
    implementation(libs.timber)

}