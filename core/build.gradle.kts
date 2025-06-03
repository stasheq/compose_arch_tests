plugins {
    id(Deps.Kotlin.multiplatformPlugin)
    id(Deps.Android.multiplatformLibraryPlugin)
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
                implementation(Deps.Ktor.core)
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
