fun main(args: Array<String>) {
    val match = 0b1110001101001010

    println(countMatches(40000000, SimpleGenerator(65, 16807), SimpleGenerator(8921, 48271)))
    println(countMatches(40000000, SimpleGenerator(634, 16807), SimpleGenerator(301, 48271)))

    displayMatches(SimpleGenerator(65, 16807), SimpleGenerator(8921, 48271))
    println("------------")
    displayMatches(PickyGenerator(65, 16807, 4), PickyGenerator(8921, 48271, 8))
    println(countMatches(5000000, PickyGenerator(65, 16807, 4), PickyGenerator(8921, 48271, 8)))
    println(countMatches(5000000, PickyGenerator(634, 16807, 4), PickyGenerator(301, 48271, 8)))
}

private fun displayMatches(exGeneratorA: Generator, exGeneratorB: Generator): Int {
    var count = 0
    for (i in 1..10) {
        val a = exGeneratorA.next()
        val b = exGeneratorB.next()

        println(a.toString().padStart(10) + "  "
                + b.toString().padStart(10) + " "
                + judge(a, b))

        if (judge(a, b)) {
            ++count
        }
    }
    return count
}

private fun countMatches(loops: Int, exGeneratorA: Generator, exGeneratorB: Generator): Int {
    var count = 0
    for (i in 1..loops) {
        val a = exGeneratorA.next()
        val b = exGeneratorB.next()

        //println(a.toString().padStart(10)
        //        + "  " + b.toString().padStart(10) + " " + judge(a,b))

        if (judge(a, b)) {
            ++count
        }
    }
    return count
}

private fun judge(a: Long, b: Long): Boolean {
    val filter: Long = 0b1111111111111111
    return (a and filter) == (b and filter)

}

interface Generator {
    fun next(): Long
}

class SimpleGenerator(var value: Long, var multiplier: Long) : Generator {
    val divisor = 2147483647
    override fun next(): Long {
        value = (value * multiplier) % divisor
        return value
    }
}

class PickyGenerator(var value: Long, var multiplier: Long, var dividor: Long) : Generator {
    val divisor = 2147483647
    override fun next(): Long {
        do {
            value = (value * multiplier) % divisor
        } while ((value % dividor) != 0L)
        return value
    }
}