package io.kraftsman.gcp.controllers

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    private val logger: Logger = LoggerFactory.getLogger(HomeController::class.java)

    @GetMapping("/")
    fun index(model: Model): String {
        // Get Cloud Run environment variables.
        val revision = if (System.getenv("K_REVISION") == null) "???" else System.getenv("K_REVISION")
        val service = if (System.getenv("K_SERVICE") == null) "???" else System.getenv("K_SERVICE")

        // Set variables in html template.
        model.addAttribute("revision", revision)
        model.addAttribute("service", service)

        return "index"
    }
}
