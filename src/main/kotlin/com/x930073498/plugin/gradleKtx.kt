package com.x930073498.plugin

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project

val Project.android: BaseExtension
    get() = project.extensions.getByName("android") as BaseExtension
