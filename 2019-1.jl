function calculate()
    function calculateFuel(mass)
        total = 0
        while mass > 0
            fuel = mass ÷ 3 - 2
            if fuel > 0
                total += fuel
            end
            mass = fuel
        end
        total
    end
    open(joinpath(@__DIR__, "2019/1/src/main/resources/input.data")) do file
        total = 0
        for ln in eachline(file)
            total += calculateFuel(parse(Int64, ln))
        end
        total
    end
end

print(calculate())
# answer: 4914785
