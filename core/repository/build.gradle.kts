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

    // Mockk
    testImplementation("io.mockk:mockk:1.13.8")
    testImplementation("io.mockk:mockk-agent:1.13.8")


    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.test.ext:junit-ktx:1.1.5")
    testImplementation("androidx.test:core-ktx:1.5.0")
    testImplementation("org.robolectric:robolectric:4.9.2")


}