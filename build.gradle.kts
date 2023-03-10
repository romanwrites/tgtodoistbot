import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.2" apply false

	kotlin("multiplatform") version "1.8.10"
	kotlin("plugin.serialization") version "1.8.10"

	kotlin("plugin.spring") version "1.8.10" apply false
}

group = "com.roman.writes"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
	maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers") }

}

kotlin {
	jvm("spring") {
		apply(plugin = "org.springframework.boot")
		apply(plugin = "org.jetbrains.kotlin.plugin.spring")
		apply(plugin = "org.jetbrains.kotlin.plugin.serialization")

		tasks.withType<KotlinCompile> {
			kotlinOptions {
				freeCompilerArgs = listOf("-Xjsr305=strict")
				jvmTarget = "17"
			}
		}
		tasks.withType<Test> {
			useJUnitPlatform()
		}
	}

	sourceSets {
		val springMain by getting {
			dependencies {
				implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
				implementation("org.springframework.boot:spring-boot-starter-rsocket")
				implementation("org.springframework.boot:spring-boot-starter-webflux")

				implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
				implementation("org.jetbrains.kotlin:kotlin-reflect")
				implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
				implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")


				implementation("org.springframework.boot:spring-boot-starter-web")
				implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
				compileOnly("org.projectlombok:lombok")

				implementation("org.telegram:telegrambots:6.5.0")

				implementation("org.slf4j:slf4j-api:2.0.6")
				implementation("org.apache.logging.log4j:log4j-core:2.20.0")

				implementation(npm("@doist/todoist-api-typescript", "1.1.0"))
			}
		}
		val springTest by getting {
			dependencies {
				implementation("io.projectreactor:reactor-test")

				implementation("org.springframework.boot:spring-boot-starter-test") {
					exclude(module = "mockito-core")
				}
				implementation("org.junit.jupiter:junit-jupiter-api")
				runtimeOnly("org.junit.jupiter:junit-jupiter-engine")
				implementation("com.ninja-squad:springmockk:4.0.0")
			}
		}
	}
}
