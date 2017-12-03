fun main(args: Array<String>) {

}

private fun steps(input: Int): Int {
    val matrix = makeMatrix(input)
    val onePos = numberToPos(1, matrix)
    val pos = numberToPos(input, matrix)
}

private fun numberToPos(input: Int, matrix: Array<Array<Int>>): Pair<Int, Int> {
    return Pair(0,0)
}

private fun makeMatrix(input: Int) : Array<Array<Int>> {
    return arrayOf(arrayOf(1))
}