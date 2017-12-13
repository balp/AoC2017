fun main(args: Array<String>) {
    val example = """0: 3
1: 2
4: 4
6: 4"""
    val puzzle = """0: 5
1: 2
2: 3
4: 4
6: 6
8: 4
10: 6
12: 10
14: 6
16: 8
18: 6
20: 9
22: 8
24: 8
26: 8
28: 12
30: 12
32: 8
34: 8
36: 12
38: 14
40: 12
42: 10
44: 14
46: 12
48: 12
50: 24
52: 14
54: 12
56: 12
58: 14
60: 12
62: 14
64: 12
66: 14
68: 14
72: 14
74: 14
80: 14
82: 14
86: 14
90: 18
92: 17"""

    println(runFirewall(example))
    println(runFirewall(puzzle))

    println(clearFirewall(example))
    println(clearFirewall(puzzle))
}


private fun clearFirewall(input: String): Int {
    val layers = makeFirewall(input)

    var delay = 0
    while ((!cleanRun(layers))) {
        // println(delay.toString() + ":::" + scoreRun(layers) + ":::" + layers)
        layers.forEach { it.step() }
        delay++
        // println(delay.toString() + "+++" + scoreRun(layers) + ":::" + layers)
    }
    println(layers)
    return delay
}

private fun runFirewall(input: String): Int {
    val layers = makeFirewall(input)
    return scoreRun(layers)
}

private fun scoreRun(layers: List<Layer>): Int {
    val scoreLayers = List<Layer>(layers.size,
            { i -> layers[i].copy() })
    var score = 0
    val end = layers.last().layer
    var playerPosition = 0
    for (n in 0..end) {
        val playerLayer = scoreLayers.find { it.layer == playerPosition }
        // println("-> " + playerPosition + "::" + playerLayer)
        if (playerLayer != null && playerLayer.pos == 0) {
            //println("Got me")
            score += playerLayer.layer * playerLayer.range
        }
        scoreLayers.forEach { it.step() }
        // println(layers)
        playerPosition++
    }
    return score
}

private fun cleanRun(layers: List<Layer>): Boolean {
    val scoreLayers = List<Layer>(layers.size,
            { i -> layers[i].copy() })
    var clean = true
    val end = layers.last().layer
    var playerPosition = 0
    for (n in 0..end) {
        val playerLayer = scoreLayers.find { it.layer == playerPosition }
        if (playerLayer != null && playerLayer.pos == 0) {
            clean = false
        }
        scoreLayers.forEach { it.step() }
        playerPosition++
    }
    return clean
}

private fun makeFirewall(example: String): MutableList<Layer> {
    val layers = mutableListOf<Layer>()
    val layerMatcher = "(\\d+):\\s*(\\d+)".toRegex()
    for (line in example.lines()) {
        val matches = layerMatcher.matchEntire(line)
        if (matches != null) {
            val layer = matches.groups[1]!!.value.toInt()
            val range = matches.groups[2]!!.value.toInt()
            layers.add(Layer(layer, range))
        }
    }
    return layers
}


class Layer(val layer: Int, val range: Int) {
    var pos = 0
    var directon = 1
    fun step() {
        pos += directon
        if (pos == range - 1) {
            directon = -1
        }
        if (pos == 0) {
            directon = 1
        }

    }

    override fun toString(): String {
        var s = layer.toString() + " "
        for (i in 0..range - 1) {
            if (pos == i) {
                s += "[S]"
            } else {
                s += "[ ]"
            }
        }
        return s
    }

    fun copy(layer: Int = this.layer, range: Int = this.range): Layer {
        val new = Layer(layer, range)
        new.pos = pos
        new.directon = directon
        return new
    }
}