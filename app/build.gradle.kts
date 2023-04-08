@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("composeplayground.android.application.compose")
    alias(libs.plugins.ktlint)
}

android {
    namespace = "com.composeplayground"

    defaultConfig {
        applicationId = "com.composeplayground"
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

ktlint {
    android.set(true)
    outputColorName.set("RED")
}

dependencies {
    implementation(projects.feature.facebookMessengerLike)

    implementation(libs.bundles.android)
    debugImplementation(libs.bundles.compose.debug)

    testImplementation(libs.junit4)
    androidTestImplementation(libs.bundles.test.android)
}
