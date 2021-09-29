package dfs

import java.util.*

private var x = 0
private var y = 0
private lateinit var node: Array<IntArray>
private lateinit var visit: Array<BooleanArray>
private var dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
private var max = 0
private lateinit var melt: Array<IntArray>

fun main(args: Array<String>) {
    var count = 0
    val sc = Scanner(System.`in`)
    x = sc.nextInt()
    y = sc.nextInt()
    node = Array(301) { IntArray(301) }
    visit = Array(x) { BooleanArray(y) }
    melt = Array(x) { IntArray(y) }

    for (i in 0 until x) {
        for (j in 0 until y) {
            node[i][j] = sc.nextInt()
            max = max.coerceAtLeast(node[i][j])
        }
    }
    var year = 0

    while (true) {
        count = 0
        visit = Array(x) { BooleanArray(y) }
        //print();
        melting()
        melt = Array(x) { IntArray(y) }
        for (i in 0 until x) {
            for (j in 0 until y) {
                if (node[i][j] != 0 && !visit[i][j]) {
                    count++
                    dfs(i, j)
                }
            }
        }
        if (count > 1) {
            println(year)
            break
        } else if (count == 0) {
            println(0)
            break
        }
        year++
    }
}

private fun melting() {
    for (i in 0 until x) {
        for (j in 0 until y) {
            node[i][j] = node[i][j] - melt[i][j]
            if (node[i][j] < 0) node[i][j] = 0
        }
    }
}

private fun dfs(i: Int, j: Int) {
    if (i < 0 || i >= x || j < 0 || j >= y || visit[i][j] || node[i][j] == 0) {
        return
    }
    visit[i][j] = true
    for (dir in dirs) {
        val a = i + dir[0]
        val b = j + dir[1]
        if (node[a][b] == 0) melt[i][j]++
        dfs(a, b)
    }
}