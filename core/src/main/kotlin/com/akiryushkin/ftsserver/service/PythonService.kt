package com.akiryushkin.ftsserver.service;

import com.akiryushkin.ftsserver.configuration.PythonRunnerProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service;
import java.io.*
import java.io.BufferedReader
import java.io.FileWriter
import java.io.BufferedWriter




@Service
class PythonService {
    @Autowired
    lateinit var pythonRunnerProperties: PythonRunnerProperties

    fun listScripts(): List<String>? {
        val folder = File(pythonRunnerProperties.scriptsPath)
        val listOfFiles = folder.listFiles()

        return listOfFiles?.filter { it.isFile && it.extension == "py"} ?.map { it.name }
    }

    fun runScript(scriptName: String, funcName: String): String? {
        val dir = File(pythonRunnerProperties.scriptsPath)
        val p = Runtime.getRuntime().exec("python -c 'from $scriptName import *; print $funcName()'",
                null, dir)
        val `in` = BufferedReader(InputStreamReader(p.inputStream))
        val  in1 = BufferedReader(InputStreamReader(p.errorStream))

        val ret1 = in1.readLine()
        val ret2 = in1.readLine()
        val ret3 = in1.readLine()
        val ret4 = in1.readLine()
        val ret5 = in1.readLine()
        val ret = `in`.readLine()

        println(ret1 + ret2 + ret3 +ret4 + ret5)
        return ret
    }
}
