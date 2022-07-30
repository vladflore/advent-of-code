import hashlib


def main():
    input_data = "iwrupvqb"
    print(f"part 1: {solve_part_1(input_data)}")
    print(f"part 2: {solve_part_2(input_data)}")


def solve_part_1(data: str) -> int:
    val = 1
    while True:
        md5 = hashlib.md5((data + str(val)).encode()).hexdigest()
        if md5[:5] == "00000":
            return val
        val += 1


def solve_part_2(data: str) -> int:
    val = 1
    while True:
        md5 = hashlib.md5((data + str(val)).encode()).hexdigest()
        if md5[:6] == "000000":
            return val
        val += 1


if __name__ == "__main__":
    main()
