@Suppress("ConstPropertyName", "MemberVisibilityCanBePrivate")
object Deps {
    object Android {
        const val agpVersion = "8.10.1"
        const val libraryPlugin = "com.android.library"
        const val appPlugin = "com.android.application"
        const val multiplatformLibraryPlugin = "com.android.kotlin.multiplatform.library"
    }

    object Kotlin {
        // https://kotlinlang.org/
        const val version = "2.1.21"
        const val composePlugin = "org.jetbrains.kotlin.plugin.compose"
        const val multiplatformPlugin = "org.jetbrains.kotlin.multiplatform"
        const val jvmPlugin = "org.jetbrains.kotlin.jvm"
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:$version"

        // https://github.com/Kotlin/kotlinx.coroutines
        const val coroutinesVersion = "1.10.2"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"

        // https://github.com/Kotlin/kotlinx.serialization/
        const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1"
        const val serializationPlugin = "org.jetbrains.kotlin.plugin.serialization"
    }

    object Jetpack {
        // https://developer.android.com/jetpack/androidx/releases/activity
        const val composeActivity = "androidx.activity:activity-compose:1.10.1"

        // https://developer.android.com/jetpack/androidx/releases/compose-ui
        const val composeUiVersion = "1.8.0"
        const val composePlugin = "org.jetbrains.compose"

        // https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-navigation-routing.html
        const val composeNavigation = "org.jetbrains.androidx.navigation:navigation-compose:2.9.0-beta01"

        // https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-viewmodel.html
        const val composeViewModel = "org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.9.0-beta01"
    }

    object Ktor {
        // https://github.com/ktorio/ktor
        const val version = "3.1.3"
        const val core = "io.ktor:ktor-client-core:$version"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:$version"
        const val json = "io.ktor:ktor-serialization-kotlinx-json:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
        const val androidEngine = "io.ktor:ktor-client-okhttp:$version"
        const val iOSEngine = "io.ktor:ktor-client-darwin:$version"
    }

    object Koin {
        const val version = "4.1.0-RC1"

        // https://insert-koin.io/docs/reference/koin-compose/compose/
        const val core = "io.insert-koin:koin-core:$version"
        const val compose = "io.insert-koin:koin-compose:$version"
        const val viewModel = "io.insert-koin:koin-compose-viewmodel:$version"
        const val navigation = "io.insert-koin:koin-compose-viewmodel-navigation:$version"
    }
}
