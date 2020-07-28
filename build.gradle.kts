
buildscript {

   extra.apply {
      set("kotlin_version", "1.3.72")
      set("lib_version", "0.0.5")
   }

   repositories {
      maven(url = "https://storage.googleapis.com/r8-releases/raw")
      google()
      jcenter()
   }

   dependencies {
      classpath("com.android.tools:r8:2.1.42")
      classpath("com.android.tools.build:gradle:4.0.1")
      classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
   }
}

allprojects {
   repositories {
      google()
      jcenter()
   }
}

tasks.register(name = "clean", type = Delete::class) {
   delete(rootProject.buildDir)
}

apply(from = "./deployer.gradle.kts")
