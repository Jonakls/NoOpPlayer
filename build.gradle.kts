plugins {
    `java-library`
    alias(libs.plugins.minecrell)
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://jitpack.io")
}

dependencies {
    compileOnly(libs.spigot)
    compileOnly(libs.vault)
}

tasks {

    jar {
        archiveBaseName.set("${rootProject.name}-v${project.version}")
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(8))
        }
    }
}

bukkit {
    main = "${rootProject.group}.noopplayer.NoopPlayer"
    name = rootProject.name
    version = "${rootProject.version}"
    author = "Jonakls"
    description = "A plugin that does nothing"
    website = "www.github.com/jonakls/no-op-player"
    depend = listOf("Vault")
    loadBefore = listOf("Vault")

    commands {
        register("noopplayer") {
            description = "Main command of plugin"
            aliases = listOf("npp")
            permission = "noopplayer.command"
        }
    }
}

tasks.test {
    useJUnitPlatform()
}