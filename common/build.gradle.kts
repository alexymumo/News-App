import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

val localPropertiesFile = rootProject.file("local.properties")
val localProperties = Properties().apply {
    load(FileInputStream(localPropertiesFile))
}
val apiKey: String = localProperties.getProperty("apiKey")

android {
    namespace = "com.alexmumo.common"
    compileSdk = 33

    defaultConfig {
        buildConfigField("String","API_KEY", "\"$apiKey\"")
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
    implementation(libs.android.core)
    implementation(libs.android.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.expresso.core)
}