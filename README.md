Sample project for mastering R8 obfuscation rules

also a sample for https://stackoverflow.com/questions/63019928/issue-with-kotlin-generics-type-argument-in-interface-after-r8-obfuscation question

### Usage

* (if necessary) update version value in root `build.gradle` file: `lib_version = "0.0.<INCREMENT_HERE>"`. Sync project
* in project root run `./gradlew deployR8Test` command
* Sync project
* try to use library's code in `MainActivity` class
* adjust obfuscation rules in project root's `proguard-rules.pro` file