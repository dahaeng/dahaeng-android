import org.gradle.api.JavaVersion

object Application {
    const val minSdk = 24
    const val targetSdk = 31
    const val compileSdk = 31
    const val jvmTarget = "11"
    const val versionCode = 1
    const val versionName = "1.0.0"

    val targetCompat = JavaVersion.VERSION_11
    val sourceCompat = JavaVersion.VERSION_11
}

object Versions {
    const val Kakao = "2.8.4"
    const val FirebaseBom = "29.0.3"

    object Essential {
        const val Kotlin = "1.6.10"
        const val Coroutines = "1.6.0"
        const val Gradle = "7.1.0"
        const val GoogleService = "4.3.3"
    }

    object Ktx {
        const val Core = "1.7.0"
        const val Fragment = "1.4.0"
        const val LifeCycle = "2.4.0"
        const val ViewModel = "2.4.0"
        const val Navigation = "2.3.5"
    }

    object Ui {
        const val Glide = "4.12.0"
        const val Lottie = "4.2.2"
        const val Flexbox = "3.0.0"
        const val Material = "1.5.0"
        const val AppCompat = "1.4.1"
        const val ExoPlayer = "2.16.1"
        const val Splash = "1.0.0-beta01"
        const val SmoothBottomBar = "1.7.9"
        const val ConstraintLayout = "2.1.3"
    }

    object Util {
        const val Moshi = "1.13.0"
        const val Erratum = "1.0.1"
        const val Logeukes = "1.0.1"
        const val Jackson = "2.13.1"
        const val LeakCanary = "2.8.1"
        const val SystemUiController = "1.0.0"
        const val SecretsGradlePlugin = "2.0.0"
        const val CheckDependencyUpdates = "1.5.0"
    }

    object Location {
        const val Gms = "19.0.1"
        const val Locus = "4.0.1"
    }

    object Jetpack {
        const val Hilt = "2.40.5"
    }

    object OssLicense {
        const val Master = "17.0.0"
        const val Classpath = "0.10.4"
    }
}

object Dependencies {
    const val Kakao = "com.kakao.sdk:v2-user:${Versions.Kakao}"
    const val Hilt = "com.google.dagger:hilt-android:${Versions.Jetpack.Hilt}"
    const val FirebaseBom = "com.google.firebase:firebase-bom:${Versions.FirebaseBom}"

    object Compiler {
        const val Glide = "com.github.bumptech.glide:compiler:${Versions.Ui.Glide}"
        const val Hilt = "com.google.dagger:hilt-android-compiler:${Versions.Jetpack.Hilt}"
    }

    val Firebase = listOf(
        "com.google.firebase:firebase-storage-ktx",
        "com.google.firebase:firebase-firestore-ktx"
    )

    val Essential = listOf(
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Essential.Coroutines}"
    )

    val Ktx = listOf(
        "androidx.core:core-ktx:${Versions.Ktx.Core}",
        "androidx.fragment:fragment-ktx:${Versions.Ktx.Fragment}",
        "androidx.navigation:navigation-ui-ktx:${Versions.Ktx.Navigation}",
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Ktx.LifeCycle}",
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Ktx.ViewModel}",
        "androidx.navigation:navigation-fragment-ktx:${Versions.Ktx.Navigation}"
    )

    val Ui = listOf(
        "com.airbnb.android:lottie:${Versions.Ui.Lottie}",
        "com.github.bumptech.glide:glide:${Versions.Ui.Glide}",
        "androidx.appcompat:appcompat:${Versions.Ui.AppCompat}",
        "androidx.core:core-splashscreen:${Versions.Ui.Splash}",
        "com.google.android.flexbox:flexbox:${Versions.Ui.Flexbox}",
        "com.google.android.material:material:${Versions.Ui.Material}",
        "com.google.android.exoplayer:exoplayer:${Versions.Ui.ExoPlayer}",
        "com.google.android.exoplayer:exoplayer-core:${Versions.Ui.ExoPlayer}",
        "com.github.ibrahimsn98:SmoothBottomBar:${Versions.Ui.SmoothBottomBar}",
        "androidx.constraintlayout:constraintlayout:${Versions.Ui.ConstraintLayout}",
        "com.google.android.gms:play-services-oss-licenses:${Versions.OssLicense.Master}",
    )

    val Util = listOf(
        "com.squareup.moshi:moshi:${Versions.Util.Moshi}",
        "io.github.jisungbin:erratum:${Versions.Util.Erratum}",
        "io.github.jisungbin:logeukes:${Versions.Util.Logeukes}",
        "land.sungbin:systemuicontroller:${Versions.Util.SystemUiController}"
    )

    val Location = listOf(
        "com.github.BirjuVachhani:locus-android:${Versions.Location.Locus}",
        "com.google.android.gms:play-services-location:${Versions.Location.Gms}"
    )

    val Jackson = listOf(
        "com.fasterxml.jackson.core:jackson-core:${Versions.Util.Jackson}",
        "com.fasterxml.jackson.core:jackson-databind:${Versions.Util.Jackson}",
        "com.fasterxml.jackson.core:jackson-annotations:${Versions.Util.Jackson}",
        "com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.Util.Jackson}"
    )

    val Debug = listOf(
        "com.squareup.leakcanary:leakcanary-android:${Versions.Util.LeakCanary}"
    )
}
