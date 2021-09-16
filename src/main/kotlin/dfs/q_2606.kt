package dfs

import java.util.*

val set = mutableSetOf<Int>()

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val size = sc.nextInt()
    val node = Array(size){ IntArray(size) }
    val visit = Array(size){ BooleanArray(size) }
    val count = sc.nextInt()
    sc.nextLine()
    for (i in 0 until count) {
        val input = sc.nextLine()
        val input1 = input.split(" ")
        val a = (input1[0].toInt()) - 1
        val b = (input1[1].toInt()) - 1
        node[a][b] = 1
        node[b][a] = 1
    }

    for (i in 0 until size) {
        dfs(0, i, node, visit, size)
    }

    val result = if(set.size > 0) set.size - 1 else 0
    println(result)
}

private fun dfs(i: Int, j: Int, node: Array<IntArray>, visit: Array<BooleanArray>, size: Int) {
    if(i < 0 || j < 0 || i >=size || j >= size || node[i][j] == 0 || visit[i][j]) return
    visit[i][j] = true
    set.add(i)

    for (k in 0 until size) {
        if(node[j][k] == 1 && !visit[j][k]) {
            dfs(j, k, node, visit, size)
        }
    }
}