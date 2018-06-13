package tech.aregalio.website.app.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.lang.Nullable
import org.springframework.web.bind.annotation.*
import tech.aregalio.website.app.domain.AboutInfo
import tech.aregalio.website.app.domain.ContactInfo
import tech.aregalio.website.app.domain.HomeInfo



@RestController
class HomeController @Autowired constructor(
    private val env: Environment
) {

    /* Much simpler, right? */
    fun Environment.get(key: String) : String = this.getProperty(key, "unknown")

    /**
     * Basic home controller
     */
    @GetMapping("/")
    fun home() : HomeInfo {
        return HomeInfo(
                greeting = "Hello world! Welcome to my creepy site \"${env.get("app.name")}\"",
                whoami = AboutInfo(
                        firstName = "Arnau",
                        lastName = "Aregall Arcarons",
                        nickname = "${env.get("app.contact.nickname")}",
                        job = "Software Architect",
                        company = "everis - an NTT Data company",
                        skills = listOf(
                                "Java",
                                "Java EE",
                                "JavaScript",
                                "node.js",
                                "Kotlin",
                                "Docker",
                                "Kubernetes",
                                "Cloud Architectures",
                                "Continuous Integration",
                                "Continuous Delivery",
                                "Micro-services",
                                "Spring Framework",
                                "Spring Cloud",
                                "Spring Boot",
                                "Software Architecture Design",
                                "IT Consultancy",
                                "Team leading",
                                "Back-end development",
                                "Front-end development",
                                "Angular"
                        ).sorted()
                ),
                contact = ContactInfo(
                        email = "${env.get("app.contact.email")}",
                        location = "Torelló, Barcelona"
                ),
                builtWith = listOf("Java 8", "Kotlin ${env.get("app.kotlinVersion")}", "Spring Boot ${env.get("app.springBootVersion")}"),
                sourceCode = env.get("app.repository"),
                version = env.get("app.version")
        )
    }

}