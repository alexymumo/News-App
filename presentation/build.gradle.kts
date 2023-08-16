import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

val localPropertiesFile = rootProject.file("local.properties")
val localProperties = Properties()
localProperties.load(FileInputStream(localPropertiesFile))

android {
    namespace = "com.alexmumo.presentation"
    compileSdk = 33

    defaultConfig {
        //buildConfigField("String", "APIKEY",localProperties.getProperty("APIKEY"))
        minSdk = 26
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
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
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
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
    implementation(project(":domain"))
    implementation(project(":core:datastore"))
    implementation(project(":common"))
    implementation(project(":core:database"))
    implementation(project(":core:repository"))
    implementation(project(":designsystem"))

    // Compose
    implementation(libs.bundles.compose)

    // Koin
    implementation(libs.bundles.koin)

    // Lifecycle
    implementation(libs.bundles.lifecycle)

    // Navigation
    implementation(libs.compose.navigation)
    androidTestImplementation(libs.compose.navigation.testing)

    // Roboelectric
    testImplementation(libs.junit)
    testImplementation(libs.roboelectric)

    //Firebase
    implementation(libs.bundles.firebase)

    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")

    // Coil-Compose
    implementation(libs.coil.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.expresso.core)

    // Paging
    implementation(libs.paging.runtime)
    implementation(libs.paging.compose)

    // Coroutine
    implementation(libs.bundles.coroutine)

    // Timber
    implementation(libs.timber)

    // Splash - Screen
    implementation(libs.splash.screen)

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.4.3")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.4.3")

}


kapt {
    correctErrorTypes = true
}