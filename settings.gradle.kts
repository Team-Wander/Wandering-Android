pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://devrepo.kakao.com/nexus/repository/kakaomap-releases/")
    }
}

rootProject.name = "takeawalk"
include(":app")

include(":feature:main")
include(":feature:onboarding")
include(":feature:scadule")
include(":feature:search")
include(":feature:my")
include(":core:common")
include(":core:data")
include(":core:designsystem")
include(":core:domain")
include(":core:model")
include(":core:ui")

gradle.startParameter.excludedTaskNames.addAll(listOf(":build-logic:convention:testClasses"))