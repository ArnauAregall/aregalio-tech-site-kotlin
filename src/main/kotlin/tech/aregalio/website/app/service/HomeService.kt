package tech.aregalio.website.app.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service
import tech.aregalio.website.app.domain.AboutInfo
import tech.aregalio.website.app.domain.ContactInfo
import tech.aregalio.website.app.domain.HomeInfo

@Service
class HomeService @Autowired constructor(
        private val env: Environment) {

    /* Much simpler, right? */
    fun Environment.get(key: String) : String = this.getProperty(key, "unknown")

    fun getHomeData() : HomeInfo {
        var homeInfo: HomeInfo = HomeInfo(
                greeting = "Hello!",
                about = AboutInfo(
                        firstName = "Arnau",
                        lastName = "Aregall",
                        nickname = "${env.get("app.contact.nickname")}",
                        job = "Senior Software Architect and Digital Transformation Consultant",
                        company = "everis (an NTT Data company)",
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
                        location = "Barcelona, Spain"
                ),
                builtWith = listOf(
                        "Java 8",
                        "Kotlin ${env.get("app.kotlinVersion")}",
                        "Spring Boot ${env.get("app.springBootVersion")}",
                        "Gradle ${env.get("app.gradleVersion")}"
                ),
                sourceCode = env.get("app.repository"),
                version = env.get("app.version"));

        return homeInfo;
    }

}