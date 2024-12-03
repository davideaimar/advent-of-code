package com.adventofcode.solutions.year2024;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.adventofcode.AoCSolution;
import com.adventofcode.annotations.Solution;

@Solution(day = 3, year = 2024)
public class Day3Solution implements AoCSolution {

    @Override
    public String solve(String input, int part) {
        return switch (part) {
            case 1 -> solvePart1(input);
            case 2 -> solvePart2(input);
            default -> null;
        };
    }

    private String solvePart1(String input) {
        int res = 0;
        Pattern regexp = Pattern.compile("mul\\((?<a>\\d+),(?<b>\\d+)\\)");
        Matcher matcher = regexp.matcher(input);
        while (matcher.find()) {
            res += Integer.valueOf(matcher.group("a")) * Integer.valueOf(matcher.group("b"));
        }
        return String.valueOf(res);
    }

    private String solvePart2(String input) {
        String adjustedInput = "";
        Pattern regexpDo = Pattern.compile("(?<do>do\\(\\))|(?<dont>don't\\(\\))");
        Matcher matcher = regexpDo.matcher(input);
        int from = 0;
        while (matcher.find()) {
            if (from != -1) {
                if (matcher.group("dont") != null) {
                    adjustedInput = adjustedInput.concat(input.substring(from, matcher.start()));
                    from = -1;
                }
            } else {
                if (matcher.group("do") != null) {
                    from = matcher.end();
                }
            }
        }
        if (from != -1) {
            adjustedInput = adjustedInput.concat(input.substring(from, input.length()));
        }
        return solvePart1(adjustedInput);
    }
}