package com.x930073498.plugin

import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.kotlin.dsl.*
import java.io.File
import java.util.*


enum class DependencyCommand(val value: String) {
    KAPT("kapt"), API("api"), IMPLEMENTATION("implementation")
}

enum class Ext(val value: String) {
    AAR("aar"), JAR("jar")
}

sealed class DependencyLib {
    protected val excludeList = arrayListOf<DependencyExclude>()


    abstract fun dependency(command: DependencyCommand, scope: DependencyHandlerScope, project: Project)

    companion object {
        @JvmStatic
        fun aar(name: String): AAR {
            return AAR(name)
        }

        @JvmStatic
        fun remote(path: String): Remote {
            return Remote(path)
        }

        @JvmStatic
        fun project(name: String): ProjectLib {
            return ProjectLib(name)
        }

        @JvmStatic
        fun fileTree(path: String, vararg ext: Ext): FileTreeLib {
            return FileTreeLib(path, ext.map { "*.${it.value}" })
        }
    }

    class ProjectLib internal constructor(private val name: String) : DependencyLib() {
        override fun dependency(command: DependencyCommand, scope: DependencyHandlerScope, project: Project) {
            scope.apply {
                add(command.value, project(name)) {
                    excludeList.forEach {
                        exclude(it.group, it.module)
                    }
                }
            }
        }

    }

    class FileTreeLib(private val path: String, private val exts: List<String>) : DependencyLib() {
        override fun dependency(command: DependencyCommand, scope: DependencyHandlerScope, project: Project) {
            scope.apply {
                add(command.value, project.fileTree(mapOf("dir" to path, "include" to exts)))
            }
        }

    }

    class Remote internal constructor(private val path: String) : DependencyLib() {
        fun ofExclude(exclude: DependencyExclude): Remote {
            excludeList.add(exclude)
            return this
        }

        fun ofExclude(group: String, module: String? = null): Remote {
            return ofExclude(DependencyExclude(group, module))
        }

        override fun dependency(command: DependencyCommand, scope: DependencyHandlerScope, project: Project) {
            scope.apply {
                add(command.value, path) {
                    excludeList.forEach {
                        exclude(it.group, it.module)
                    }
                }
            }
        }

    }


    class AAR internal constructor(private val name: String) : DependencyLib() {

        fun ofExclude(exclude: DependencyExclude): AAR {
            excludeList.add(exclude)
            return this
        }

        fun ofExclude(group: String, module: String? = null): AAR {
            return ofExclude(DependencyExclude(group, module))
        }

        override fun dependency(command: DependencyCommand, scope: DependencyHandlerScope, project: Project) {
            scope.apply {
                add(command.value, create(group = "", name = name, ext = "aar")) {
                    excludeList.forEach {
                        exclude(it.group, it.module)
                    }
                }
            }
        }


    }
}

class DependencyExclude(val group: String, val module: String?)

class DependencyData private constructor(private val command: DependencyCommand, private val lib: DependencyLib) {

    internal fun applyTo(scope: DependencyHandlerScope, project: Project) {
        lib.dependency(command, scope, project)
    }

    companion object {
        @JvmStatic
        fun kapt(lib: DependencyLib): DependencyData {
            return DependencyData(DependencyCommand.KAPT, lib)
        }

        @JvmStatic
        fun implementation(lib: DependencyLib): DependencyData {
            return DependencyData(DependencyCommand.IMPLEMENTATION, lib)
        }

        @JvmStatic
        fun api(lib: DependencyLib): DependencyData {
            return DependencyData(DependencyCommand.API, lib)
        }
    }
}


 class ScriptProjectConfiguration(private val project: Project) {

    private val libs = arrayListOf<DependencyData>()

    private val jniLibsDirs = arrayListOf<String>()
    private val javaSourceDirs = arrayListOf<String>()
    private val resourceDirs = arrayListOf<String>()

    private var dependencyAction: (DependencyHandlerScope) -> Unit = {}

    private var repositoryAction: (RepositoryHandler) -> Unit = {}

    init {
        configurationMap[project] = this
    }

    fun dependency(action: (DependencyHandlerScope) -> Unit): ScriptProjectConfiguration {
        this.dependencyAction = action
        return this
    }

    fun addDependency(lib: DependencyData): ScriptProjectConfiguration {
        libs.add(lib)
        return this
    }

     fun implementation(lib: DependencyLib):ScriptProjectConfiguration{
         addDependency(DependencyData.implementation(lib))
         return this
     }

     fun fileTree(path: String,vararg ext:String):DependencyLib{
       return  DependencyLib.fileTree(path, *ext.map { Ext.valueOf(it.toUpperCase(Locale.getDefault())) }.toTypedArray())
     }



    fun java(vararg dir: String): ScriptProjectConfiguration {
        dir.forEach {
            javaSourceDirs.add(it)
        }
        return this
    }

    fun jni(vararg dir: String): ScriptProjectConfiguration {
        dir.forEach {
            jniLibsDirs.add(it)
        }
        return this
    }

    fun resource(vararg dir: String): ScriptProjectConfiguration {
        dir.forEach {
            resourceDirs.add(it)
        }
        return this
    }

    fun apply() {
        project.plugins.findPlugin(AppPlugin::class)?.build()
        project.plugins.firstOrNull {
            it is AppPlugin || it is LibraryPlugin
        }?.build() ?: project.plugins.whenPluginAdded {
            build()
        }
    }

    private fun Plugin<*>.build() {
        if (this is AppPlugin || this is LibraryPlugin) {
            project.dependencies {
                dependencyAction(this)
                libs.forEach {
                    it.applyTo(this, project)
                }
            }
            project.repositories {
                repositoryAction(this)
            }

            project.android.apply {
                sourceSets {
                    getByName("main").apply {
                        java.apply {
                            setSrcDirs(srcDirs + javaSourceDirs.map { File(it) })
                        }
                        jniLibs.apply {
                            setSrcDirs(srcDirs + jniLibsDirs.map { File(it) })
                        }
                        res.apply {
                            setSrcDirs(srcDirs + resourceDirs.map { File(it) })
                        }
                    }
                }
            }
        }
    }

    fun repository(action: (RepositoryHandler) -> Unit): ScriptProjectConfiguration {
        repositoryAction = action
        return this
    }

    companion object {
        private val configurationMap = mutableMapOf<Project, ScriptProjectConfiguration>()

        @JvmStatic
        fun script(project: Project): ScriptProjectConfiguration {
            return configurationMap[project] ?: ScriptProjectConfiguration(project)
        }
    }

}