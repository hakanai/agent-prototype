repositories {
    jcenter()
}

extra["displayName"] = "Hakanai Agent"
group = "org.trypticon.vrcagent"
version = "0.0.1"

plugins {
    application
    id("org.openjfx.javafxplugin") version "0.0.7"
    id("org.beryx.jlink") version "2.12.0"
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

javafx {
    version = "12"
    modules = listOf("javafx.controls")
}

application {
    applicationName = "Hakanai Agent"
    mainClassName = "org.trypticon.vrcagent/org.trypticon.vrcagent.Main"

    applicationDefaultJvmArgs = listOf(
            "-Dbranding.name=${extra["displayName"]}",
            "-Dbranding.version=${version}")

    // Failed attempt to fix Oculus not being able to pull out the window
    //applicationDefaultJvmArgs.add("-Dprism.order=sw")
}

jlink {
    options.addAll(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))
    mainClass.set("org.trypticon.vrcagent.Main")

    launcher {
        name = project.name
        jvmArgs.addAll(listOf(
                "-Dbranding.name=${extra["displayName"]}",
                "-Dbranding.version=${version}"))
    }

    jpackage {
        // TODO: Pull jpackage from a URL and unpack it instead.
        jpackageHome = "C:/Program Files/Java/jdk-14"
        imageName = application.applicationName
        // TODO: Get installer working
        skipInstaller = true // for now
//        installerOutputDir = file("${buildDir}/installer")
//        installerName = application.applicationName
//        installerType = "msi"
//        installerOptions = listOf("--win-console", "--win-menu", "--win-shortcut")
    }
}
