pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "News-App"
include(":app")
include(":presentation")
include(":core:network")
include(":core:database")
include(":core:repository")
include(":domain")
include(":common")
include(":core:datastore")
