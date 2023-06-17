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

plugins {
    id(Hilt.plugin) version Hilt.version apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}