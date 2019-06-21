package com.akiryushkin.ftsserver.controller

import com.akiryushkin.ftsserver.service.PythonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api")
class MainController {
    @Autowired
    private lateinit var pythonService: PythonService

    @GetMapping("/list_scripts")
    fun getScripts(): List<String>? {
        return pythonService.listScripts()
    }

    @GetMapping("/get_script_data")
    fun getScript(@RequestParam("uuid") uuid: String): String? {
        return pythonService.getScriptData(uuid)
    }

    @GetMapping("/del_script_data")
    fun delScript(@RequestParam("uuid") uuid: String): String {
        pythonService.delScriptData(uuid)
        return "OK"
    }

    @GetMapping("/run/{scriptName}/{funcName}")
    fun runPythonScript(@PathVariable("scriptName") scriptName: String,
                        @PathVariable("funcName") funcName: String): String? {
        return pythonService.runScript(scriptName, funcName)
    }
}