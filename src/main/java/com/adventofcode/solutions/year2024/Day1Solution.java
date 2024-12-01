package com.adventofcode.solutions.year2024;

import java.util.HashMap;
import java.util.PriorityQueue;

import com.adventofcode.AoCSolution;
import com.adventofcode.annotations.Solution;

@Solution(day = 1, year = 2024)
public class Day1Solution implements AoCSolution {
    private record InnerDay1SolutionPart1(
            PriorityQueue<Integer> left,
            PriorityQueue<Integer> right) {
    }

    private record InnerDay1SolutionPart2(
            HashMap<Integer, Integer> left,
            HashMap<Integer, Integer> right) {
    }

    @Override
    public String solve(String input, int part) {
        return switch (part) {
            case 1 -> solvePart1(input);
            case 2 -> solvePart2(input);
            default -> null;
        };
    }

    private String solvePart1(String input) {
        // Split input into lines
        InnerDay1SolutionPart1 innerDay1Solution = this.parseInputPart1(input);
        int result = 0;
        // Recursively pop
        while (!innerDay1Solution.left.isEmpty()) {
            int l = innerDay1Solution.left.poll();
            int r = innerDay1Solution.right.poll();
            result += Math.abs(l - r);
        }
        return String.valueOf(result);
    }

    private InnerDay1SolutionPart1 parseInputPart1(String input) {
        String[] lines = input.split("\n");
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for (String line : lines) {
            String[] parts = line.split("\\s+");
            left.add(Integer.parseInt(parts[0]));
            right.add(Integer.parseInt(parts[1]));
        }
        return new InnerDay1SolutionPart1(left, right);
    }

    private String solvePart2(String input) {
        InnerDay1SolutionPart2 data = this.parseInputPart2(input);
        int similarity = 0;
        for (int key : data.left.keySet()) {
            if (data.right.containsKey(key)) {
                similarity += data.left.get(key) * key * data.right.get(key);
            }
        }
        return String.valueOf(similarity);
    }

    private InnerDay1SolutionPart2 parseInputPart2(String input) {
        String[] lines = input.split("\n");
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        for (String line : lines) {
            String[] parts = line.split("\\s+");
            left.merge(Integer.parseInt(parts[0]), 1, Integer::sum);
            right.merge(Integer.parseInt(parts[1]), 1, Integer::sum);
        }
        return new InnerDay1SolutionPart2(left, right);
    }
}