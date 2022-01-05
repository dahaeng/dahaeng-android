plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.android.gms.oss-licenses-plugin")
    id("name.remal.check-dependency-updates") version Versions.Util.CheckDependencyUpdates
    id("com.google.gms.google-services")
}

android {
    compileSdk = Application.compileSdk

    defaultConfig {
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk
        versionCode = Application.versionCode
        versionName = Application.versionName
        multiDexEnabled = true
    }

    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        release {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
        }
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
    implementation(Dependencies.Hilt)
    implementation(platform(Dependencies.FirebaseBom))

    implementation(project(":data"))
    implementation(project(":domain"))

    Dependencies.Ui.forEach(::implementation)
    Dependencies.Ktx.forEach(::implementation)
    Dependencies.Util.forEach(::implementation)
    Dependencies.Room.forEach(::implementation)
    Dependencies.Firebase.forEach(::implementation)
    Dependencies.Essential.forEach(::implementation)

    Dependencies.Debug.forEach(::debugImplementation)

    kapt(Dependencies.HiltCompiler) // TODO: ksp
    kapt(Dependencies.RoomCompiler) // TODO: ksp
}
