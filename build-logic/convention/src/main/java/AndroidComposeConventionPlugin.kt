import build.configureAndroidCompose
import build.libs
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")

                extensions.configure<LibraryExtension> {
                    configureAndroidCompose(this)
                }

                dependencies {
                    add("implementation", libs.findBundle("compose").get())
                }
            }
        }
    }
}