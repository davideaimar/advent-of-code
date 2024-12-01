package com.adventofcode;

public interface AoCSolution {
    /**
     * Solves the puzzle for the given input and part.
     *
     * @param input The puzzle input as a string
     * @param part Which part of the puzzle to solve (1 or 2)
     * @return The solution as a string
     */
    String solve(String input, int part);
}