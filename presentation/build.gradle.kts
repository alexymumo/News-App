plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.alexmumo.presentation"
    compileSdk = 33

    defaultConfig {
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

    // Compose
    implementation(libs.bundles.compose)

    // Koin
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.koin.core)

    // Lifecycle
    implementation(libs.bundles.lifecycle)

    // Navigation
    implementation(libs.compose.navigation)
    androidTestImplementation(libs.compose.navigation.testing)

    testImplementation(libs.junit)
    testImplementation(libs.roboelectric)

    testImplementation("org.robolectric:robolectric:4.9")

    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")

    // Splashscreen
    implementation(libs.splashscreen.core)

    // Coil-Compose
    implementation(libs.coil.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.expresso.core)

    // Paging
    implementation(libs.paging.runtime)
    implementation(libs.paging.compose)

    // Coroutines
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.test)

    // Timber
    implementation(libs.timber)

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.4.3")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.4.3")

}


kapt {
    correctErrorTypes = true
}