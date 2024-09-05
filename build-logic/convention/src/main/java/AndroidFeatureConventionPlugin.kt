import build.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("com.google.dagger.hilt.android")
                apply("com.google.devtools.ksp")
            }
            dependencies {
                add("implementation", project(":core:ui"))
                add("implementation", project(":core:designsystem"))

                add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())
                add("implementation", libs.findLibrary("kotlinx.datetime").get())
                add("implementation", libs.findLibrary("kotlinx.immutable").get())

                add("ksp", libs.findLibrary("ksp").get())
            }
        }
    }
}
