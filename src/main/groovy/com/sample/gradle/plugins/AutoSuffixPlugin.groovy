package com.sample.gradle.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

/***************************************************************************************************************
 *
 * Gradle Plugins.<br/>
 * This plugin is auto add suffix name and package name.<br/>
 * Target BuildTypes "debug", "staging" and "release"
 *
 ***************************************************************************************************************
 */
class  AutoSuffixPlugin implements Plugin<Project> {

    void apply(Project target) {

        println("--- AutoSuffixPlugin START -------------------------------------------------------------")

        def extension = target.extensions.create("AutoSuffixPlugin", AutoSuffixPluginExtension)

        target.afterEvaluate { project ->
            project.android {
                    buildTypes {
                        debug {
                            applicationIdSuffix '.debug'
                            if (extension.isUpdateVersionName) {
                                versionNameSuffix '-DEBUG'
                            }
                        }
                        staging {
                            applicationIdSuffix '.staging'
                            if (extension.isUpdateVersionName) {
                                versionNameSuffix '-STAGING'
                            }
                        }
                        release {
                        }
                    }
                }
        }

        println("--- AutoSuffixPlugin END -------------------------------------------------------------")
    }
}

class AutoSuffixPluginExtension {

    boolean isUpdateVersionName = true

}
