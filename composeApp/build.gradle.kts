import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id(Deps.Kotlin.multiplatformPlugin)
    id(Deps.Android.appPlugin)
    id(Deps.Jetpack.composePlugin)
    id(Deps.Kotlin.composePlugin)
    id(Deps.Kotlin.serializationPlugin)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

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

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(Deps.Ktor.core)
            implementation(Deps.Kotlin.coroutinesCore)
            implementation(Deps.Jetpack.composeNavigation)
            implementation(Deps.Jetpack.composeViewModel)
            implementation(Deps.Koin.core)
        }
        iosMain.dependencies {
            implementation(Deps.Ktor.iOSEngine)
        }
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(Deps.Jetpack.composeActivity)
            implementation(Deps.Ktor.androidEngine)
            implementation(Deps.Kotlin.coroutinesAndroid)
        }
    }
}

android {
    namespace = Config.appId
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.appId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}
