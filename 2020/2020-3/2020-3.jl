creategrid(data) = [map(el -> '.' == el[1] ? 0 : 1, collect(line)) for line in data]
extendgrid(grid, initialcols) = [[row; row[1:initialcols]] for row in grid]

function solvePuzzle()    
    data = readlines("src/main/resources/input.data")
    slopes = [[1,1],[3,1],[5,1],[7,1],[1,2]]
    
    p1ans = 0
    p2ans = 1
    for (idx, slope) in enumerate(slopes)
        grid = creategrid(data)
        cols = length(grid[1])
        initialcols = cols

        currline = 1
        currcol = 1
        totaltrees = 0
        while currline <= length(grid)
            if grid[currline][currcol] == 1
                totaltrees += 1
            end
            currline += slope[2]
            currcol += slope[1]
            if currcol >= cols - 1
                grid = extendgrid(grid, initialcols)
                cols = length(grid[1])
            end
        end
        if idx == 2
            p1ans = totaltrees    
        end
        p2ans *= totaltrees
    end
    return p1ans, p2ans
end

println(solvePuzzle())