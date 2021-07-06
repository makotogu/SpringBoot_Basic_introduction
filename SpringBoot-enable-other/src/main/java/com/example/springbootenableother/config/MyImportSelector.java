package com.example.springbootenableother.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

public class MyImportSelector implements ImportSelector {
    @Override
    public Predicate<String> getExclusionFilter() {
        return ImportSelector.super.getExclusionFilter();
    }

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.example.springbootenableother.domain.Role","com.example.springbootenableother.domain.User"};
    }
}
