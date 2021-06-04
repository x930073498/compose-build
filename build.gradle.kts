
repositories {
    google()
    maven(url = "https://plugins.gradle.org/m2/")
    mavenCentral()
    jcenter()
}
plugins {
    java
    `kotlin-dsl`
    kotlin("jvm") version "1.5.0"
}

dependencies {
    implementation(fileTree(mapOf(
            "dir" to "libs", "include" to listOf("*.jar", "*.aar")
    )))
    implementation("com.android.tools.build:gradle:4.2.1")
//    implementation("com.android.tools.build:gradle:3.6.3")
    implementation(gradleApi())
    implementation(localGroovy())
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.0")
    implementation(kotlin("stdlib-jdk8"))
}
val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}



gradlePlugin{
    plugins {
        create("compile"){
            id="com.x930073498.build.compile"
            implementationClass="com.x930073498.plugin.CompilerPlugin"
        }
        create("moduleSource"){
            id="com.x930073498.build.module-source"
            implementationClass="com.x930073498.plugin.ModuleSourcePlugin"
        }
        create("classLoader"){
            id="com.x930073498.build.class-loader"
            implementationClass="com.x930073498.plugin.ClassLoaderPlugin"
        }
    }
}


//gradlePlugin {
//    plugins {
//        version {
//            // 在 app 模块需要通过 id 引用这个插件
//            id = 'com.x930073498.build.compose'
//            // 实现这个插件的类的路径
//            implementationClass = 'com.x930073498.plugin.CompilerPlugin'
//        }
//    }
//}