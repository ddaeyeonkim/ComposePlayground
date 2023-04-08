plugins {
    `kotlin-dsl`
}

group = "com.composeplayground.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "composeplayground.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "composeplayground.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "composeplayground.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
    }
}
