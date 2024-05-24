[![codecov](https://codecov.io/gh/alexymumo/News-App/graph/badge.svg?token=15AJMIDLLE)](https://codecov.io/gh/alexymumo/News-App)

## News-App
- News App is a multi-module news app built using Kotlin, Jetpack Compose and [News API]("https://newsapi.org/")

## Table of Contents
- [Features](#features)
- [Architecture](#architecture)
- [Tech-Stack](#tech-stack)
- [Screenshots](#screenshots)
- [Tests](#tests)
- [Demo](#demo)

## Features
- Display news into different categories ✔️
- Search trending news ✔️
- BookMarks ✔️
- Offline support ✔️
- Support different languages,Themes 🚧
- Share News 🚧

## Architecture
- Built using clean architecture 

## Tech-Stack
- [Kotlin](https://kotlin.org) - Modern but already mature programming language aimed to make developers happier. It's concise, safe, interoperable with Java and other languages, and provides many ways to reuse code between multiple platforms for productive programming.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project
- [Jetpack Components](https://developer.android.com/jetpack)
    - [Jetpack Compose](https://developer.android.com/jetpack/compose) - Modern toolkit for building native UI.
    - [Android KTX](https://developer.android.com/kotlin/ktx.html) - Provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
    - [AndroidX](https://developer.android.com/jetpack/androidx) - Major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.
        -   [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
        -   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.
    - [Room](https://developer.android.com/training/data-storage/room) - Provides an abstraction layer over SQLite used for offline data caching.
    - [Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started) - Component that allows easier implementation of navigation from simple button clicks to more complex patterns.
    - [Paging](https://developer.android.com/topic/libraries/architecture/paging/v3-overview)-Helps load and display pages of data from a larger dataset from local storage or over network
- [Retrofit](https://square.github.io/retrofit/) - Type-safe http client and supports coroutines out of the box.
- [GSON](https://github.com/square/gson) - JSON Parser,used to parse requests on the data layer for Entities and understands Kotlin non-nullable and default parameters.
- [OkHttp-Logging-Interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor) - Logs HTTP request and response data.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines.
- [Flow](https://developer.android.com/kotlin/flow) - Flows are built on top of coroutines and can provide multiple values. A flow is conceptually a stream of data that can be computed asynchronously.
- [Timber](https://github.com/JakeWharton/timber) - Library for easier logging.
- [Coil](https://coil-kt.github.io/coil/compose/) - Image Library from loading images from the database and caching in memory.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines,provides runBlocking coroutine builder used in tests.
- [Material3]() - Design system for compose
- [Maestro](https://maestro.mobile.dev/) - Is the simplest and most effective mobile UI testing framework.
- [Firebase Crashlytics]() - lightweight, realtime crash reporter that helps you track, prioritize, and fix stability issues that erode your app quality
- [Datastore](https://developer.android.com/topic/libraries/architecture/datastore) - data storage solution that allows you to store key-value pairs or typed objects with protocol buffers
 

## Screenshots
Home

![Screenshot 2024-04-28 184741](https://github.com/alexymumo/News-App/assets/56880898/5827eacf-2a54-4686-9402-2e45f6fa6d74)
![Screenshot 2024-04-28 184830](https://github.com/alexymumo/News-App/assets/56880898/9ce4a4b0-54f0-4290-8c6c-5746a0adad1a)

Search

![Screenshot 2024-04-28 185209](https://github.com/alexymumo/News-App/assets/56880898/040d8689-916a-4101-bfd5-314f3f36814a)

BookMarks

![Screenshot 2024-04-28 185509](https://github.com/alexymumo/News-App/assets/56880898/89b5dfee-f2d8-4961-9c40-501d44f55f6e)


## Tests/home/alex/AndroidStudioProjects/droidconKeKotlin
- [Mockk](https://mockk.io/) - Mocking library for Kotlin
- [Truth]() - Assertion library by google
- [Junit4](https://github.com/junit-team/junit4) - Simple framework to write repeatable tests. It is an instance of the Unit architecture for unit testing frameworks. 
- [Robolectric](https://robolectric.org/) -  Framework that brings fast and reliable unit tests to Android

## Demo
