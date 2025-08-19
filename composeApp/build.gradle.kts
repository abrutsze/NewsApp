import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.projectKotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinCocoapods)
}

kotlin {
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    cocoapods {
        homepage = "ComposeApp Homepage"
        summary = "ComposeApp Description"
        version = "1.0"
        ios.deploymentTarget = "15.3"
        podfile = project.file("../iosApp/Podfile")

        framework {
            baseName = "ComposeApp"
            compilerOptions.optIn.add("-Xbinary=bundleId=com.compose.cocoapod_sample")
            isStatic = true
        }

        pod("libPhoneNumber-iOS") {
            version = "1.2.0"
            extraOpts += listOf("-compiler-option", "-fmodules")
        }

        pod("FormatterKit") {
            version = "1.9.0"
            extraOpts += listOf("-compiler-option", "-fmodules")
        }
    }
    sourceSets {
        
        androidMain.dependencies {
//            implementation(compose.preview)
//            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            api(projects.shared)
            implementation(projects.common.models)
            implementation(projects.common.mvvm)
            implementation(projects.screens)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.materialIconsExtended)
            implementation(compose.material3)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.navigation.compose)
            implementation(libs.coil3)
            implementation(libs.coil3.network)
            implementation(libs.koin.compose.viewmodel.nav)
        }
    }
}

android {
    namespace = "com.project.news"
}


