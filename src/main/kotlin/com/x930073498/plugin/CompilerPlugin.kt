package com.x930073498.plugin


import com.android.build.gradle.AppPlugin
import com.x930073498.plugin.register.AutoRegisterConfig
import com.x930073498.plugin.register.RegisterTransform
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile



class CompilerPlugin : Plugin<Project> {
    val EXT_NAME = "autoregister"

    private fun init(project: Project, transform: RegisterTransform) {
        val config = project.extensions.findByName(EXT_NAME) as? AutoRegisterConfig
                ?: AutoRegisterConfig()
        config.registerInfo.add(mutableMapOf(
                "scanSuperClasses" to "com.zx.common.auto.AutoTask",
                "codeInsertToClassName" to "com.zx.common.auto.AutoTaskRegister",
                "codeInsertToMethodName" to "load",
                "registerMethodName" to "register",
                "scanInterface" to "com.zx.common.auto.IAutoTask"
        ))
        config.project = project
        config.convertConfig()
        transform.config = config
    }

    override fun apply(project: Project) {
        println("进入Compiler Plugin----")

        project.subprojects {

            tasks.withType<KotlinCompile> {
                kotlinOptions {
                    jvmTarget = JavaVersion.VERSION_1_8.toString()
                }
            }
            plugins.whenPluginAdded {
                if (this is AppPlugin) {
                    extensions.create(EXT_NAME, AutoRegisterConfig::class.java)
                    val transform = RegisterTransform(this@subprojects)
                    afterEvaluate {
                        init(this@subprojects, transform)
                    }
                    android.registerTransform(transform)
                }
            }



//            plugins.whenPluginAdded {
////                if (this is KotlinAndroidPluginWrapper) {
////                    extensions.findByType<AndroidExtensionsExtension>()?.apply {
////                        isExperimental = true
////                    }
////                }
//                if (this is AppPlugin
////                        || this is LibraryPlugin
//                ) {
//                    dependencies {
//                        add("implementation", Libraries.kotlin)
//                    }
//
//                    android.apply {
//                        compileSdkVersion(Versions.compileSdk)
//                        buildToolsVersion(Versions.buildTools)
//
//
//                        lintOptions {
//                            isAbortOnError = true
//                            textReport = true
//                            textOutput("stdout")
//                        }
//
//                        compileOptions {
//                            sourceCompatibility = JavaVersion.VERSION_1_8
//                            targetCompatibility = JavaVersion.VERSION_1_8
//                        }
//
//                        sourceSets {
//                            getByName("main").java.apply {
//                                setSrcDirs(srcDirs + file("src/main/kotlin"))
//                            }
//                            getByName("test").java.apply {
//                                setSrcDirs(srcDirs + file("src/test/kotlin"))
//                            }
//                        }
//                    }
//                }
//            }
        }
    }
}