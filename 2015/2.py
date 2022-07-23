import utils


def main():
    input = utils.read_input_as_list("2_input.txt")
    print(f"part 1: {solve_part_1(input)}")
    print(f"part 2: {solve_part_2(input)}")


def solve_part_1(dimensions: list[str]) -> int:
    total_area = 0
    for dimension in dimensions:
        l, w, h = tuple(map(int, dimension.split("x")))
        side_areas = [l * w, l * h, w * h]
        area = 2 * sum(side_areas) + min(side_areas)
        total_area += area
    return total_area


def solve_part_2(dimensions: list[str]) -> int:
    total_ribbon = 0
    for dimension in dimensions:
        l, w, h = tuple(map(int, dimension.split("x")))
        side_perimeters = [l + w, l + h, w + h]
        ribbon = 2 * min(side_perimeters) + l * w * h
        total_ribbon += ribbon
    return total_ribbon


if __name__ == "__main__":
    main()
