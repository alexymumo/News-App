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
- Display news into categories 
- Search trending news
- BookMarks 
- Offline support
- Support different languages,Themes,

## Architecture
- Built using clean architecture 

## Tech-Stack
- [Kotlin](https://kotlin.org) - Modern but already mature programming language aimed to make developers happier. It's concise, safe, interoperable with Java and other languages, and provides many ways to reuse code between multiple platforms for productive programming.
- [Koin](https://hilt.com) - Dependency injection library for kotlin and android
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
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines,provides runBlocking coroutine builder used in tests.
- [Truth]() -Assertion library by google
- [Material3]() - Design system for compose


## Screenshots

## Tests

## Demo
