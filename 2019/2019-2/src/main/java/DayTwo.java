import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * https://adventofcode.com/2019/day/2
 */
public class DayTwo {
    public static final int HALT = 99;
    public static final int ADD = 1;
    public static final int MULTIPLY = 2;
    public static final int STEP = 4;
    public static final int MAX_VALUE = 100;
    public static final int TARGET_VALUE = 19_690_720;

    public static void main(String[] args) throws IOException, URISyntaxException {
        Path path = Paths.get(Objects.requireNonNull(DayTwo.class.getClassLoader().getResource("input.data")).toURI());
        Scanner scanner = new Scanner(path);
        int[] program = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::valueOf)
                .toArray();
        for (int noun = 0; noun < MAX_VALUE; noun++) {
            for (int verb = 0; verb < MAX_VALUE; verb++) {
                int value = getMemoryValueAtAddressZero(Arrays.copyOf(program, program.length), noun, verb);
                if (value == TARGET_VALUE) {
                    System.out.println(MAX_VALUE * noun + verb);
                    // answer: 4259
                    return;
                }
            }
        }
        scanner.close();
    }

    private static int getMemoryValueAtAddressZero(int[] workingMemory, int startNoun, int startVerb) {
        workingMemory[1] = startNoun;
        workingMemory[2] = startVerb;
        int instructionPointer = 0;
        int opcode = workingMemory[instructionPointer];
        while (opcode != HALT) {
            int instrParam1 = workingMemory[instructionPointer + 1];
            int instrParam2 = workingMemory[instructionPointer + 2];
            int instrParam3 = workingMemory[instructionPointer + 3];
            if (opcode == ADD) {
                workingMemory[instrParam3] = workingMemory[instrParam1] + workingMemory[instrParam2];
            } else if (opcode == MULTIPLY) {
                workingMemory[instrParam3] = workingMemory[instrParam1] * workingMemory[instrParam2];
            }
            instructionPointer += STEP;
            if (instructionPointer > workingMemory.length - 1) {
                break;
            }
            opcode = workingMemory[instructionPointer];
        }
        return workingMemory[0];
    }
}
