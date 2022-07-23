import utils


def main():
    input = utils.read_input("1_input.txt")
    print(f"part 1: {solve_part_1(input)}")
    print(f"part 2: {solve_part_2(input)}")


def solve_part_1(input: str) -> int:
    floor_level = 0
    for ch in input:
        if ch == "(":
            floor_level += 1
        else:
            floor_level -= 1
    return floor_level


def solve_part_2(input: str) -> int:
    floor_level = 0
    for idx, ch in enumerate(input):
        if ch == "(":
            floor_level += 1
        else:
            floor_level -= 1
        if floor_level == -1:
            return idx + 1
    return floor_level


if __name__ == "__main__":
    main()
