@file:Suppress("MemberVisibilityCanBePrivate")

object Android {
    const val application = "com.android.application"

    private const val androidPluginVersion = "7.3.1"
    const val plugin = "com.android.tools.build:gradle:$androidPluginVersion"
}

object Material {
    private const val group = "com.google.android.material"
    private const val version = "1.7.0"

    const val material = "$group:material:$version"
}

object Kotlin {
    const val android = "org.jetbrains.kotlin.android"

    private const val pluginVersion = "1.8.10"
    const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$pluginVersion"
}

object Hilt {
    const val plugin = "com.google.dagger.hilt.android"

    private const val group = "com.google.dagger"
    const val version = "2.44"

    const val android = "$group:hilt-android:$version"
    const val androidCompiler = "$group:hilt-android-compiler:$version"
}

object KotlinX {
    object Coroutines {
        private const val group = "org.jetbrains.kotlinx"
        private const val version = "1.6.0"

        const val coroutines = "$group:kotlinx-coroutines-android:$version"
    }
}

object AndroidX {
    object Core {
        private const val group = "androidx.core"
        private const val version = "1.9.0"

        const val ktx = "$group:core-ktx:$version"
    }

    object Activity {
        private const val group = "androidx.activity"
        private const val version = "1.7.1"

        const val compose = "$group:activity-compose:$version"
    }

    object Constraintlayout {
        private const val group = "androidx.constraintlayout"
        private const val version = "1.0.1"

        const val compose = "$group:constraintlayout-compose:$version"
    }

    object Navigation {
        private const val group = "androidx.navigation"
        private const val version = "2.5.3"

        const val compose = "$group:navigation-compose:$version"
    }
}

object Retrofit {
    private const val version = "2.9.0"

    const val retrofit = "com.squareup.retrofit2:retrofit:$version"
    const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
}

object Compose {

    // NOTE: Compose Compiler version depends on Kotlin version. Be careful when updating it.
    // Here is a list of compatible versions https://developer.android.com/jetpack/androidx/releases/compose-kotlin#pre-release_kotlin_compatibility
    const val compilerVersion = "1.4.4"

    object BOM {
        private const val version = "2023.05.01"

        const val bom = "androidx.compose:compose-bom:$version"
    }

    object UI {
        private const val group = "androidx.compose.ui"

        // For unknown reasons, Compose BOM does not download junit version, so we specify it manually
        private const val junitVersion = "1.4.3"

        const val ui = "$group:ui"
        const val tooling = "$group:ui-tooling"
        const val junit = "$group:ui-test-junit4:$junitVersion"
        const val manifest = "$group:ui-test-manifest"
        const val preview = "$group:ui-tooling-preview"
    }

    object Material {
        private const val group = "androidx.compose.material"

        const val material = "$group:material"
    }
}

object Coil {
    private const val group = "io.coil-kt"
    private const val version = "2.2.2"

    const val compose = "$group:coil-compose:$version"
    const val svg = "$group:coil-svg:$version"
}
