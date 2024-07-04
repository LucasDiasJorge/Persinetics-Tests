package com.personetics.test;

import com.personetics.test.NodeInterface;

import java.util.HashSet;
import java.util.Set;

public class NumericNodeImpl implements NodeInterface {
    private final int value;

    public NumericNodeImpl(int value) {
        this.value = value;
    }

    @Override
    public Set<Integer> getDependencies() {
        Set<Integer> dependencies = new HashSet<>();
        if (value >= 0 && value <= 9) {  // Single-digit number
            dependencies.add(value);
        } else {  // Multi-digit number
            int temp = value;
            while (temp > 0) {
                dependencies.add(temp % 10);
                temp /= 10;
            }
        }
        return dependencies;
    }

}