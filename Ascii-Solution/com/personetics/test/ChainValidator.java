package com.personetics.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

interface Node {
    Set<Integer> getDependencies();
}

class NumberNode implements Node {
    private final int value;

    public NumberNode(int value) {
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

class WordNode implements Node {
    private final String value;

    public WordNode(String value) {
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

public class ChainValidator {

    public boolean validate(List<Node> nodes) {
        Set<Integer> singleValues = new HashSet<>();
        Set<Integer> multiDependencies = new HashSet<>();

        // Collect all single values and dependencies from multi-values
        for (Node node : nodes) {
            if (node instanceof NumberNode || node instanceof WordNode) {
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
        for (Integer dep : multiDependencies) {
            if (!singleValues.contains(dep)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test cases
        List<Node> validChain1 = List.of(
                new NumberNode(36), new NumberNode(6), new NumberNode(24),
                new NumberNode(4), new NumberNode(47), new NumberNode(7),
                new NumberNode(2), new NumberNode(3), new NumberNode(27)
        );

        List<Node> validChain2 = List.of(
                new WordNode("p"), new WordNode("aba"), new WordNode("a"),
                new WordNode("b"), new WordNode("perso"), new WordNode("o"),
                new WordNode("r"), new WordNode("e"), new WordNode("s")
        );

        List<Node> invalidChain = List.of(
                new NumberNode(35), new NumberNode(5), new NumberNode(65),
                new NumberNode(6), new NumberNode(24), new NumberNode(4)
        );

        List<Node> invalidChain2 = List.of(
                new NumberNode(2), new NumberNode(5), new NumberNode(65),
                new NumberNode(6), new NumberNode(24), new NumberNode(4)
        );

        ChainValidator validator = new ChainValidator();

        System.out.println(validator.validate(validChain1)); // should print true
        System.out.println(validator.validate(validChain2)); // should print true
        System.out.println(validator.validate(invalidChain)); // should print false
        System.out.println(validator.validate(validChain2)); // should print true

    }
}
