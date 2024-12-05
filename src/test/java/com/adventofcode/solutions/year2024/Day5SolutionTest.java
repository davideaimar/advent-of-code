package com.adventofcode.solutions.year2024;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Day5SolutionTest {
    private final Day5Solution solution = new Day5Solution();

    @Test
    void testPart1WithExampleInput() {
        String exampleInput = """
                47|53
                97|13
                97|61
                97|47
                75|29
                61|13
                75|53
                29|13
                97|29
                53|29
                61|53
                97|53
                61|29
                47|13
                75|47
                97|75
                47|61
                75|61
                47|29
                75|13
                53|13

                75,47,61,53,29
                97,61,53,29,13
                75,29,13
                75,97,47,61,53
                61,13,29
                97,13,75,29,47""";
        assertEquals("143", solution.solve(exampleInput, 1));
    }

    @Test
    void testPart2WithExampleInput() {
        String exampleInput = """
                47|53
                97|13
                97|61
                97|47
                75|29
                61|13
                75|53
                29|13
                97|29
                53|29
                61|53
                97|53
                61|29
                47|13
                75|47
                97|75
                47|61
                75|61
                47|29
                75|13
                53|13

                75,47,61,53,29
                97,61,53,29,13
                75,29,13
                75,97,47,61,53
                61,13,29
                97,13,75,29,47
                """;
        assertEquals("123", solution.solve(exampleInput, 2));
    }
}