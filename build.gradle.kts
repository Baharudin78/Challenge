import com.android.build.gradle.internal.tasks.getProjectNativeLibs

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.applications) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.hilt.plugins) apply false
    alias(libs.plugins.parcelize.plugins) apply false
    alias(libs.plugins.kotlin.kapt) apply false
 //   alias(libs.plugins.devtools.ksp) apply false
}