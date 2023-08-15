import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
val localPropertiesFile = rootProject.file("local.properties")
val localProperties = Properties()
localProperties.load(FileInputStream(localPropertiesFile))


android {
    namespace = "com.alexmumo.network"
    compileSdk = 33

    defaultConfig {
       // buildConfigField("String", "APIKEY", localProperties.getProperty("APIKEY"))
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
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(project(":common"))

    implementation(libs.android.core)
    implementation(libs.android.appcompat)
    testImplementation(libs.junit)

    // Coroutine
    implementation(libs.bundles.coroutine)

    // Espresso
    androidTestImplementation(libs.expresso.core)
    testImplementation("com.squareup.okhttp3:mockwebserver:4.10.0")
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation("androidx.test:core:1.5.0")

    // Koin
    implementation(libs.bundles.koin)

    // Okhttp, Retrofit
    implementation(libs.bundles.networking)

    // Robolectric
    implementation(libs.roboelectric)

    // Timber
    implementation(libs.timber)

    // Serialization-json
    implementation(libs.kotlin.serializatin)


}
