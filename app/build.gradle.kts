plugins {
    alias(libs.plugins.android.application)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.jessica_tia"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.jessica_tia"
        minSdk = 29
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    implementation("androidx.gridlayout:gridlayout:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.coordinatorlayout:coordinatorlayout:1.2.0")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.4")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.4")
    implementation("androidx.room:room-runtime:2.8.4")
    implementation("androidx.room:room-ktx:2.8.4")
    ksp("androidx.room:room-compiler:2.8.4")
    implementation("androidx.viewpager2:viewpager2:1.1.0")
    implementation("com.tbuonomo:dotsindicator:5.1.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}