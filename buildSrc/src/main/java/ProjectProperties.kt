import org.gradle.api.JavaVersion

object ProjectProperties {

    object Test {
        const val TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    }

    object Id {
        const val APPLICATION_ID = "com.wanderring.Do"
    }

    object Files {
        const val CONSUMER_PROGUARD_FILES = "consumer-rules.pro"
        const val DEFAULT_PROGUARD_FILES = "proguard-android-optimize.txt"
        const val PROGUARD_FILES = "proguard-rules.pro"
    }

    object Versions {
        const val COMPILE_SDK = 34
        const val MIN_SDK = 24
        const val TARGET_SDK = 34
        const val JVM_TARGET = "17"
        const val VERSION_CODE = 1
        const val VERSION_NAME = "1.0"
        const val KOTLIN_COMPILER_EXTENSION = "1.4.3"

        val JAVA_VERSION = JavaVersion.VERSION_17
    }

    object NameSpace {
        const val PRESENTATION = "com.wanderring.presentation"
        const val DOMAIN = "com.wanderring.domain"
        const val DATA = "com.wanderring.data"
        const val APP = "com.wanderring.Do"
    }
}