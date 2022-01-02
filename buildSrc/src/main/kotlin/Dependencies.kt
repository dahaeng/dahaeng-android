import org.gradle.api.JavaVersion

object Application {
    const val minSdk = 24
    const val targetSdk = 30
    const val compileSdk = 30
    const val jvmTarget = "11"
    const val versionCode = 1
    const val versionName = "1.0.0"

    val targetCompat = JavaVersion.VERSION_11
    val sourceCompat = JavaVersion.VERSION_11
}

object Versions {
    object Essential {
        const val Kotlin = "1.5.30"
        const val Coroutines = "1.5.2"
        const val Gradle = "7.1.0-beta05"
        const val Ktx = "1.6.0"
    }

    object Ui {
        const val Material = "1.4.0"
    }
}

object Dependencies {
    val essential = listOf(
        "androidx.core:core-ktx:${Versions.Essential.Ktx}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Essential.Coroutines}"
    )

    val ui = listOf(
        "com.google.android.material:material:${Versions.Ui.Material}"
    )
}
