package dfs

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val size = sc.nextLine().toInt()
    val node = Array(size){ IntArray(size) }
    var max = 0

    for (i in 0 until size) {
        val inputs = sc.nextLine().split(" ")

        for (j in 0 until size) {
            node[i][j] = inputs[j].toInt()
            max = max.coerceAtLeast(node[i][j])
        }
    }
    var maxCount = 0

    for (k in 0 until max) {
        val visit = Array(size){ BooleanArray(size) }
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (node[i][j] <= k) {
                    node[i][j] = 0
                }
            }
        }

        var result = 0
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (node[i][j] >= 1 && !visit[i][j]) {
                    result++
                    dfs(i, j, size, node, visit)
                }
            }
        }

        maxCount = maxCount.coerceAtLeast(result)
    }

    println(maxCount)
}

private fun dfs(i: Int, j: Int, size: Int, node: Array<IntArray>, visit: Array<BooleanArray>) {
    if(i < 0 || j < 0 || j >= size || i >= size || node[i][j] == 0 || visit[i][j]) return
    visit[i][j] = true

    dfs(i+1, j, size, node, visit)
    dfs(i-1, j, size, node, visit)
    dfs(i, j+1, size, node, visit)
    dfs(i, j-1, size, node, visit)
}