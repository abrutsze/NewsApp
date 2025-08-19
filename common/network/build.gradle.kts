@file:Suppress("OPT_IN_USAGE")

plugins {
    alias(libs.plugins.projectKotlinMultiplatform)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.request)
                implementation(projects.common.response)
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.koin.core)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.client.encoding)
                implementation(libs.ktor.client.logging)
                implementation(libs.coroutines.core)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.ktor.client.okhttp)
            }
        }

        iosMain {
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}

android {
    namespace = "com.project.common.network"
}
