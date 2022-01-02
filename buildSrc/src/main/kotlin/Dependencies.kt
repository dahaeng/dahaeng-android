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
    const val FirebaseBom = "29.0.3"

    object Essential {
        const val Ktx = "1.6.0"
        const val Kotlin = "1.6.10"
        const val Coroutines = "1.5.2"
        const val Gradle = "7.1.0-beta05"
        const val GoogleService = "4.3.10"
    }

    object Ui {
        const val Material = "1.4.0"
    }

    object Util {
        const val Erratum = "1.0.1"
        const val Logeukes = "1.0.1"
        const val LeakCanary = "2.7"
        const val CheckDependencyUpdates = "1.5.0"
    }

    object Jetpack {
        const val Hilt = "2.40.5"
        const val Room = "2.3.0"
    }

    object OssLicense {
        const val Master = "17.0.0"
        const val Classpath = "0.10.4"
    }
}

object Dependencies {
    const val Hilt = "com.google.dagger:hilt-android:${Versions.Jetpack.Hilt}"
    const val HiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.Jetpack.Hilt}"
    const val RoomCompiler = "androidx.room:room-compiler:${Versions.Jetpack.Room}"

    const val FirebaseBom = "com.google.firebase:firebase-bom:${Versions.FirebaseBom}"

    val firebase = listOf("com.google.firebase:firebase-firestore-ktx")

    val Essential = listOf(
        "androidx.core:core-ktx:${Versions.Essential.Ktx}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Essential.Coroutines}"
    )

    val Ui = listOf(
        "com.google.android.material:material:${Versions.Ui.Material}",
        "com.google.android.gms:play-services-oss-licenses:${Versions.OssLicense.Master}"
    )

    val Util = listOf(
        "io.github.jisungbin:erratum:${Versions.Util.Erratum}",
        "io.github.jisungbin:logeukes:${Versions.Util.Logeukes}"
    )

    val Room = listOf(
        "androidx.room:room-ktx:${Versions.Jetpack.Room}",
        "androidx.room:room-runtime:${Versions.Jetpack.Room}"
    )

    val Debug = listOf(
        "com.squareup.leakcanary:leakcanary-android:${Versions.Util.LeakCanary}"
    )
}
