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
    implementation(Dependencies.Kakao)
    implementation(project(":domain"))

    Dependencies.Room.forEach(::implementation)
    implementation(platform(Dependencies.FirebaseBom))

    Dependencies.Firebase.forEach(::implementation)
    Dependencies.Essential.forEach(::implementation)

    kapt(Dependencies.RoomCompiler) // TODO: ksp
}
