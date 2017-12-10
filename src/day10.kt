fun main(args: Array<String>) {
    val puzzle_lengths = "206,63,255,131,65,80,238,157,254,24,133,2,16,0,1,3"
    //partOne(puzzle_lengths)


    println("" +  " -> " + stringHash("").joinToString(""))

    println("AoC 2017" +  " -> " + stringHash("AoC 2017").joinToString(""))
    println("1,2,3" +  " -> " + stringHash("1,2,3").joinToString(""))
    println("1,2,4" +  " -> " + stringHash("1,2,4").joinToString(""))
    println(puzzle_lengths +  " -> " + stringHash(puzzle_lengths).joinToString(""))


}

private fun stringHash(exInput: String): Array<String> {
    val extraLengts = arrayOf(17, 31, 73, 47, 23)
    val exInputArray = Array<Int>(exInput.length, { exInput[it].toInt() })
    //println(exInputArray.contentToString())
    val inputArray = Array<Int>(exInputArray.size + extraLengts.size, { 0 })
    System.arraycopy(exInputArray, 0, inputArray, 0, exInputArray.size)
    System.arraycopy(extraLengts, 0, inputArray, exInputArray.size, extraLengts.size)
    //println(inputArray.contentToString())

    val data_array = Array<Int>(256, { it })
    //println(data_array.contentToString())
    specialReverse2(inputArray, data_array)
    //println(data_array.contentToString())
    val denseArray = Array<Int>(16, { 0 })
    for (i in 0..15) {
        var values = Array<Int>(16, { data_array[it + (i * 16)] })
        //println(values.contentToString())
        val sum = values.reduce { a, b -> a.xor(b) }
        denseArray[i] = sum
    }
    //println()
    //println(denseArray.contentToString())

    val strArray = Array<String>(16, { denseArray[it].toString(16) })
    //println(strArray.contentToString())
    return strArray
}

private fun partOne(puzzle_lengths: String) {
    val example = "0, 1, 2, 3, 4"
    val example_len = "3, 4, 1, 5"

    val example_array = stringToArray(example)
    println(example_array.contentToString())
    val example_lenght_array = stringToArray(example_len)

    println(example_lenght_array.contentToString())
    specialReverse(example_lenght_array, example_array)
    println(example_array.contentToString())

    val puzzle_lengths_array = stringToArray(puzzle_lengths)
    val data_array = Array<Int>(256, { it })
    println(data_array.contentToString())
    specialReverse(puzzle_lengths_array, data_array)
    println(data_array.contentToString())
    println(data_array[0] * data_array[1])
}

private fun specialReverse(lengthArray: Array<Int>, data: Array<Int>) {
    var skip = 0
    var pos = 0
    for (len in lengthArray) {
        println(":len:" + len + ":skip:" + skip + ":pos:" + pos + "::" + data.contentToString())
        // Reverse the order of that length of elements in the list, starting with
        // the element at the current position.
        val halfLen = len / 2
        for (i in 0..halfLen - 1) {
            print(i.toString() + " ")
            val to = (pos + i) % data.size
            val from = (pos + (len - i - 1)) % data.size
            println("swap::" + to + " " + from)
            val tmp = data[to]
            data[to] = data[from]
            data[from] = tmp
        }
        println()
        println("Reversed::" + len + "::" + skip + "::" + pos + "::" + data.contentToString())

        // Move the current position forward by that length plus the skip size.
        pos += len + skip
        // Increase the skip size by one.
        skip++
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
            for (i in 0..halfLen - 1) {
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