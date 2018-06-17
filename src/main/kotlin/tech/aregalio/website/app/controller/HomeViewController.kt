package tech.aregalio.website.app.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import tech.aregalio.website.app.service.HomeService

@Controller
class HomeViewController @Autowired constructor(
        private val homeService: HomeService) {

    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("data", homeService.getHomeData())
        return "simple/home"
    }

}