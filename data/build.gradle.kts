plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
}

android {
    compileSdk = Application.compileSdk

    defaultConfig {
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk
        multiDexEnabled = true
    }

    sourceSets {
        getByName("main").run {
            java.srcDirs("src/main/kotlin")
        }
    }

    compileOptions {
        sourceCompatibility = Application.sourceCompat
        targetCompatibility = Application.targetCompat
    }

    kotlinOptions {
        jvmTarget = Application.jvmTarget
    }
}

dependencies {
    val dataLayerOnlyDependencies = listOf(Dependencies.Kakao)

    implementation(projects.domain)
    implementation(platform(Dependencies.FirebaseBom))

    Dependencies.Room.forEach(::implementation)
    Dependencies.Firebase.forEach(::implementation)
    Dependencies.Essential.forEach(::implementation)
    dataLayerOnlyDependencies.forEach(::implementation)

    kapt(Dependencies.RoomCompiler) // TODO: ksp
}
