function get_data_from_file(filepath)
    open(filepath) do file
        return [parse(Int, ln) for ln in eachline(file)]
    end
end

function solvePartOne()
    for i in 1:length(data) - 1, j in i + 1:length(data)
        if data[i] + data[j] == 2020
            return data[i] * data[j]
        end
    end
end

function solvePartTwo() 
    for i in 1:length(data) - 2, j in i + 1:length(data) - 1, k in i + 1:length(data)
        if data[i] + data[j] + data[k] == 2020
            return data[i] * data[j] * data[k]
        end
    end
end

data = get_data_from_file("src/main/resources/input.data")
println(solvePartOne())
println(solvePartTwo())