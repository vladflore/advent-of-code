from typing import List
import utils


def main():
    input_data = utils.read_input_as_list("5_input.txt")
    print(f"part 1: {solve_part_1(input_data)}")
    print(f"part 2: {solve_part_2(input_data)}")


def solve_part_1(strings: List[str]) -> int:
    count = 0
    for string in strings:
        if is_nice_1(string):
            count += 1
    return count


def is_nice_1(string: str) -> bool:
    if any(map(lambda pair: pair in string, ["ab", "cd", "pq", "xy"])):
        return False
    vowels = 0
    for ch in string:
        if ch in "aeiou":
            vowels += 1
    if vowels < 3:
        return False
    for idx, ch in enumerate(string):
        if idx < len(string) - 1:
            if ch == string[idx + 1]:
                return True
    return False


def solve_part_2(strings: List[str]) -> int:
    count = 0
    for string in strings:
        if is_nice_2(string):
            print(f"{string} is nice")
            count += 1
        else:
            print(f"{string} is naughty")
    return count


def is_nice_2(string: str) -> bool:
    return has_repeating_letter(string) and has_repeating_pair(string)


def has_repeating_letter(string: str) -> bool:
    for idx, ch in enumerate(string):
        if idx < len(string) - 2 and ch == string[idx + 2]:
            return True
    return False


def has_repeating_pair(string: str) -> bool:
    for idx, ch in enumerate(string):
        if idx < len(string) - 1:
            pair = f"{ch}{string[idx+1]}"
            if pair in string[idx + 2 :]:
                return True
    return False


if __name__ == "__main__":
    main()
