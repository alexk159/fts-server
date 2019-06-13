package com.akiryushkin.ftsserver.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component


@Component
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
class PythonRunnerProperties {
    lateinit var scriptsPath: String
}