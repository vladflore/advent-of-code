import utils


def main():
    input_data = utils.read_input("3_input.txt")
    print(f"part 1: {solve_part_1(input_data)}")
    print(f"part 2: {solve_part_2(input_data)}")


def solve_part_1(directions: str) -> int:
    current_pos = (0, 0)
    grid = dict([(current_pos, 1)])
    # grid = {current_pos: 1}
    for direction in directions:
        next_pos = compute_next_pos(current_pos, direction)
        grid[next_pos] = grid.get(next_pos, 0) + 1
        current_pos = next_pos
    return len(grid.keys())


def compute_next_pos(current_pos, direction: str):
    if direction == "^":
        next_pos = (current_pos[0], current_pos[1] + 1)
    elif direction == ">":
        next_pos = (current_pos[0] + 1, current_pos[1])
    elif direction == "v":
        next_pos = (current_pos[0], current_pos[1] - 1)
    elif direction == "<":
        next_pos = (current_pos[0] - 1, current_pos[1])
    else:
        next_pos = current_pos
    return next_pos


def solve_part_2(directions: str) -> int:
    current_pos_santa = (0, 0)
    current_pos_robo_santa = (0, 0)
    grid = dict([(current_pos_santa, 2)])
    # grid = {current_pos_santa: 2}
    for idx, direction in enumerate(directions):
        if idx % 2 == 0:
            # santa's turn
            next_pos_santa = compute_next_pos(current_pos_santa, direction)
            grid[next_pos_santa] = grid.get(next_pos_santa, 0) + 1
            current_pos_santa = next_pos_santa
        else:
            # robo santa's turn
            next_pos_robo_santa = compute_next_pos(current_pos_robo_santa, direction)
            grid[next_pos_robo_santa] = grid.get(next_pos_robo_santa, 0) + 1
            current_pos_robo_santa = next_pos_robo_santa
    return len(grid.keys())


if __name__ == "__main__":
    main()
