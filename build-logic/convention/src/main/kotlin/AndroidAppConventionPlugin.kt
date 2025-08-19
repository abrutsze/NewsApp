import com.project.build_logic.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension


class AndroidAppConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {

        with(pluginManager) {
            apply(libs.findPlugin("kotlinMultiplatform").get().get().pluginId)
            apply(libs.findPlugin("androidApplication").get().get().pluginId)
            apply(libs.findPlugin("composeMultiplatform").get().get().pluginId)
            apply(libs.findPlugin("composeCompiler").get().get().pluginId)
        }
        extensions.configure<KotlinMultiplatformExtension> {

            sourceSets.apply {
                androidMain {
                    dependencies {
                        implementation(libs.findLibrary("androidx.activity.compose").get())
                        implementation(libs.findLibrary("androidx.appcompat").get())
                    }
                }
                iosMain {

                }
                commonMain {

                }
            }

        }

    }
}