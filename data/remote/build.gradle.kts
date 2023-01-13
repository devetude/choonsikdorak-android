plugins {
    id("com.android.library")
    kotlin(module = "android")
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
}
