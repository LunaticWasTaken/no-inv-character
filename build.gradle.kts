plugins {
  id("net.fabricmc.fabric-loom")
}

val modVersion: String = "1.2.0+build.1"
val minecraftVersion: String = "26.1.2"
val fabricVersion: String = "0.19.1"

dependencies {
  minecraft("com.mojang:minecraft:$minecraftVersion")

  implementation("net.fabricmc:fabric-loader:$fabricVersion")
}

tasks.processResources {
  filesMatching("fabric.mod.json") {
    expand(
      mapOf(
        "version" to modVersion
      )
    )
  }
}

tasks.withType<JavaCompile>().configureEach {
  options.release = 25
}

java {
  withSourcesJar()

  sourceCompatibility = JavaVersion.VERSION_25
  targetCompatibility = JavaVersion.VERSION_25
}
