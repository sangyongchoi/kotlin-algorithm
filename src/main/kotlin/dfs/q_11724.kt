package dfs

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val input = sc.nextLine().split(" ")
    val size = input[0].toInt()
    val number = input[1].toInt()
    val node = Array(size){ IntArray(size) }
    val visit = BooleanArray(size)

    for (i in 0 until number) {
        val input1 = sc.nextLine().split(" ")
        val a = input1[0].toInt() - 1
        val b = input1[1].toInt() - 1
        node[a][b] = 1
        node[b][a] = 1
    }

    var result = 0
    for (i in 0 until size) {
        if(!visit[i]){
            result++
            dfs(i, size, node, visit)
        }
    }

    println(result)
}

private fun dfs(i: Int, size: Int, node: Array<IntArray>, visit: BooleanArray) {
    if(visit[i]) return

    for (k in 0 until size) {
        if (node[i][k] == 1 && !visit[k]) {
            dfs(k, size, node, visit,)
        }
    }
}
