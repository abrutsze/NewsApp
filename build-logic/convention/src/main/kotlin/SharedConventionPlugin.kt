import com.project.build_logic.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import com.project.build_logic.configureKotlinAndroid
import com.android.build.api.dsl.LibraryExtension


class SharedConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {

        extensions.configure<LibraryExtension>(::configureKotlinAndroid)

        extensions.configure<KotlinMultiplatformExtension> {

            sourceSets.apply {

                commonMain {
                    dependencies {
                        implementation(project(":common:request"))
                        implementation(project(":common:response"))
                        implementation(project(":common:network"))
                        implementation(project(":common:models"))
                        implementation(project(":common:mvvm"))
                        implementation(libs.findLibrary("koin.compose.viewmodel.nav").get())
                        implementation(libs.findLibrary("coroutines.core").get())
                    }
                }

                commonTest {
                    dependencies {
                        implementation(kotlin("test"))
                        implementation("app.cash.turbine:turbine:1.1.0") // для тестирования Flow
                        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.9.0") // корутины тестовые
                    }
                }
                androidMain {
                    dependencies {
                    }
                }

                iosMain {
                    dependencies {
                    }
                }

            }
        }
    }
}