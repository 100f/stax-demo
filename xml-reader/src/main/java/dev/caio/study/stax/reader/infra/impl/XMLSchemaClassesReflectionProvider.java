package dev.caio.study.stax.reader.infra.impl;

import dev.caio.study.stax.reader.domain.providers.XMLSchemaClassesProvider;
import dev.caio.study.xml.commons.definitions.XMLBlockClass;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Provedor das classes de schema que usa da tecnologia de reflection do Java para escanear um package específico que contenha
 * todas as classes de schema, definido no argumento do construtor.
 */
public class XMLSchemaClassesReflectionProvider implements XMLSchemaClassesProvider {
    private final String schemaClassesPackage;

    public XMLSchemaClassesReflectionProvider(String schemaClassesPackage) {
        this.schemaClassesPackage = schemaClassesPackage;
    }

    @Override
    public Set<Class<? extends XMLBlockClass>> get() {
        try (ScanResult scanResult = new ClassGraph().enableClassInfo().acceptPackages(schemaClassesPackage).scan()) {
            ClassInfoList classInfoList = scanResult.getSubclasses(XMLBlockClass.class);
            if (classInfoList.size() == 0) {
                return Collections.emptySet();
            }
            return buildSetFrom(classInfoList.loadClasses());
        }
        catch (Exception e) {
            e.printStackTrace();
            return Collections.emptySet();
        }
    }

    private Set<Class<? extends XMLBlockClass>> buildSetFrom(List<Class<?>> classList) {
        if (classList == null) {
            return Collections.emptySet();
        }
        Set<Class<? extends XMLBlockClass>> classSet = new HashSet<>();
        for (Class<?> clazz : classList) {
            classSet.add(castSingle(clazz));
        }
        return classSet;
    }

    @SuppressWarnings("unchecked")
    private Class<? extends XMLBlockClass> castSingle(Class<?> clazz) {
        return (Class<? extends XMLBlockClass>) clazz;
    }
}
