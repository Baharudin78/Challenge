plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("kotlin-android")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
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
}

dependencies {

    implementation(libs.androidx.core.core.ktx)
    implementation(libs.androidx.appcompat.appcompat)
    implementation(libs.android.material.material)
    implementation(libs.constraintlayout.constraintlayout)
    implementation(libs.navigation.ui.ktx)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.junit.junit)
    implementation(libs.androidx.test.ext.junit)
    implementation(libs.espresso.core)
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    //Hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    //Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")


    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")

    //Firebase
    implementation(platform("com.google.firebase:firebase-bom:31.2.3"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-messaging:23.1.2")

    // Activity KTX for viewModels()
    implementation("androidx.activity:activity-ktx:1.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

    //Datastore
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.15.1")

    // Chucker
    debugImplementation("com.github.chuckerteam.chucker:library:3.5.2")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:3.5.2")

}

kapt {
    correctErrorTypes = true
}