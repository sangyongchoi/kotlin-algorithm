package dfs

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    while (true) {
        val input = sc.nextLine().split(" ")
        val width = input[0].toInt()
        val height = input[1].toInt()

        if(width == 0 && height == 0) break

        val node = Array(height){ IntArray(width) }
        val visit = Array(height) { BooleanArray(width) }

        for (i in 0 until height) {
            val input1 = sc.nextLine().split(" ")

            for (j in 0 until width) {
                node[i][j] = input1[j].toInt()
            }
        }

        var result = 0
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (node[i][j] == 1 && !visit[i][j]) {
                    result++
                    dfs(i, j, height, width, node, visit)
                }
            }
        }
        println(result)
    }
}

private fun dfs(
    i: Int,
    j: Int,
    height: Int,
    width: Int,
    node: Array<IntArray>,
    visit: Array<BooleanArray>,
) {
    if(i < 0 || j < 0 || i >=height || j >= width || node[i][j] == 0 || visit[i][j]) return
    visit[i][j] = true

    dfs(i+1, j, height, width, node, visit)
    dfs(i-1, j, height, width, node, visit)
    dfs(i, j-1, height, width, node, visit)
    dfs(i, j+1, height, width, node, visit)

    dfs(i+1, j+1, height, width, node, visit)
    dfs(i+1, j-1, height, width, node, visit)
    dfs(i-1, j+1, height, width, node, visit)
    dfs(i-1, j-1, height, width, node, visit)
}