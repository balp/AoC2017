import kotlin.math.abs
import kotlin.math.max
import kotlin.math.sqrt

fun main(args: Array<String>) {
    partOne()
    println(generateMatrixPartTwo(347991, 20))
}

private fun partOne() {
    println("0 == " + steps(1))
    println()
    println("3 == " + steps(12))
    println()
    println("2 == " + steps(23))
    println()
    println("31 == " + steps(1024))
    println()
    println("?? == " + steps(347991))
    println()
}

private fun steps(input: Int): Int {
    val matrix = makeMatrix(input)
    val onePos = numberToPos(1, matrix)
    val pos = numberToPos(input, matrix)
    println("" + onePos.first +","+ onePos.second +" "+ pos.first +","+ pos.second)
    return manhattanDistance(onePos, pos)
}

private fun manhattanDistance(from: Pair<Int,Int>, to: Pair<Int,Int>) : Int {
    val dx = abs(to.first - from.first)
    val dy = abs(to.second - from.second)
    return dx+dy
}

private fun numberToPos(input: Int, matrix: Array<Array<Int>>): Pair<Int, Int> {

    for ((x, row) in matrix.withIndex()) {
        for ((y, col) in row.withIndex()) {
            if (col == input) {
                println("found")
                return Pair(x,y)
            }
        }
    }
    throw Exception("Number not found")
}

fun generateMatrix(size: Int, initial: Int = 1): Array<Array<Int>> {
    require(size > 1)
    val matrix = Array(size) { Array(size, {0})}
    var direction = Direction.RIGHT
    var y = size / 2
    var x = if (size % 2 == 0) y - 1 else y

    for (j in initial..size * size - 1 + initial) {
        matrix[y][x] = j

        when (direction) {
            Direction.RIGHT -> if (x <= size - 1 && matrix[y - 1][x]==0 && j > initial) direction = Direction.UP
            Direction.UP -> if (matrix[y][x - 1]==0) direction = Direction.LEFT
            Direction.LEFT -> if (x == 0 || matrix[y + 1][x]==0) direction = Direction.DOWN
            Direction.DOWN -> if (matrix[y][x + 1]==0) direction = Direction.RIGHT
        }
        when (direction) {
            Direction.RIGHT -> x++
            Direction.UP -> y--
            Direction.LEFT -> x--
            Direction.DOWN -> y++
        }
    }
    //for (row in matrix) println(row.contentToString())
    //println()
    return matrix
}

fun generateMatrixPartTwo(target: Int, size: Int, initial: Int = 1): Int {
    require(size > 1)
    val matrix = Array(size) { Array(size, {0})}
    var direction = Direction.RIGHT
    var y = size / 2
    var x = if (size % 2 == 0) y - 1 else y

    for (j in initial..(size-2) * (size-2) - 1 + initial) {
        var value = 0
        value += matrix[y-1][x-1] + matrix[y+0][x-1] + matrix[y+1][x-1]
        value += matrix[y-1][x+0] + matrix[y+0][x+0] + matrix[y+1][x+0]
        value += matrix[y-1][x+1] + matrix[y+0][x+1] + matrix[y+1][x+1]
        if (value == 0) value = 1
        matrix[y][x] = value
        if (value > target) return value

        when (direction) {
            Direction.RIGHT -> if (x <= size - 1 && matrix[y - 1][x]==0 && j > initial) direction = Direction.UP
            Direction.UP -> if (matrix[y][x - 1]==0) direction = Direction.LEFT
            Direction.LEFT -> if (x == 0 || matrix[y + 1][x]==0) direction = Direction.DOWN
            Direction.DOWN -> if (matrix[y][x + 1]==0) direction = Direction.RIGHT
        }
        when (direction) {
            Direction.RIGHT -> x++
            Direction.UP -> y--
            Direction.LEFT -> x--
            Direction.DOWN -> y++
        }
    }
    for (row in matrix) println(row.contentToString())
    println()
    return 0
}

private enum class Direction { RIGHT, UP, LEFT, DOWN }

private fun makeMatrix(input: Int) : Array<Array<Int>> {
    val size: Int = max(2, sqrt(input.toDouble()).toInt()) + 1
    return generateMatrix(size)

}