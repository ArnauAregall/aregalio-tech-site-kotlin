package tech.aregalio.website.app.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeViewController {

    @GetMapping("/home")
    fun home(model: Model): String {
        model.set("title", "Welcome")
        return "simple/home"
    }

}