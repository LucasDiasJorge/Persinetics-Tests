package com.personetics.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChainValidator {

    public boolean validate(List<NodeInterface> nodes) {
        Set<Integer> singleValues = new HashSet<>();
        Set<Integer> multiDependencies = new HashSet<>();

        // Collect all single values and dependencies from multi-values
        for (NodeInterface node : nodes) {
            Set<Integer> dependencies = node.getDependencies();
            if (dependencies.size() == 1) {
                singleValues.addAll(dependencies);
            } else {
                multiDependencies.addAll(dependencies);
            }
        }

        // Validate all dependencies are covered by single values
        // multiDependencies.stream().allMatch(singleValues::contains);
        return singleValues.containsAll(multiDependencies);
    }
}