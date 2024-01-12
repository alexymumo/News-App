plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    //id("com.google.gms.google-services")
    //id("com.google.firebase.crashlytics")
}

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
            isIncludeAndroidResources = false
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
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
            languageSettings.optIn("androidx.compose.foundation.ExperimentalFoundationApi")
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

    implementation(libs.lifecycle.runtime.compose)

    // Coil-Compose
    implementation(libs.coil.compose)

    // Unit Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.expresso.core)
    testImplementation(libs.mockk)
    androidTestImplementation(libs.mockk.android)
    testImplementation(libs.mockk.agent)


    // Paging
    implementation(libs.paging.runtime)
    implementation(libs.paging.compose)

    // Coroutine
    implementation(libs.bundles.coroutine)

    // Timber
    implementation(libs.timber)

    // Splash - Screen
    implementation(libs.splash.screen)

    // Roboelectric
    implementation(libs.roboelectric)

    // Hilt
    implementation(libs.dagger.hilt)
    kapt(libs.hilt.compiler)

    // Android Test
    androidTestImplementation(libs.junit.ext)
    debugImplementation(libs.compose.ui.test.manifest)




}


kapt {
    correctErrorTypes = true
}