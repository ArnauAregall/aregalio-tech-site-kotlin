package arnau.aregall.tech.app.domain

data class AboutInfo(
        val firstName: String,
        val lastName: String,
        val nickname: String,
        val job: String,
        val company: String,
        val skills: List<String>
)