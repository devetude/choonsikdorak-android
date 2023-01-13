buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependency.Gradle.notation)
        classpath(Dependency.Kotlin.GradlePlugin.notation)
        classpath(Dependency.Hilt.AndroidGradlePlugin.notation)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register(name = "clean", type = Delete::class) {
    delete(rootProject.buildDir)
}
