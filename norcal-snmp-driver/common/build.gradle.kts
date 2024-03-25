plugins {
    `java-library`
}

java {
    toolchain {
        languageVersion.set(org.gradle.jvm.toolchain.JavaLanguageVersion.of(11))
    }
}

dependencies {
    // add common scoped dependencies here
    compileOnly("com.inductiveautomation.ignitionsdk:ignition-common:${rootProject.extra["sdk_version"]}")
    // https://mvnrepository.com/artifact/org.snmp4j/snmp4j
	modlImplementation("org.snmp4j:snmp4j:3.4.1")
}
