fun main(args: Array<String>) {
    val puzzle = """5	1	10	0	1	7	13	14	3	12	8	10	7	12	0	6"""
    val example = """0 2 7 0"""

    println(stringToArray(example).contentToString())
    println(stringToArray(puzzle).contentToString())

    println(redistributeMemory(example))
    println(redistributeMemory(puzzle))
    println(loopSize(example))
    println(loopSize(puzzle))

}

private fun redistributeMemory(example: String): Int {
    var count = 0
    val seen: MutableList<Array<Int>> = arrayListOf()
    var current: Array<Int> = stringToArray(example)
    while (!seen.any { a -> a.contentDeepEquals(current) }) {
        //println("Loop:" + current.contentToString())
        seen.add(current.clone())
        var index = current.indexOf(current.max())
        // println(index)
        // redistribute index...
        var blocks = current[index]
        current[index] = 0
        // val redistributionTargets = findTargets(current, index)


        while (blocks > 0) {
            index++
            current[index % current.size]++
            blocks--
        }
        //println("to:" + current.contentToString())
        //println(seen)
        count++
    }
    return count
}

private fun loopSize(example: String): Int {
    var count = 0
    val seen: MutableList<Array<Int>> = arrayListOf()
    var current: Array<Int> = stringToArray(example)
    while (!seen.any { a -> a.contentDeepEquals(current) }) {
        seen.add(current.clone())
        redistribute(current)
    }
    val loop = current.clone()
    redistribute(current)
    while (!loop.contentDeepEquals(current)) {
        redistribute(current)
        count++
    }
    return count + 1
}

private fun redistribute(current: Array<Int>) {
    var index = current.indexOf(current.max())
    var blocks = current[index]
    current[index] = 0
    while (blocks > 0) {
        index++
        current[index % current.size]++
        blocks--
    }
}

private fun stringToArray(input: String) : Array<Int> {
    val values = input.split("\\s+".toRegex())
    return Array<Int>(values.size, { i -> values[i].toInt() } )
}
