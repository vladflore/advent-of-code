function solvePuzzle()
    pattern = r"(?<pos1>\d*)-(?<pos2>\d*)\h(?<letter>[a-z]):\h(?<password>[a-z]+)"
    function processdata_by_line(line)
        m = match(pattern, line)
        m !== nothing ? (pos1 = parse(Int, m[:pos1]), pos2 = parse(Int, m[:pos2]), letter = m[:letter], password = m[:password]) : []
    end
    data = readlines("src/main/resources/input.data")
    p1 = 0
    p2 = 0
    for line in map(processdata_by_line, data)
        n = count(c -> (c == line.letter[1]), line.password)
        if line.pos1 <= n <= line.pos2
            p1 += 1
        end
        if line.password[line.pos1] == line.letter[1] && line.password[line.pos2] != line.letter[1] ||
            line.password[line.pos1] != line.letter[1] && line.password[line.pos2] == line.letter[1]
            p2 += 1
        end
    end
    return p1, p2
end

println(solvePuzzle())