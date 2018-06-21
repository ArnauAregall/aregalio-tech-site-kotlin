package tech.aregalio.website.app.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import tech.aregalio.website.app.service.HomeService

@Controller
class HomeViewController @Autowired constructor(
        private val homeService: HomeService) {

    @Value("\${app.templates.index:home-simple}")
    lateinit var homeTemplate: String

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("data", homeService.getHomeData())
        return homeTemplate
    }

}