pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencyResolutionManagement {
    // CAMBIO AQUÍ: Cambiamos de FAIL_ON_PROJECT_REPOS a PREFER_PROJECT
    // Esto permite que el plugin de Kotlin Wasm añada el repositorio de Binaryen automáticamente.
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "Tarot"
include(":composeApp")
