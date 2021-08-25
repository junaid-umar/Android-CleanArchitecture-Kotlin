plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlinx-serialization")
    kotlin("kapt")

}

android {
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK



        testInstrumentationRunner = "com.coinranking.data.AppTestRunner"
        consumerProguardFile("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            buildConfigField("String", "BASE_URL", "\"https://api.coinranking.com/\"")


        }
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://api.coinranking.com/\"")

        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    packagingOptions {
        resources.pickFirsts.add("META-INF/*")
        resources.excludes.add("**/attach_hotspot_windows.dll")
        resources.excludes.add("META-INF/LICENSE")
        resources.excludes.add("META-INF/licenses/ASM")
        resources.excludes.add("META-INF/LICENSE.txt")
        resources.excludes.add("META-INF/license.txt")
        resources.excludes.add("META-INF/NOTICE")
        resources.excludes.add("META-INF/NOTICE.txt")
        resources.excludes.add("META-INF/notice.txt")
        resources.excludes.add("META-INF/notice.txt")
        resources.excludes.add("META-INF/ASL2.0")
        resources.excludes.add("META-INF/*.kotlin_module")
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(Libs.KOTLIN_SDTLIB)

    implementation(Libs.KOTLINX_SERIALIZATION_JSON)
    implementation(Libs.COROUTINES)

    api(Libs.ROOM)
    implementation(Libs.ROOM_KTX)
    kapt(Libs.ROOM_KAPT)

    implementation(Libs.HILT)
    kapt(Libs.HILT_COMPILER)

    api(Libs.RETROFIT)
    api(Libs.RETROFIT_GSON)
    api(Libs.OKHTTP)
    api(Libs.OKHTPP_INTERCEPTOR)
    implementation(Libs.KOTLINX_SERIALIZATION_RETROFIT)


    androidTestImplementation(Libs.JUNIT4)
    androidTestImplementation(Libs.JUPITER_ENGINE)

    androidTestImplementation(Libs.TEST_CORE)
    androidTestImplementation(Libs.CORE_TESTING)
    androidTestImplementation(Libs.TEST_RUNNER)

    androidTestImplementation(Libs.MOCKK)
    androidTestImplementation(Libs.COROUTINES_TEST)
    androidTestImplementation(Libs.HILT_TESTING)
    androidTestImplementation(Libs.MOCK_WEB_SERVER)
    androidTestImplementation(Libs.TURBINE)
    kaptAndroidTest(Libs.HILT_COMPILER)
    kaptAndroidTest(Libs.TRUTH)
    androidTestImplementation("androidx.test.ext:junit:1.1.2")

}