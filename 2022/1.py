def solve_1():
    max_calories = 0
    with open("1_input.txt") as in_data:
        current_calories = 0
        for line in in_data:
            if line.strip():
                current_calories += int(line)
            else:
                if current_calories > max_calories:
                    max_calories = current_calories
                current_calories = 0
        print(max_calories)


def solve_2():
    calories_per_elf = []
    with open("1_input.txt") as in_data:
        current_calories = 0
        for line in in_data:
            if line.strip():
                current_calories += int(line)
            else:
                calories_per_elf.append(current_calories)
                current_calories = 0
    calories_per_elf.sort(reverse=True)
    total_calories = sum(calories_per_elf[:3])
    print(total_calories)


solve_1()
solve_2()
