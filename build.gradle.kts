plugins {
    id(Deps.Android.appPlugin).version(Deps.Android.agpVersion).apply(false)
    id(Deps.Android.libraryPlugin).version(Deps.Android.agpVersion).apply(false)
    id(Deps.Jetpack.composePlugin).version(Deps.Jetpack.composeUiVersion).apply(false)
    id(Deps.Kotlin.composePlugin).version(Deps.Kotlin.version).apply(false)
    id(Deps.Kotlin.multiplatformPlugin).version(Deps.Kotlin.version).apply(false)
    id(Deps.Kotlin.serializationPlugin).version(Deps.Kotlin.version).apply(false)
}
