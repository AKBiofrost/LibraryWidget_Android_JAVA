plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.portafolio.librarywidget_android_java"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.portafolio.librarywidget_android_java"
        minSdk = 30
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(project(":app:BottomSheetDialog"))
    implementation(project(":app:BottomSheetDialogFragment_imagen"))
    implementation(project(":app:AlertDialogView"))
    implementation(project(":app:BottomSheetDialogFragment_ListCardView"))
    implementation(project(":app:ExpandableListView_itemCardView"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}