package com.personetics.test;

import java.util.HashSet;
import java.util.Set;

public class WordNodeImpl implements NodeInterface {
    private final String value;

    public WordNodeImpl(String value) {
        this.value = value;
    }

    @Override
    public Set<Integer> getDependencies() {
        Set<Integer> dependencies = new HashSet<>();
        for (char ch : value.toCharArray()) {
            dependencies.add((int) ch);
        }
        return dependencies;
    }

}