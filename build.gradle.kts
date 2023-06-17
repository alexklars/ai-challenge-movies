buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath(Android.plugin)
        classpath(Kotlin.plugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}