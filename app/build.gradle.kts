plugins {
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.KOTLIN_ANDROID)
    kotlin(Plugins.KOTLIN_KAPT)
    id(Plugins.KOTLIN_PARCELIZE)
    id(Plugins.NAVIGATION_SAFE_ARGS)
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        applicationId = AndroidConfig.ID
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME

        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName(BuildTypes.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            resValue("string", "app_name", BuildTypeRelease.appName)
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName(BuildTypes.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            applicationIdSuffix = BuildTypeDebug.applicationIdSuffix
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
            resValue("string", "app_name", BuildTypeDebug.appName)
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    sourceSets {
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin")
        getByName("debug").java.srcDirs("src/debug/kotlin")
        getByName("release").java.srcDirs("src/release/kotlin")
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
    }
}

dependencies {

    // AndroidX
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.CONSTRAINT)
    implementation(Dependencies.CORE_KTX)

    // Coil
    implementation(Dependencies.COIL)

    // Koin
    implementation(Dependencies.KOIN_VIEWMODEL)

    // Kotlin
    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.COROUTINES)

    // Material Design
    implementation(Dependencies.MATERIAL)

    // Navigation
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI_KTX)

    // Retrofit
    implementation(Dependencies.OKHTTP_LOGGING_INTERCEPTOR)
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_CONVERTER_GSON)

    // Room
    implementation(Dependencies.ROOM)
    kapt(Dependencies.ROOM_KAPT)
    implementation(Dependencies.ROOM_KTX)
    testImplementation(Dependencies.ROOM_TEST)

    // View Binding Delegate
    implementation(Dependencies.VIEW_BINDING)

}