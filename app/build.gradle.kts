plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.switchcheck"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.switchcheck"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.core:core-ktx:1.2.0")
    implementation("com.google.android.material:material:1.1.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.2.1")
    implementation("androidx.navigation:navigation-ui-ktx:2.2.1")

    implementation("androidx.navigation:navigation-fragment-ktx:2.2.1")
    implementation("androidx.navigation:navigation-ui-ktx:2.2.1")

    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    implementation("com.github.bumptech.glide:glide:4.11.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.11.0")
    kapt("com.github.bumptech.glide:compiler:4.11.0")
}