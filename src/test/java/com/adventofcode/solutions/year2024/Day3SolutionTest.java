package com.adventofcode.solutions.year2024;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Day3SolutionTest {
    private final Day3Solution solution = new Day3Solution();

    @Test
    void testPart1WithExampleInput() {
        String exampleInput = """
                xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))
                """;
        assertEquals("161", solution.solve(exampleInput, 1));
    }

    @Test
    void testPart2WithExampleInput() {
        String exampleInput = """
                xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))
                """;
        assertEquals("48", solution.solve(exampleInput, 2));
    }
}