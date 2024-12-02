package com.adventofcode.solutions.year2024;

import java.lang.reflect.Array;

import com.adventofcode.AoCSolution;
import com.adventofcode.annotations.Solution;

@Solution(day = 2, year = 2024)
public class Day2Solution implements AoCSolution {

    @Override
    public String solve(String input, int part) {
        return switch (part) {
            case 1 -> solvePart1(input);
            case 2 -> solvePart2(input);
            default -> null;
        };
    }

    private String solvePart1(String input) {
        String[] lines = input.split("\n");
        int res = lines.length;
        for (String line : lines) {
            if (!isLineSafe(line.split(" "))) {
                res -= 1;
            }
        }
        return String.valueOf(res);
    }

    private String solvePart2(String input) {
        String[] lines = input.split("\n");
        int res = 0;
        for (String line : lines) {
            String[] numbers = line.split(" ");
            if (isLineSafe(numbers)) {
                res += 1;
            } else {
                for (int i = 0; i < numbers.length; i++) {
                    if (isLineSafe(removeElementAtIndex(numbers, i))) {
                        res += 1;
                        break;
                    }
                }
            }
        }
        return String.valueOf(res);
    }

    public static <T> T[] removeElementAtIndex(T[] array, int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length - 1);
        System.arraycopy(array, 0, newArray, 0, index); // Copy elements before index
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1); // Copy elements after index

        return newArray;
    }

    private boolean isLineSafe(String[] numbers) {
        if (numbers.length == 0 || numbers.length == 1) {
            return true;
        }
        if (numbers[0] == numbers[1]) {
            return false;
        }

        int curr = Integer.parseInt(numbers[1]);
        int prev = Integer.parseInt(numbers[0]);
        boolean isIncreasing = curr > prev;
        for (int i = 1; i < numbers.length; i++) {
            prev = Integer.parseInt(numbers[i - 1]);
            curr = Integer.parseInt(numbers[i]);
            if (isIncreasing) {
                if (!(curr >= prev + 1 && curr <= prev + 3)) {
                    return false;
                }
            } else {
                if (!(curr <= prev - 1 && curr >= prev - 3)) {
                    return false;
                }
            }
        }
        return true;
    }
}