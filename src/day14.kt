import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    val example = "flqrgnkx"
    val puzzle = "xlqgujun"

    //println(defragString(example))
    //println(defragString(puzzle))
    islandsInMatrix(defragToMatrix(example))
    islandsInMatrix(defragToMatrix(puzzle))
}

private fun defragString(example: String): Int {
    var sum = 0
    for (i in 0..127) {
        val input = example + "-" + i.toString()
        // println(input)
        // println(stringHash(input).joinToString(""))
        val numbers = stringHashArray(input)
        // println(numbers.contentToString())
        val strings = Array(16, { numbers[it].toString(2).padStart(8, '0') })
        //println(strings.contentToString())
        val row = strings.joinToString("")
        //println(row)
        var number = row.count { it == '1' }
        // println(number)
        sum += number

    }
    return sum
}

private fun depthFirstSearch(matrix: Array<Array<Int>>, x: Int, y: Int, count: Int) {
    matrix[x][y] = count
    // for adjent cells...
    val xlow = max(x - 1, 0)
    val xhigh = min(x + 1, 127)
    for (xp in xlow..xhigh) {
        if (matrix[xp][y] == -1) {
            depthFirstSearch(matrix, xp, y, count)
        }
    }
    val ylow = max(y - 1, 0)
    val ymax = min(y + 1, 127)
    for (yp in ylow..ymax) {
        //println(xp.toString() + "x" +yp)
        if (matrix[x][yp] == -1) {
            depthFirstSearch(matrix, x, yp, count)
        }
    }

}

private fun islandsInMatrix(matrix: Array<Array<Int>>) {
    for (x in matrix.indices) {
        for (y in matrix[x].indices) {
            matrix[x][y] *= -1
        }
    }
    println(matrix.contentDeepToString())
    var count = 0
    for (x in matrix.indices) {
        for (y in matrix[x].indices) {
            if (matrix[x][y] == -1) {
                count++
                depthFirstSearch(matrix, x, y, count)
            }
        }
    }
    println(matrix.contentDeepToString())
    println(count)


}

private fun defragToMatrix(example: String): Array<Array<Int>> {
    val result = Array<Array<Int>>(128, { Array(128, { -1 }) })
    for (i in 0..127) {
        val input = example + "-" + i.toString()
        // println(input)
        // println(stringHash(input).joinToString(""))
        val numbers = stringHashArray(input)
        // println(numbers.contentToString())
        val strings = Array(16, { numbers[it].toString(2).padStart(8, '0') })
        //println(strings.contentToString())
        val row = strings.joinToString("")
        val chars = row.toCharArray()
        val intArray = Array<Int>(128, { chars[it].toInt() - '0'.toInt() })
        //println(intArray.contentToString())
        result[i] = intArray

    }
    //println(result.contentDeepToString())
    return result
}








