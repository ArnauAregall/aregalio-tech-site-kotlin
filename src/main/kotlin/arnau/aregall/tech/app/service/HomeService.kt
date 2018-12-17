package arnau.aregall.tech.app.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service
import arnau.aregall.tech.app.domain.AboutInfo
import arnau.aregall.tech.app.domain.ContactInfo
import arnau.aregall.tech.app.domain.HomeInfo

@Service
class HomeService @Autowired constructor(
        private val env: Environment) {

    /* Much simpler, right? */
    fun Environment.get(key: String) : String = this.getProperty(key, "unknown")

    fun getHomeData() : HomeInfo {
        var homeInfo: HomeInfo = HomeInfo(
                greeting = "Hello!",
                about = AboutInfo(
                        firstName = "AAA  rnau",
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
                        "Java 11",
                        "Kotlin ${env.get("app.kotlinVersion")}",
                        "Spring Boot ${env.get("app.springBootVersion")}",
                        "Gradle ${env.get("app.gradleVersion")}"
                ),
                sourceCode = env.get("app.repository"),
                version = env.get("app.version"));

        return homeInfo;
    }

}