plugins {
    alias(libs.plugins.android.applications)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.plugins)
    alias(libs.plugins.parcelize.plugins)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.devtools.ksp)
}

android {
    namespace = "com.baharudin.challange"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.baharudin.challange"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding =  true
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/AL2.0")
            excludes.add("/META-INF/LGPL2.1")
            excludes.add("META-INF/gradle/incremental.annotation.processors")
        }
    }
}

dependencies {

    implementation(project(":search:search_presentation"))
    implementation(project(":news:news_presentation"))
    implementation(project(":news:news_domain"))
    implementation(project(":news:news_data"))
    implementation(project(":common:common_utils"))

    implementation(libs.androidx.core.core.ktx)
    implementation(libs.androidx.appcompat.appcompat)
    implementation(libs.android.material.material)
    implementation(libs.constraintlayout.constraintlayout)
    implementation(libs.navigation.ui.ktx)
    implementation(libs.navigation.fragment.ktx)
    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.bundles.hilt)
    implementation(libs.bundles.retrofit.bundle)
    implementation(libs.bundles.coroutine.bundle)

    implementation(libs.lifecycle.viewmodel)
    implementation(libs.glide)
    implementation(libs.activity.ktx)
    implementation(libs.lifecycle.runtime)
    implementation(libs.lottie)

    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
}

