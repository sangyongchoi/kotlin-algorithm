package dfs

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val number = sc.nextInt()
    sc.nextLine()

    for (k in 0 until number) {
        val info = sc.nextLine()
        val info1 = info.split(" ")
        val width = info1[0].toInt()
        val height = info1[1].toInt()
        val numberOfPlanted = info1[2].toInt()
        val node = Array(height){ IntArray(width) }
        val visit = Array(height){ BooleanArray(width) }

        for (i in 0 until numberOfPlanted) {
            val input = sc.nextLine()
            val input1 = input.split(" ")
            node[input1[1].toInt()][input1[0].toInt()] = 1
        }

        var result = 0
        for (i in 0 until height) {
            for (j in 0 until width) {
                if(node[i][j] == 1 && !visit[i][j]) {
                    result++
                    dfs(i, j, node, visit, width, height)
                }
            }
        }
        println(result)
    }
}

private fun dfs(i: Int, j: Int, node: Array<IntArray>, visit: Array<BooleanArray>, width: Int, height: Int) {
    if(i < 0 || i >= height || j < 0 || j >= width || node[i][j] == 0 || visit[i][j]) return
    visit[i][j] = true

    dfs(i+1, j, node, visit, width, height)
    dfs(i-1, j, node, visit, width, height)
    dfs(i, j+1, node, visit, width, height)
    dfs(i, j-1, node, visit, width, height)
}

