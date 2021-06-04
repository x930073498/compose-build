package com.x930073498.plugin

import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project

class ModuleSourcePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.extensions.create("moduleSource", ModuleSourceExtension::class.java, target)
    }
}

open class ModuleSourceExtension(private val project: Project) {

    fun createModule(action: Action<ScriptProjectConfiguration>) {
        action.execute(ScriptProjectConfiguration.script(project))
    }

}