package dfs

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val size = sc.nextLine().toInt()
    val node = Array(size){ arrayOfNulls<String>(size) }

    for (i in 0 until size) {
        val inputs = sc.nextLine().split("").filter { it != "" }

        for (j in 0 until size) {
            node[i][j] = inputs[j]
        }
    }

    for (k in 0 until 2) {
        var result = 0
        val visit = Array(size){ BooleanArray(size) }

        for (i in 0 until size) {
            for (j in 0 until size) {
                if (!visit[i][j]) {
                    result += 1
                    q_10026_dfs(i, j, size, node, visit, node[i][j])
                }
            }
        }

        println(result)
    }
}

private fun q_10026_dfs(i: Int, j: Int, size: Int, node: Array<Array<String?>>, visit: Array<BooleanArray>, str: String?) {
    if(i < 0 || i >= size || j < 0 || j >= size || visit[i][j] || node[i][j] != str) return
    visit[i][j] = true
    if(node[i][j] == "R") node[i][j] = "G"

    q_10026_dfs(i+1, j, size, node, visit, str)
    q_10026_dfs(i-1, j, size, node, visit, str)
    q_10026_dfs(i, j+1, size, node, visit, str)
    q_10026_dfs(i, j-1, size, node, visit, str)
}