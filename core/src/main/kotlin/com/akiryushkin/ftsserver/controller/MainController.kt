package com.akiryushkin.ftsserver.controller

import com.akiryushkin.ftsserver.configuration.PythonRunnerProperties
import com.akiryushkin.ftsserver.service.PythonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RestController
@RequestMapping("/api")
class MainController {
    @Autowired
    private lateinit var pythonService: PythonService

    @GetMapping("/list_scripts")
    fun getScripts(): List<String>? {
        return pythonService.listScripts()
    }

    @GetMapping("/run/{scriptName}/{funcName}")
    fun runPythonScript(@PathVariable("scriptName") scriptName: String,
                        @PathVariable("funcName") funcName: String): String? {
        return pythonService.runScript(scriptName, funcName)
    }
}