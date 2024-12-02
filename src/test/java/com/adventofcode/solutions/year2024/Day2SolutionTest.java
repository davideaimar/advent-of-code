package com.adventofcode.solutions.year2024;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Day2SolutionTest {
    private final Day2Solution solution = new Day2Solution();

    @Test
    void testPart1WithExampleInput() {
        String exampleInput = """
                62 65 67 70 73 76 75
                68 71 73 76 78 78
                77 80 81 82 86
                44 47 48 51 53 58
                51 53 56 57 59 56 57 60
                68 70 71 69 72 74 71
                59 61 63 66 64 66 66
                55 56 55 58 61 63 64 68
                3 4 5 8 11 9 10 17
                16 18 18 21 22
                70 71 73 73 74 76 78 75
                16 17 20 20 23 23
                10 12 12 15 16 17 21
                50 53 56 56 63
                1 2 5 6 8
                11 9 7 5 2
                76 74 71 69 67
                96 95 93 90 89 87 85 84
                """;
        assertEquals("4", solution.solve(exampleInput, 1));
    }

    @Test
    void testPart2WithExampleInput() {
        String exampleInput = """
                7 6 4 2 1
                1 2 7 8 9
                9 7 6 2 1
                1 3 2 4 5
                8 6 4 4 1
                1 3 6 7 9
                """;
        assertEquals("4", solution.solve(exampleInput, 2));
    }
}