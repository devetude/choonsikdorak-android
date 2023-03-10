sealed class Dependency(
    private val group: String,
    private val name: String,
    private val version: String
) {
    val pluginId = "$group.$name"
    val notation = "$group:$name:$version"

    object Gradle : Dependency(
        group = "com.android.tools.build",
        name = "gradle",
        version = "7.3.1"
    )

    sealed class Kotlin(private val name: String) : Dependency(
        group = "org.jetbrains.kotlin",
        name = name,
        version = "1.8.0"
    ) {
        object GradlePlugin : Kotlin(name = "kotlin-gradle-plugin")
    }

    sealed class Hilt(private val name: String) : Dependency(
        group = "com.google.dagger",
        name = name,
        version = "2.44"
    ) {
        object AndroidGradlePlugin : Hilt(name = "hilt-android-gradle-plugin")

        object Android : Hilt(name = "hilt-android")

        object AndroidCompiler : Hilt(name = "hilt-android-compiler")
    }

    sealed class Retrofit2(private val name: String) : Dependency(
        group = "com.squareup.retrofit2",
        name = name,
        version = "2.9.0"
    ) {
        object Core : Retrofit2(name = "retrofit")

        object ConverterGson : Retrofit2(name = "converter-gson")
    }

    sealed class OkHttp3(private val name: String) : Dependency(
        group = "com.squareup.okhttp3",
        name = name,
        version = "4.10.0"
    ) {
        object Core : OkHttp3(name = "okhttp")

        object LoggingInterceptor : OkHttp3(name = "logging-interceptor")
    }
}
