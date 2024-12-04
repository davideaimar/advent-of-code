package com.adventofcode.solutions.year2024;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.adventofcode.AoCSolution;
import com.adventofcode.annotations.Solution;

@Solution(day = 4, year = 2024)
public class Day4Solution implements AoCSolution {

    @Override
    public String solve(String input, int part) {
        return switch (part) {
            case 1 -> solvePart1(input);
            case 2 -> solvePart2(input);
            default -> null;
        };
    }

    private int countXMASInStrings(Iterable<String> lines) {
        var res = 0;
        Pattern pattern = Pattern.compile("XMAS");
        Pattern patternReverse = Pattern.compile("SAMX");
        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            Matcher matcherReverse = patternReverse.matcher(line);
            while (matcher.find() || matcherReverse.find())
                res++;
        }
        return res;
    }

    private String solvePart1(String input) {

        var lines = input.split("\n");
        var toCheck = new LinkedList<>(Arrays.asList(lines));

        // Create diagonals
        // From first col bottom-right
        for (int l = lines.length - 1; l >= 0; l--) {
            var j = 0;
            var i = l;
            StringBuilder newDiagonal = new StringBuilder();
            while (i < lines.length && j < lines[i].length()) {
                newDiagonal.append(lines[i].charAt(j));
                i++;
                j++;
            }
            if (newDiagonal.length() >= 4)
                toCheck.add(newDiagonal.toString());
        }
        // From first row to bottom-right
        for (int c = 1; c < lines[0].length(); c++) {
            var j = c;
            var i = 0;
            StringBuilder newDiagonal = new StringBuilder();
            while (i < lines.length && j < lines[i].length()) {
                newDiagonal.append(lines[i].charAt(j));
                i++;
                j++;
            }
            if (newDiagonal.length() >= 4)
                toCheck.add(newDiagonal.toString());
        }
        // From last col to bottom-left
        for (int l = lines.length - 1; l >= 0; l--) {
            var j = lines[0].length() - 1;
            var i = l;
            StringBuilder newDiagonal = new StringBuilder();
            while (i < lines.length && j >= 0) {
                newDiagonal.append(lines[i].charAt(j));
                i++;
                j--;
            }
            if (newDiagonal.length() >= 4)
                toCheck.add(newDiagonal.toString());
        }
        // From first row to bottom-left
        for (int c = lines[0].length() - 2; c >= 0; c--) {
            var j = c;
            var i = 0;
            StringBuilder newDiagonal = new StringBuilder();
            while (i < lines.length && j >= 0) {
                newDiagonal.append(lines[i].charAt(j));
                i++;
                j--;
            }
            if (newDiagonal.length() >= 4)
                toCheck.add(newDiagonal.toString());
        }

        // Create columns
        var columns = new StringBuilder[lines[0].length()];
        for (int i = 0; i < columns.length; i++) {
            columns[i] = new StringBuilder();
        }
        for (int l = 0; l < lines.length; l++) {
            for (int i = 0; i < lines[l].length(); i++) {
                char ch = lines[l].charAt(i);
                columns[i].append(ch);
            }
        }
        for (StringBuilder sb : columns) {
            toCheck.add(sb.toString());
        }

        return String.valueOf(countXMASInStrings(toCheck));
    }

    private String solvePart2(String input) {
        String[] lines = input.split("\n");
        int res = 0;
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length(); j++) {
                if (isXTopLeft(lines, i, j))
                    res++;
            }
        }
        return String.valueOf(res);
    }

    private boolean isXTopLeft(String[] matrix, int i, int j) {
        if (i >= matrix.length - 2 || j >= matrix[0].length() - 2) {
            return false;
        }
        var diag1 = "" + matrix[i].charAt(j) + matrix[i + 1].charAt(j + 1) + matrix[i + 2].charAt(j + 2);
        var diag2 = "" + matrix[i].charAt(j + 2) + matrix[i + 1].charAt(j + 1) + matrix[i + 2].charAt(j);
        return (diag1.equals("MAS") || diag1.equals("SAM")) && (diag2.equals("MAS") || diag2.equals("SAM"));
    }
}
