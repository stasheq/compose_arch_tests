plugins {
    id(Deps.Kotlin.multiplatformPlugin)
    id(Deps.Android.multiplatformLibraryPlugin)
    id(Deps.Kotlin.serializationPlugin)
}

kotlin {
    androidLibrary {
        namespace = Config.coreId
        compileSdk = Config.compileSdk
        minSdk = Config.minSdk
    }

    val xcfName = "coreKit"

    iosX64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosSimulatorArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(Deps.Kotlin.stdLib)
                implementation(Deps.Kotlin.coroutinesCore)
                implementation(Deps.Kotlin.serializationJson)
                implementation(Deps.Ktor.core)
                implementation(Deps.Ktor.contentNegotiation)
                implementation(Deps.Ktor.json)
                implementation(Deps.Koin.core)
            }
        }

        androidMain {
            dependencies {
                implementation(Deps.Ktor.androidEngine)
            }
        }

        iosMain {
            dependencies {
                implementation(Deps.Ktor.iOSEngine)
            }
        }
    }
}
