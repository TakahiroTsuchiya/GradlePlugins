package com.sample.gradle.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

/***************************************************************************************************************
 *
 * Gradle Plugins.<br/>
 * This plugin is open apk file path by "Finder" or "Explorer".
 *
 ***************************************************************************************************************
 */
class  OpenOutputsApkFilePathPlugin implements Plugin<Project> {

    void apply(Project target) {

        println("--- OpenOutputsApkFilePathPlugin START -------------------------------------------------------------")

        target.afterEvaluate { project ->
            project.android.applicationVariants.all { v ->
                target.task(
                        "assembleAndLocate${v.name.capitalize()}"
                        , dependsOn: v.assemble)
                        .doLast {
                    ["open", "-R", v.outputs.first().outputFile].execute()
                }
            }
        }
        println("--- OpenOutputsApkFilePathPlugin END -------------------------------------------------------------")

    }
}
