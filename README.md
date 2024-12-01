# Advent of Code Solutions

This repository contains my solutions for the [Advent of Code](https://adventofcode.com/) challenges, implemented in Java 17.

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── adventofcode/
│   │           ├── solutions/    # Individual day solutions
│   │           ├── utils/        # Utility classes
│   │           ├── AoCSolution.java
│   │           └── Main.java
│   └── resources/
│       └── inputs/              # Puzzle inputs
└── test/
    └── java/
        └── com/
            └── adventofcode/
                └── solutions/    # Solution tests
```

## Requirements

- Java 17 or higher
- Maven 3.6 or higher

## Getting Started

1. Clone the repository:
```bash
git clone [your-repository-url]
```

2. Build the project:
```bash
mvn clean install
```

3. Run a specific solution:
```bash
mvn exec:java -Dexec.args="<day> <part>"
```

For example, to run Day 1, Part 1:
```bash
mvn exec:java -Dexec.args="1 1"
```

## Adding New Solutions

1. Create a new solution class in `src/main/java/com/adventofcode/solutions/`
2. Implement the `AoCSolution` interface
3. Add your solution to the `getSolution` method in `Main.java`
4. Place your input file in `src/main/resources/inputs/` as `dayX.txt`
5. Create corresponding tests in `src/test/java/com/adventofcode/solutions/`

## Solution Template

```java
public class DayXSolution implements AoCSolution {
    @Override
    public String solve(String input, int part) {
        return switch (part) {
            case 1 -> solvePart1(input);
            case 2 -> solvePart2(input);
            default -> throw new IllegalArgumentException("Invalid part: " + part);
        };
    }

    private String solvePart1(String input) {
        // Implement solution for part 1
        return "Not implemented yet";
    }

    private String solvePart2(String input) {
        // Implement solution for part 2
        return "Not implemented yet";
    }
}
```

## Testing

Run all tests:
```bash
mvn test
```

Run tests for a specific day:
```bash
mvn test -Dtest=Day1SolutionTest
```

## Contributing

1. Create a new branch for your solution
2. Implement your solution and tests
3. Ensure all tests pass
4. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.