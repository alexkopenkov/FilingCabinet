object Versions {

    const val APPCOMPAT = "1.2.0"
    const val COIL = "1.1.1"
    const val CONSTRAINT = "2.0.4"
    const val CORE_KTX = "1.3.2"
    const val COROUTINES = "1.4.2"
    const val GRADLE = "4.2.0-beta03"
    const val KOIN = "2.1.6"
    const val KOTLIN = "1.4.21"
    const val LIFECYCLE = "2.2.0"
    const val MATERIAL = "1.2.1"
    const val NAVIGATION = "2.3.2"
    const val OKHTTP = "4.9.0"
    const val RECYCLER_VIEW = "1.1.0"
    const val REFRESH_VERSIONS = "0.7.0"
    const val RETROFIT = "2.9.0"
    const val ROOM = "2.3.0-alpha01"
    const val SWIPE_REFRESH = "1.1.0"
    const val VIEW_BINDING = "1.3.0"

}

object Dependencies {

    // AndroidX
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val CONSTRAINT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT}"
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW}"
    const val SWIPE_REFRESH = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_REFRESH}"

    // Coil
    const val COIL = "io.coil-kt:coil:${Versions.COIL}"

    // Koin
    const val KOIN_VIEWMODEL = "org.koin:koin-androidx-viewmodel:${Versions.KOIN}"

    // Kotlin
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"

    // Lifecycle
    const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE}"
    const val LIFECYCLE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
    const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"

    // Material Design
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"

    // Navigation
    const val NAVIGATION_FRAGMENT =
        "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"

    // Retrofit & OkHttp
    const val OKHTTP_LOGGING_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"

    // Room
    const val ROOM = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_KAPT = "androidx.room:room-compiler:${Versions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM}"
    const val ROOM_TEST = "androidx.room:room-testing:${Versions.ROOM}"

    // View Binding
    const val VIEW_BINDING =
        "com.kirich1409.viewbindingpropertydelegate:viewbindingpropertydelegate:${Versions.VIEW_BINDING}"

}

object ClassPath {

    // Gradle
    const val GRADLE = "com.android.tools.build:gradle:${Versions.GRADLE}"

    // Kotlin
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"

    // Navigation Safe Args
    const val NAVIGATION_SAFE_ARGS =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION}"

}