fun main(args: Array<String>) {
    val puzzleLengths = "206,63,255,131,65,80,238,157,254,24,133,2,16,0,1,3"
    partOne(puzzleLengths)


    println("" +  " -> " + stringHash("").joinToString(""))

    println("AoC 2017" +  " -> " + stringHash("AoC 2017").joinToString(""))
    println("1,2,3" +  " -> " + stringHash("1,2,3").joinToString(""))
    println("1,2,4" +  " -> " + stringHash("1,2,4").joinToString(""))
    println(puzzleLengths + " -> " + stringHash(puzzleLengths).joinToString(""))


}

private fun stringHash(exInput: String): Array<String> {
    val extraLengths = arrayOf(17, 31, 73, 47, 23)
    val exInputArray = Array(exInput.length, { exInput[it].toInt() })
    //println(exInputArray.contentToString())
    val inputArray = Array(exInputArray.size + extraLengths.size, { 0 })
    System.arraycopy(exInputArray, 0, inputArray, 0, exInputArray.size)
    System.arraycopy(extraLengths, 0, inputArray, exInputArray.size, extraLengths.size)
    //println(inputArray.contentToString())

    val dataArray = Array(256, { it })
    //println(dataArray.contentToString())
    specialReverse2(inputArray, dataArray)
    //println(dataArray.contentToString())
    val denseArray = Array(16, { 0 })
    for (i in 0..15) {
        val values = Array(16, { dataArray[it + (i * 16)] })
        //println(values.contentToString())
        val sum = values.reduce { a, b -> a.xor(b) }
        denseArray[i] = sum
    }
    //println()
    //println(denseArray.contentToString())

    //println(strArray.contentToString())
    return Array(16, { denseArray[it].toString(16) })
}

private fun partOne(puzzle_lengths: String) {
    val example = "0, 1, 2, 3, 4"
    val exampleLen = "3, 4, 1, 5"

    val exampleArray = stringToArray(example)
    println(exampleArray.contentToString())
    val exampleLengthsArray = stringToArray(exampleLen)

    println(exampleLengthsArray.contentToString())
    specialReverse(exampleLengthsArray, exampleArray)
    println(exampleArray.contentToString())

    val puzzleLengthsArray = stringToArray(puzzle_lengths)
    val dataArray = Array(256, { it })
    println(dataArray.contentToString())
    specialReverse(puzzleLengthsArray, dataArray)
    println(dataArray.contentToString())
    println(dataArray[0] * dataArray[1])
}

private fun specialReverse(lengthArray: Array<Int>, data: Array<Int>) {
    var pos = 0
    for ((skip, len) in lengthArray.withIndex()) {
        println(":len:" + len + ":skip:" + skip + ":pos:" + pos + "::" + data.contentToString())
        // Reverse the order of that length of elements in the list, starting with
        // the element at the current position.
        val halfLen = len / 2
        for (i in 0 until halfLen) {
            print(i.toString() + " ")
            val to = (pos + i) % data.size
            val from = (pos + (len - i - 1)) % data.size
            println("swap::$to $from")
            val tmp = data[to]
            data[to] = data[from]
            data[from] = tmp
        }
        println()
        println("Reversed::" + len + "::" + skip + "::" + pos + "::" + data.contentToString())

        // Move the current position forward by that length plus the skip size.
        pos += len + skip
    }
}

private fun specialReverse2(lengthArray: Array<Int>, data: Array<Int>) {
    var skip = 0
    var pos = 0
    for (loop in 0..63) {
        for (len in lengthArray) {
            //println(":len:" + len + ":skip:" + skip + ":pos:" + pos + "::" + data.contentToString())
            // Reverse the order of that length of elements in the list, starting with
            // the element at the current position.
            val halfLen = len / 2
            for (i in 0 until halfLen) {
                //print(i.toString() + " ")
                val to = (pos + i) % data.size
                val from = (pos + (len - i - 1)) % data.size
                //println("swap::" + to + " " + from)
                val tmp = data[to]
                data[to] = data[from]
                data[from] = tmp
            }
            //println()
            //println("Reversed::" + len + "::" + skip + "::" + pos + "::" + data.contentToString())

            // Move the current position forward by that length plus the skip size.
            pos += len + skip
            // Increase the skip size by one.
            skip++
        }
    }
}


private fun stringToArray(input: String): Array<Int> {
    val stringArray = input.split(",\\s*".toRegex())
    return Array(stringArray.size, {stringArray[it].toInt()})
}