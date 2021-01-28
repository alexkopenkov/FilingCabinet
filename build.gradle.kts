// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(ClassPath.GRADLE)
        classpath(ClassPath.KOTLIN)
        classpath(ClassPath.NAVIGATION_SAFE_ARGS)
    }
}

plugins {
    id(Plugins.REFRESH_VERSIONS) version Versions.REFRESH_VERSIONS
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://jitpack.io")
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}