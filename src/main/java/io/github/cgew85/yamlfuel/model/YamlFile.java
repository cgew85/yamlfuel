package io.github.cgew85.yamlfuel.model;

import lombok.Data;

import java.util.List;

@Data
public class YamlFile {

    private int numberOfItems;
    private Configuration configuration;
    private List<Field> fields;
}
