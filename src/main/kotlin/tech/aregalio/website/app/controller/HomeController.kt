package tech.aregalio.website.app.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.lang.Nullable
import org.springframework.web.bind.annotation.*
import org.springframework.ui.Model
import tech.aregalio.website.app.domain.AboutInfo
import tech.aregalio.website.app.domain.ContactInfo
import tech.aregalio.website.app.domain.HomeInfo
import tech.aregalio.website.app.service.HomeService


@RestController
class HomeController @Autowired constructor(
        private val homeService: HomeService) {

    /**
     * Basic home controller
     */
    @GetMapping("/")
    fun index() : HomeInfo {
        return homeService.getHomeData()
    }

}