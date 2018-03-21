package com.sample.gradle.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

/***************************************************************************************************************
 *
 * Gradle Plugins.<br/>
 * This plugin is show apk file path.
 *
 ***************************************************************************************************************
 */
class  ShowOutputsApkFilePathPlugin implements Plugin<Project> {

    void apply(Project target) {

        println("--- ShowOutputsApkFilePathPlugin START -------------------------------------------------------------")

        target.afterEvaluate { project ->
            project.android.applicationVariants.all { v ->
                v.assemble.doLast {
                    println("${v.outputs.first().outputFile}")
                }
            }
        }
        println("--- ShowOutputsApkFilePathPlugin END -------------------------------------------------------------")

    }
}
