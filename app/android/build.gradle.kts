plugins {
    id("com.android.application")
    kotlin(module = "android")
}

android {
    namespace = "net.devetude.choonsikdorak.android"

    compileSdk = AndroidSdkVersion.COMPILE

    defaultConfig {
        targetSdk = AndroidSdkVersion.TARGET
        minSdk = AndroidSdkVersion.MIN

        versionCode = AndroidAppVersion.CODE
        versionName = AndroidAppVersion.NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
        }

        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile(name = "proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    implementation(project(path = ":ui:android"))
}
