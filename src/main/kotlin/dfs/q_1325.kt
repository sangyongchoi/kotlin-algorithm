package dfs

private var arr: Array<MutableList<Int>> = Array(0) { mutableListOf() }
private var n = 0
private var repeatCount = 0
private var res: Array<Int> = Array(0) { 0 }
private var check = BooleanArray(0)

fun main() {
    val firstInputs = (readLine() ?: "").split(" ")
    n = firstInputs[0].toInt()
    repeatCount = firstInputs[1].toInt()

    res = Array(n) { -1 }
    arr = Array(n) { mutableListOf() }


    repeat(repeatCount) {
        val input = (readLine() ?: "").split(" ")
        val a = input[0].toInt() - 1
        val b = input[1].toInt() - 1

        arr[a].add(b)
    }


    arr.forEachIndexed { index, _ ->
        check = BooleanArray(n + 1)
        q_1325_dfs(index)
    }

    var max = 0

    res.forEachIndexed { index, _ ->
        max = max.coerceAtLeast(res[index])
    }

    res.forEachIndexed { index, i ->
        if (i == max) {
            println("${index + 1}")
        }
    }
}

private fun q_1325_dfs(v: Int) {
    check[v] = true

    for (vv in arr[v]) {
        if (!check[vv]) {
            q_1325_dfs(vv)
            res[vv]++
        }
    }
}
