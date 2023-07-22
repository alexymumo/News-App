plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.alexmumo.datastore"
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
    implementation(libs.android.core)
    implementation(libs.android.appcompat)
    testImplementation(libs.junit)

    // Coroutines
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.test)
    
    // Datastore
    implementation(libs.datastore)

    // Koin
    implementation(libs.koin.android)

    // Timber
    implementation(libs.timber)
}