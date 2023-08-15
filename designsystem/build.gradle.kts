
plugins {
    //alias(libs.plugins.android.library)
    //alias(libs.plugins.org.jetbrains.kotlin.android)
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.alexmumo.designsystem"
    compileSdk = 33

    defaultConfig {
        minSdk = 22

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

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

kotlin {
    sourceSets {
        all {
            languageSettings.optIn("androidx.compose.material3.ExperimentalMaterial3Api")
        }
    }
}

dependencies {

    // Compose
    implementation(libs.bundles.compose)

    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")


}