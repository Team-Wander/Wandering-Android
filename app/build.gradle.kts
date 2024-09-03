plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.wadering.takeawalk"

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/DEPENDENCIES"
        }
    }
}

dependencies {
    // TODO: Add your project dependencies

    androidTestImplementation(libs.androidx.test.ext)
    implementation(libs.app.update.ktx)
}