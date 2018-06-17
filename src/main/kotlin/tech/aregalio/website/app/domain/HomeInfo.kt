package tech.aregalio.website.app.domain

data class HomeInfo(
        val greeting: String,
        val about: AboutInfo,
        val contact: ContactInfo,
        val builtWith: List<String>,
        val sourceCode: String,
        val version: String
)