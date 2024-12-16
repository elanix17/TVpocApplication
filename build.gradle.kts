// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
}

// This classpath is required for Android Gradle plugin in your project-level build file.
buildscript {
    val nav_version = "2.7.7"
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.5.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.20-Beta2")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}
