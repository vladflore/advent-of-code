from typing import List

def read_input(file_name: str) -> str:
    with open(file_name, "r") as file:
        data = file.read().strip()
    return data


def read_input_as_list(file_name: str) -> List[str]:
    with open(file_name, "r") as file:
        data = file.read().strip().split("\n")
    return data
