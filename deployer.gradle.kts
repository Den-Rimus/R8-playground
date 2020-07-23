
val tasksGroup = "R8 playground publishing"

val LOG_TAG = "DEPLOYER"

val name = "R8Test"
val modules = project(":R8_playground_library")

val cleanTaskName = "clean$name"
val assembleTaskName = "assemble$name"
val publishTaskName = "publish$name"
val deployTaskName = "deploy$name"

val cleanTask = task(cleanTaskName) {
   this@task.group = tasksGroup

   modules.afterEvaluate {
      val taskToDependOn = this@afterEvaluate.tasks.findByName("clean")
      this@task.dependsOn(taskToDependOn)
      log("$cleanTaskName will depend on $taskToDependOn")
   }

   this@task.doLast {
      log("Cleaning finished")
   }
}

task(assembleTaskName) {
   this@task.group = tasksGroup

   modules.afterEvaluate {
      val moduleCleanTask = this@afterEvaluate.tasks.findByName("clean")

      this@afterEvaluate.tasks.whenTaskAdded {
         if (this@whenTaskAdded.name == "bundleReleaseAar") {
            this@whenTaskAdded.mustRunAfter(moduleCleanTask)
            this@task.dependsOn(this@whenTaskAdded)
            log("$assembleTaskName will depend on ${this@whenTaskAdded}")
         }
      }
   }

   this@task.dependsOn(cleanTask)

   this@task.doLast {
      log("Bundling AAR finished")
   }
}

task(publishTaskName) {
   this@task.group = tasksGroup

   modules.afterEvaluate {
      val uploadTaskName = "uploadLocalArchives"

      val modulePublishTask = this@afterEvaluate.tasks.findByName(uploadTaskName)
      if (modulePublishTask == null) {
         log("Failed to found \'$uploadTaskName\' task for module ${this@afterEvaluate.name}")
      } else {
         this@task.dependsOn(modulePublishTask)
      }
   }

   this@task.mustRunAfter(rootProject.tasks.findByName(assembleTaskName))

   this@task.doLast {
      log("Uploading finished")
   }
}

tasks.register(deployTaskName) {
   group = tasksGroup

   dependsOn(tasks.getByName(cleanTaskName))
   dependsOn(tasks.getByName(assembleTaskName))
   dependsOn(tasks.getByName(publishTaskName))
}

fun log(message: String) {
   println("$LOG_TAG :: $message")
}
