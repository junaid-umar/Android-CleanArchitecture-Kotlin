plugins {
    id("java-library")
    id("kotlin")
    kotlin("kapt")

}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11

}

dependencies {
    implementation(Libs.COROUTINES)
    implementation(Libs.HILT_CORE)
    kapt(Libs.HILT_COMPILER)

    testImplementation(Libs.JUNIT4)
    testImplementation(Libs.JUPITER_ENGINE)
    testImplementation(Libs.MOCKK)
    testImplementation(Libs.COROUTINES_TEST)


}