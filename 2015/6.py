from typing import List
import utils
import re


def main():
    input_data = utils.read_input_as_list("6_input.txt")
    print(f"part 1: {solve_part_1(input_data)}")
    print(f"part 2: {solve_part_2(input_data)}")


def solve_part_1(instructions: List[str]) -> int:
    grid = [[0 for j in range(1000)] for i in range(1000)]
    for instruction in instructions:
        coords = re.search(
            r"(turn (?:on|off)|toggle) (\d+,\d+) through (\d+,\d+)", instruction
        )
        if coords:
            command = coords[1]
            c1 = tuple(map(int, coords[2].split(",")))
            c2 = tuple(map(int, coords[3].split(",")))
            for i in range(c1[0], c2[0] + 1):
                for j in range(c1[1], c2[1] + 1):
                    if command == "turn on":
                        grid[i][j] = 1
                    elif command == "turn off":
                        grid[i][j] = 0
                    else:
                        if grid[i][j] == 0:
                            grid[i][j] = 1
                        else:
                            grid[i][j] = 0
    return sum(map(sum, grid))


def solve_part_2(instructions: List[str]) -> int:
    grid = [[0 for j in range(1000)] for i in range(1000)]
    for instruction in instructions:
        coords = re.search(
            r"(turn (?:on|off)|toggle) (\d+,\d+) through (\d+,\d+)", instruction
        )
        if coords:
            command = coords[1]
            c1 = tuple(map(int, coords[2].split(",")))
            c2 = tuple(map(int, coords[3].split(",")))
            for i in range(c1[0], c2[0] + 1):
                for j in range(c1[1], c2[1] + 1):
                    if command == "turn on":
                        grid[i][j] += 1
                    elif command == "turn off":
                        grid[i][j] -= 1
                        if grid[i][j] < 0:
                            grid[i][j] = 0
                    else:
                        grid[i][j] += 2
    return sum(map(sum, grid))


if __name__ == "__main__":
    main()
