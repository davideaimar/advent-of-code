package com.adventofcode.solutions.year2024;

import com.adventofcode.AoCSolution;
import com.adventofcode.annotations.Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

@Solution(day = 5, year = 2024)
public class Day5Solution implements AoCSolution {

    @Override
    public String solve(String input, int part) {
        return switch (part) {
            case 1 -> solvePart1(input);
            case 2 -> solvePart2(input);
            default -> null;
        };
    }

    private String solvePart1(String input) {
        var dependencies = parseDependencies(input);
        return String.valueOf(processSequences(dependencies, input, false));
    }

    private String solvePart2(String input) {
        var dependencies = parseDependencies(input);
        return String.valueOf(processSequences(dependencies, input, true));
    }

    private HashMap<String, HashMap<Integer, HashSet<Integer>>> parseDependencies(String input) {
        HashMap<Integer, HashSet<Integer>> dependenciesBefore = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> dependenciesAfter = new HashMap<>();
        var parts = input.split("\n\n");
        for (String dependency : parts[0].split("\n")) {
            var splitted = dependency.split("\\|");
            var left = Integer.valueOf(splitted[0]);
            var right = Integer.valueOf(splitted[1]);
            dependenciesBefore.computeIfAbsent(right, k -> new HashSet<>()).add(left);
            dependenciesAfter.computeIfAbsent(left, k -> new HashSet<>()).add(right);
        }
        HashMap<String, HashMap<Integer, HashSet<Integer>>> dependencies = new HashMap<>();
        dependencies.put("before", dependenciesBefore);
        dependencies.put("after", dependenciesAfter);
        return dependencies;
    }

    private int processSequences(HashMap<String, HashMap<Integer, HashSet<Integer>>> dependencies, String input,
            boolean reordering) {
        int res = 0;
        var parts = input.split("\n\n");
        for (String printSequence : parts[1].split("\n")) {
            Integer[] steps = Arrays.stream(printSequence.split(","))
                    .map(Integer::valueOf)
                    .toArray(Integer[]::new);
            boolean valid = isValidSequence(steps, dependencies);
            if (!reordering && valid) {
                res += steps[Math.round(steps.length / 2)];
            } else if (reordering && !valid) {
                Arrays.sort(steps, getComparator(dependencies));
                res += steps[Math.round(steps.length / 2)];
            }
        }
        return res;
    }

    private boolean isValidSequence(Integer[] steps, HashMap<String, HashMap<Integer, HashSet<Integer>>> dependencies) {
        if (steps.length == 1) {
            return true;
        }
        for (int i = 0; i < steps.length; i++) {
            var toPrint = steps[i];
            var mustBeBefore = dependencies.get("before").get(toPrint);
            var mustBeAfter = dependencies.get("after").get(toPrint);
            if (mustBeBefore != null) {
                for (int dependency : mustBeBefore) {
                    if (Arrays.asList(steps).indexOf(dependency) >= i) {
                        return false;
                    }
                }
            }
            if (mustBeAfter != null) {
                for (int dependency : mustBeAfter) {
                    var indexOf = Arrays.asList(steps).indexOf(dependency);
                    if (indexOf > -1 && indexOf <= i) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private Comparator<Integer> getComparator(HashMap<String, HashMap<Integer, HashSet<Integer>>> dependencies) {
        return (o1, o2) -> {
            if (dependencies.get("before").get(o1) != null && dependencies.get("before").get(o1).contains(o2)) {
                return -1;
            }
            if (dependencies.get("before").get(o2) != null && dependencies.get("before").get(o2).contains(o1)) {
                return 1;
            }
            if (dependencies.get("after").get(o1) != null && dependencies.get("after").get(o1).contains(o2)) {
                return 1;
            }
            if (dependencies.get("after").get(o2) != null && dependencies.get("after").get(o2).contains(o1)) {
                return -1;
            }
            return 0;
        };
    }
}