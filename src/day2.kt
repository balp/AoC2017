fun main(args: Array<String>) {
    val puzzle = """3093	749	3469	142	2049	3537	1596	3035	2424	3982	3290	125	249	131	118	3138
141	677	2705	2404	2887	2860	1123	2714	117	1157	2607	1800	153	130	1794	3272
182	93	2180	114	103	1017	95	580	2179	2470	2487	2806	1574	1325	1898	1706
3753	233	3961	3747	3479	3597	1303	2612	4043	1815	3318	737	197	3943	239	254
113	147	961	157	3514	3045	1270	3528	1369	3377	492	156	1410	3251	1839	1249
3948	3651	888	3631	253	220	4266	1284	3595	237	2138	3799	2319	254	267	1182
399	446	795	653	154	762	140	487	750	457	730	150	175	841	323	492
999	979	103	99	1544	1404	100	1615	840	92	1552	1665	1686	76	113	1700
4049	182	3583	1712	200	3326	3944	715	213	1855	2990	3621	2560	842	249	2082
2610	4749	2723	2915	2189	3911	124	164	1895	3095	3992	134	127	4229	3453	4428
105	692	101	150	193	755	84	185	622	851	706	251	86	408	774	831
238	217	224	1409	1850	2604	363	265	596	2933	2641	2277	803	2557	1399	237
304	247	192	4369	997	5750	85	1248	4718	3888	5228	5116	5880	5348	6052	245
238	373	228	395	86	59	289	87	437	384	233	79	470	403	441	352
151	3473	1435	87	1517	1480	140	2353	1293	118	163	3321	2537	3061	1532	3402
127	375	330	257	220	295	145	335	304	165	151	141	289	256	195	272"""
    val example = """5 1 9 5
7 5 3
2 4 6 8"""

    val exampleArray: Array<Array<Int>> = arrayOf(arrayOf(5,1,9,5), arrayOf(7,5,3), arrayOf(2,4,6,8))

    println(exampleArray.contentToString())

    println(checkSumArray(exampleArray))
    println(checkSumArray(stringToArrays(example)))
    println(checkSumArray(stringToArrays(puzzle)))

    val ex2 = """5 9 2 8
9 4 7 3
3 8 6 5"""
    val puzzle2 = """3093	749	3469	142	2049	3537	1596	3035	2424	3982	3290	125	249	131	118	3138
141	677	2705	2404	2887	2860	1123	2714	117	1157	2607	1800	153	130	1794	3272
182	93	2180	114	103	1017	95	580	2179	2470	2487	2806	1574	1325	1898	1706
3753	233	3961	3747	3479	3597	1303	2612	4043	1815	3318	737	197	3943	239	254
113	147	961	157	3514	3045	1270	3528	1369	3377	492	156	1410	3251	1839	1249
3948	3651	888	3631	253	220	4266	1284	3595	237	2138	3799	2319	254	267	1182
399	446	795	653	154	762	140	487	750	457	730	150	175	841	323	492
999	979	103	99	1544	1404	100	1615	840	92	1552	1665	1686	76	113	1700
4049	182	3583	1712	200	3326	3944	715	213	1855	2990	3621	2560	842	249	2082
2610	4749	2723	2915	2189	3911	124	164	1895	3095	3992	134	127	4229	3453	4428
105	692	101	150	193	755	84	185	622	851	706	251	86	408	774	831
238	217	224	1409	1850	2604	363	265	596	2933	2641	2277	803	2557	1399	237
304	247	192	4369	997	5750	85	1248	4718	3888	5228	5116	5880	5348	6052	245
238	373	228	395	86	59	289	87	437	384	233	79	470	403	441	352
151	3473	1435	87	1517	1480	140	2353	1293	118	163	3321	2537	3061	1532	3402
127	375	330	257	220	295	145	335	304	165	151	141	289	256	195	272"""
    println(dividableSum(stringToArrays(ex2)))
    println(dividableSum(stringToArrays(puzzle2)))
}

private fun checkSumArray(exampleArray: Array<Array<Int>>): Int {
    var checksum = 0
    for (row in exampleArray) {

        println(row.contentToString())
        val min: Int = row.min() ?: 0
        val max: Int = row.max() ?: 0
        checksum += (max - min)
    }
    return checksum
}

private fun dividableSum(exampleArray: Array<Array<Int>>): Int {
    var checksum = 0
    for (row in exampleArray) {
        println(row.contentToString())
        for (number in row) {
            for (divisor in row) {
                println(number.toString() + "/" + divisor.toString() + "="
                        + (number.toDouble()/divisor.toDouble()))
                if (number != divisor && number % divisor == 0) {
                    checksum += number / divisor
                }
            }
        }
    }
    return checksum
}

private fun stringToArrays(input: String): Array<Array<Int>> {
    val rows: MutableList<Array<Int>> = arrayListOf()
    for (line in input.lines()) {
        println(line)
        val row: MutableList<Int> = arrayListOf()
        for (number in line.split("\\s+".toRegex())) {
            println(number)
            row.add(number.toInt())
        }
        rows.add(row.toTypedArray())
    }
    return rows.toTypedArray()
}