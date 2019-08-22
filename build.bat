@echo off

set JAVA_HOME=C:\Program Files\Java\jdk-11.0.3
set BADASS_JLINK_JPACKAGE_HOME=C:\Program Files\Java\jdk-14

gradlew clean jpackage
