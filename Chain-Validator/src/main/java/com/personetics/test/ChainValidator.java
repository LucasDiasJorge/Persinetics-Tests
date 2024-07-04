package com.personetics.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChainValidator {

    public boolean validate(List<NodeInterface> nodes) {
        Set<String> singleValues = new HashSet<>();
        Set<String> multiDependencies = new HashSet<>();

        // Collect all single values and dependencies from multi-values
        for (NodeInterface node : nodes) { // O(N)
            if (node instanceof NumericNodeImpl || node instanceof WordNodeImpl) {
                if (node.getDependencies().size() == 1) {
                    singleValues.addAll(node.getDependencies());
                } else {
                    multiDependencies.addAll(node.getDependencies());
                }
            } else {
                return false; // mixed type case
            }
        }

        // Validate all dependencies are covered by single values
        // multiDependencies.stream().allMatch(singleValues::contains);
        return singleValues.containsAll(multiDependencies);
    }
}
