package dfs

import java.util.*

var count = 0

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    count = sc.nextInt()
    val node = Array(count) { IntArray(count) }
    val visit = Array(count) { BooleanArray(count) }

    for (i in 0 until count) {
        val input = sc.next()
        for (j in 0 until count) {
            node[i][j] = input[j] - '0'
        }
    }

    val results = mutableListOf<Int>()

    for (i in 0 until count) {
        for (j in 0 until count) {
            if (!visit[i][j] && node[i][j] == 1) {
                results.add(dfs(node, i, j, visit))
            }
        }
    }

    println(results.size)
    results.sorted()
        .forEach{ println(it) }
}

fun dfs(node: Array<IntArray>, i: Int, j: Int, visit: Array<BooleanArray>): Int {
    if(i < 0 || j < 0 || i >= count || j >= count || node[i][j] == 0 || visit[i][j]) return 0
    visit[i][j] = true

    var count = 1

    count += dfs(node, i-1, j, visit)
    count += dfs(node, i+1, j, visit)
    count += dfs(node, i, j-1, visit)
    count += dfs(node, i, j+1, visit)

    return count
}
