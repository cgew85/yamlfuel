package io.github.cgew85.yamlfuel.services;

import io.github.cgew85.yamlfuel.model.YamlFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {

    private final YamlService yamlService;

    @Autowired
    public ApplicationReadyListener(YamlService yamlService) {
        this.yamlService = yamlService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        YamlFile yamlFile = yamlService.readYamlFile();
    }
}
