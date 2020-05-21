package io.github.cgew85.yamlfuel.services;

import io.github.cgew85.yamlfuel.model.YamlFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

@Slf4j
@Service
public class YamlService {

    public YamlFile readYamlFile() {
        Yaml yaml = new Yaml(new Constructor(YamlFile.class));
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("some.yaml");
        YamlFile yamlFile = yaml.load(inputStream);
        log.info(String.format("Number of items: %d", yamlFile.getNumberOfItems()));
        log.info(String.format("Configuration: %s", yamlFile.getConfiguration().toString()));
        yamlFile.getFields().forEach(field -> log.info(String.format("Field: title -> %s, type -> %s", field.getTitle(), field.getType())));

        return yamlFile;
    }
}
