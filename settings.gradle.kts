pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencyResolutionManagement {
    // Cambiamos a PREFER_PROJECT para que el plugin de Kotlin pueda añadir sus repositorios de herramientas
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        
        // Añadimos el repositorio de Binaryen explícitamente por si acaso
        ivy {
            url = uri("https://github.com/WebAssembly/binaryen/releases/download")
            patternLayout {
                artifact("[revision]/[artifact]-[revision]-[classifier].[ext]")
            }
            metadataSources { artifact() }
        }
    }
}

rootProject.name = "Tarot"
include(":composeApp")
