plugins {
    id(Dependency.Gradle.KOTLIN)
    id(Dependency.Gradle.LIBRARY)
    id(Dependency.Hilt.HILT_PLUGIN)
    id(Dependency.Gradle.KSP)
}

android {
    namespace = ProjectProperties.NameSpace.PRESENTATION
    compileSdk = ProjectProperties.Versions.COMPILE_SDK

    defaultConfig {
        minSdk = ProjectProperties.Versions.MIN_SDK
        testInstrumentationRunner = ProjectProperties.Test.TEST_RUNNER
        consumerProguardFiles(ProjectProperties.Files.CONSUMER_PROGUARD_FILES)
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

    compileOptions {
        sourceCompatibility = ProjectProperties.Versions.JAVA_VERSION
        targetCompatibility = ProjectProperties.Versions.JAVA_VERSION
    }

    kotlinOptions {
        jvmTarget = ProjectProperties.Versions.JVM_TARGET
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.LIFECYCLE)
    implementation(Dependency.AndroidX.SPLASH)

    implementation(Dependency.Compose.ACTIVITY_COMPOSE)
    implementation(platform(Dependency.Compose.COMPOSE_BOM))
    implementation(Dependency.Compose.COMPOSE)
    implementation(Dependency.Compose.COMPOSE_GRAPHICS)
    implementation(Dependency.Compose.COMPOSE_PREVIEW)
    implementation(Dependency.Compose.COMPOSE_MATERIAL3)
    implementation(Dependency.Compose.COMPOSE_MATERIAL)
    implementation(Dependency.Compose.COMPOSE_NAVIGATION)
    debugImplementation(Dependency.Compose.COMPOSE_TOOLING)
    implementation(Dependency.Compose.NAVIGATION_ANIMATION)
    implementation(Dependency.Compose.KOTLINX_COLLECTIONS_IMMUTABLE)

    implementation(Dependency.Hilt.HILT)
    ksp(Dependency.Hilt.HILT_COMPILER)
    implementation(Dependency.Hilt.HILT_NAVIGATION_FRAGMENT)
    implementation(Dependency.Hilt.HILT_NAVIGATION_COMPOSE)

    implementation(Dependency.Retrofit.RETROFIT)
    implementation(Dependency.Retrofit.RETROFIT_CONVERTER_GSON)
    implementation(Dependency.OkHttp.OKHTTP_LOGGING_INTERCEPTOR)
    implementation(Dependency.Coil.COIL)
    implementation(files("libs/oauth-5.10.0.aar"))

    implementation("androidx.security:security-crypto:1.1.0-alpha06")
    implementation("com.airbnb.android:lottie:3.1.0")
    implementation(Dependency.AndroidX.COMPOSE_LIFECYCLE)
    androidTestImplementation(platform(Dependency.Compose.COMPOSE_BOM))

    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.Test.ANDROID_JUNIT)
    androidTestImplementation(Dependency.Test.ESPRESSO)
    androidTestImplementation(Dependency.Test.COMPOSE_JUNIT)
    debugImplementation(Dependency.Test.COMPOSE_MANIFEST)
}