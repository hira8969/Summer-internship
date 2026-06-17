package com.library.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.Map;

public class DebugEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private static final String PROPERTY_SOURCE_NAME = "libraryDebugDefaults";
    private static final String COMMAND_LINE_SOURCE_NAME = "commandLineArgs";
    private static final String SYSTEM_ENVIRONMENT_SOURCE_NAME = "systemEnvironment";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if (!environment.getSystemEnvironment().containsKey("DEBUG")
                || environment.getPropertySources().contains(PROPERTY_SOURCE_NAME)
                || commandLineDebugWasRequested(environment)) {
            return;
        }

        MapPropertySource defaults = new MapPropertySource(
                PROPERTY_SOURCE_NAME,
                Map.of("debug", "false"));
        MutablePropertySources sources = environment.getPropertySources();

        if (sources.contains(SYSTEM_ENVIRONMENT_SOURCE_NAME)) {
            sources.addBefore(SYSTEM_ENVIRONMENT_SOURCE_NAME, defaults);
        } else {
            sources.addLast(defaults);
        }
    }

    private boolean commandLineDebugWasRequested(ConfigurableEnvironment environment) {
        if (!environment.getPropertySources().contains(COMMAND_LINE_SOURCE_NAME)) {
            return false;
        }

        Object debug = environment.getPropertySources()
                .get(COMMAND_LINE_SOURCE_NAME)
                .getProperty("debug");
        return debug != null;
    }
}
