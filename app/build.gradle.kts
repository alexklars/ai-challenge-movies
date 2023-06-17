plugins {
    id(Android.application)
    id(Kotlin.android)
    kotlin("kapt")
    id(Hilt.plugin)
}

android {
    namespace = Config.namespace
    compileSdk = Config.compileSdkVersion

    defaultConfig {
        applicationId = Config.namespace
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        versionCode = Config.versionCode
        versionName = Config.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.compilerVersion
    }
    packagingOptions {
        resources.excludes += "META-INF/AL2.0"
        resources.excludes += "META-INF/LGPL2.1"
    }
}

dependencies {

    implementation(Material.material)
    implementation(AndroidX.Core.ktx)
    implementation(AndroidX.Activity.compose)
    implementation(AndroidX.Constraintlayout.compose)
    implementation(AndroidX.Navigation.compose)
    implementation(platform(Compose.BOM.bom))
    implementation(Retrofit.retrofit)
    implementation(Retrofit.converterGson)
    implementation(AndroidX.Room.runtime)
    kapt(AndroidX.Room.compiler)
    implementation(Hilt.android)
    kapt(Hilt.androidCompiler)
    implementation(Compose.UI.ui)
    implementation(Compose.UI.preview)
    implementation(Compose.Material.material)

    debugImplementation(Compose.UI.tooling)
    debugImplementation(Compose.UI.manifest)

    androidTestImplementation(Compose.UI.junit)
}

kapt {
    correctErrorTypes = true
}