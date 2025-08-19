import org.jetbrains.compose.compose
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.projectKotlinMultiplatform)
    alias(libs.plugins.projectShared)
    alias(libs.plugins.kotlinCocoapods)
}

kotlin {

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }
    cocoapods {
        homepage = "Shared Homepage"
        summary = "Shared Description"
        version = "1.0"
        ios.deploymentTarget = "15.3"
        podfile = project.file("../iosApp/Podfile")

        framework {
            baseName = "shared"
            compilerOptions.optIn.add("-Xbinary=bundleId=com.compose.cocoapod_sample")
            isStatic = true
        }

        pod("PhoneNumberKit") {
            version = "4.0.1"
            extraOpts += listOf("-compiler-option", "-fmodules")
        }

    }
}

android {
    namespace = "com.project.shared"
}
