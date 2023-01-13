plugins {
    id("com.android.library")
    id("com.google.dagger.hilt.android")
    kotlin(module = "android")
    kotlin(module = "kapt")
}

android {
    namespace = "net.devetude.choonsikdorak.data.remote"

    compileSdk = AndroidSdkVersion.COMPILE

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }

        getByName("release") {
            isMinifyEnabled = true
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
    implementation(Dependency.Retrofit2.Core.notation)
    implementation(Dependency.Retrofit2.ConverterGson.notation)

    implementation(Dependency.OkHttp3.Core.notation)
    implementation(Dependency.OkHttp3.LoggingInterceptor.notation)

    implementation(Dependency.Hilt.Android.notation)
    kapt(Dependency.Hilt.AndroidCompiler.notation)
}

kapt {
    correctErrorTypes = true
}
