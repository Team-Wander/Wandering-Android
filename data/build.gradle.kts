import java.io.FileInputStream
import java.util.Properties

fun getApiKey(propertyKey: String): String {
    val propFile = rootProject.file("./local.properties")
    val properties = Properties()
    properties.load(FileInputStream(propFile))
    return properties.getProperty(propertyKey)
}

plugins {
    id(Dependency.Gradle.LIBRARY)
    id(Dependency.Gradle.KOTLIN)
    id(Dependency.Gradle.KSP)
}

android {
    namespace = ProjectProperties.NameSpace.DATA
    compileSdk = ProjectProperties.Versions.COMPILE_SDK

    defaultConfig {
        minSdk = ProjectProperties.Versions.MIN_SDK

        testInstrumentationRunner = ProjectProperties.Test.TEST_RUNNER
        consumerProguardFiles(ProjectProperties.Files.CONSUMER_PROGUARD_FILES)

        buildConfigField(
            type = "String",
            name = "ADDRESS_API_KEY",
            getApiKey("ADDRESS_API_KEY")
        )

        buildConfigField(
            type = "String",
            name = "SCHOOL_API_KEY",
            getApiKey("SCHOOL_API_KEY")
        )
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(ProjectProperties.Files.DEFAULT_PROGUARD_FILES),
                ProjectProperties.Files.PROGUARD_FILES
            )
        }
    }
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = ProjectProperties.Versions.JAVA_VERSION
        targetCompatibility = ProjectProperties.Versions.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = ProjectProperties.Versions.JVM_TARGET
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.APPCOMPAT)
    implementation(Dependency.Google.MATERIAL)
    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.Test.ANDROID_JUNIT)
    androidTestImplementation(Dependency.Test.ESPRESSO)

    implementation(Dependency.Hilt.HILT)
    ksp(Dependency.Hilt.HILT_COMPILER)

    implementation(Dependency.OkHttp.OKHTTP)

    implementation (Dependency.Moshi.MOSHI_KOTLIN)

    implementation(Dependency.OkHttp.OKHTTP_LOGGING_INTERCEPTOR)
    implementation(Dependency.Retrofit.RETROFIT)
    implementation(Dependency.Retrofit.RETROFIT_CONVERTER_GSON)

    implementation(Dependency.DataStore.PREFERENCES)
}