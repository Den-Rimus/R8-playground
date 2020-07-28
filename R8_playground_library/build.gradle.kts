
plugins {
   id("com.android.library")
   id("kotlin-android")
   id("kotlin-android-extensions")
   id("maven")
}

project.group = "com.example"
project.extra.set("publishArtifactId", "r8_lib")
project.version = rootProject.extra["lib_version"] as String

android {
   compileSdkVersion(29)

   defaultConfig {
      minSdkVersion(21)
      targetSdkVersion(29)
      versionCode = 1
      versionName = "1.0"
      consumerProguardFiles("consumer-rules.pro")
   }

   buildTypes {
      named("release") {
         isMinifyEnabled = true
         proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      }
   }
}

dependencies {
   implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
   implementation("androidx.core:core-ktx:1.3.1")
   implementation("androidx.appcompat:appcompat:1.1.0")
}

tasks.register("uploadLocalArchives", Upload::class) {
   configuration = project.configurations.getByName("archives")

   group = "upload"

   repositories {
      withConvention(MavenRepositoryHandlerConvention::class) {
         mavenDeployer {
            withGroovyBuilder {
               "repository"("url" to "file://${System.getProperty("user.home")}/.m2/repository/")
            }

            pom.groupId = project.group as String
            pom.artifactId = project.extra["publishArtifactId"] as String
            pom.version = project.version as String
         }
      }
   }
}
