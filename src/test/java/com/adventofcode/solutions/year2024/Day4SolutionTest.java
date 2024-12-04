package com.adventofcode.solutions.year2024;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Day4SolutionTest {
    private final Day4Solution solution = new Day4Solution();

    @Test
    void testPart1WithExampleInput() {
        String exampleInput = """
                MMMSXXMASM
                MSAMXMSMSA
                AMXSXMAAMM
                MSAMASMSMX
                XMASAMXAMM
                XXAMMXXAMA
                SMSMSASXSS
                SAXAMASAAA
                MAMMMXMMMM
                MXMXAXMASX
                """;
        assertEquals("18", solution.solve(exampleInput, 1));
    }

    @Test
    void testPart2WithExampleInput() {
        String exampleInput = """
                MMMSXXMASM
                MSAMXMSMSA
                AMXSXMAAMM
                MSAMASMSMX
                XMASAMXAMM
                XXAMMXXAMA
                SMSMSASXSS
                SAXAMASAAA
                MAMMMXMMMM
                MXMXAXMASX
                """;
        assertEquals("9", solution.solve(exampleInput, 2));
    }
}